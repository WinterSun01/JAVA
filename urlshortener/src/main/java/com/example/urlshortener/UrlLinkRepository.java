package com.example.urlshortener;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UrlLinkRepository extends JpaRepository<UrlLink, Long>
{

    Optional<UrlLink> findByShortCode(String shortCode);
}