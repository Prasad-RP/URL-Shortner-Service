package com.url.shortner.service.impl;

import static com.url.shortner.dto_mapper.URLMapper.TO_URL;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.url.shortner.dto.Url;
import com.url.shortner.entity.UrlMaster;
import com.url.shortner.repository.UrlRepository;
import com.url.shortner.service.UrlService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UrlServiceImpl implements UrlService {

	private final UrlRepository urlRepository;

	@Override
	public Optional<Url> persistUrl(UrlMaster urlMaster) {
		return TO_URL.apply(urlRepository.save(urlMaster));
	}

	@Override
	public Optional<Url> getShortenedUrl(String url) throws Exception {
		return TO_URL.apply(urlRepository.findByShortenedUrl(url).orElseThrow(() -> new Exception("Url Not found.")));
	}

}
