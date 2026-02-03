package com.example.urlshortener;

import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

@Controller
public class UrlController
{

    @Autowired
    private UrlService urlService;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request)
    {
        model.addAttribute("urlLink", new UrlLink());
        model.addAttribute("links", urlService.getAll());

        String baseUrl = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 80 && request.getServerPort() != 443)
        {
            baseUrl += ":" + request.getServerPort();
        }
        model.addAttribute("baseUrl", baseUrl);

        return "index";
    }

    @PostMapping("/shorten")
    public String shorten(@Valid @ModelAttribute UrlLink urlLink,
                          BindingResult result,
                          Model model,
                          RedirectAttributes redirect)
    {
        if (result.hasErrors())
        {
            model.addAttribute("links", urlService.getAll());
            return "index";
        }
        UrlLink saved = urlService.shortenUrl(urlLink.getOriginalUrl());
        String fullShortUrl = "http://localhost:8080/" + saved.getShortCode();
        redirect.addFlashAttribute("message", "Ссылка сокращена!");
        redirect.addFlashAttribute("shortUrl", fullShortUrl);
        return "redirect:/";
    }

    @GetMapping("/{shortCode}")
    public String redirect(@PathVariable String shortCode)
    {
        return urlService.getByShortCode(shortCode)
                .map(link -> "redirect:" + link.getOriginalUrl())
                .orElse("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect)
    {
        urlService.delete(id);
        redirect.addFlashAttribute("message", "Ссылка удалена!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, RedirectAttributes redirect)
    {
        Optional<UrlLink> optional = urlService.findById(id);
        if (optional.isPresent())
        {
            model.addAttribute("urlLink", optional.get());
            return "edit";
        }
        redirect.addFlashAttribute("error", "Ссылка не найдена");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute UrlLink formUrlLink,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirect)
    {
        if (result.hasErrors())
        {
            model.addAttribute("links", urlService.getAll());
            return "edit";
        }

        Optional<UrlLink> existingOpt = urlService.findById(formUrlLink.getId());
        if (existingOpt.isEmpty())
        {
            redirect.addFlashAttribute("error", "Ссылка не найдена");
            return "redirect:/";
        }

        UrlLink existing = existingOpt.get();

        existing.setOriginalUrl(formUrlLink.getOriginalUrl());
        urlService.update(existing);

        redirect.addFlashAttribute("message", "Ссылка обновлена!");
        return "redirect:/";
    }
}