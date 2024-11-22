package com.url.shortner.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.url.shortner.dto.Url;
import com.url.shortner.entity.UrlMaster;

@Transactional(readOnly = false)
public interface UrlService {

	Optional<Url> persistUrl(UrlMaster urlMaster);

	Optional<Url> getShortenedUrl(String url) throws Exception;

}
