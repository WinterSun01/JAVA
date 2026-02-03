package com.example.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService
{

    @Autowired
    private UrlLinkRepository repository;

    public UrlLink shortenUrl(String originalUrl)
    {
        UrlLink link = new UrlLink(originalUrl);

        String code = Base64.getUrlEncoder().withoutPadding()
                .encodeToString((originalUrl + System.currentTimeMillis()).getBytes())
                .substring(0, 8)
                .replaceAll("[^a-zA-Z0-9]", "");

        while (repository.findByShortCode(code).isPresent())
        {
            code = code.substring(0, 6) + new Random().nextInt(10);
        }

        link.setShortCode(code);
        return repository.save(link);
    }

    public Optional<UrlLink> getByShortCode(String shortCode)
    {
        return repository.findByShortCode(shortCode);
    }

    public Iterable<UrlLink> getAll()
    {
        return repository.findAll();
    }

    public void delete(Long id)
    {
        repository.deleteById(id);
    }

    public Optional<UrlLink> findById(Long id)
    {
        return repository.findById(id);
    }

    public UrlLink update(UrlLink link)
    {
        return repository.save(link);
    }
}