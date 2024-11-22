package com.url.shortner.api;

import static com.url.shortner.util.UrlUtils.toPersistUrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.url.shortner.dto.Url;
import com.url.shortner.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/url")
public class URLApi {

	private final UrlService urlService;

	@PostMapping
	ResponseEntity<Map<Object, Object>> persistUrl(@RequestBody Url url) throws Exception {
		Map<Object, Object> map = new HashMap<>();
		log.info("persisiting url");
		map.put("Data", urlService.persistUrl(toPersistUrl(url)));
		map.put("Success", true);
		return ResponseEntity.ok(map);
	}

	@GetMapping("/{shortLink}")
	public ResponseEntity<Map<Object, Object>> redirectToOriginalUrl(@PathVariable String shortLink,
			HttpServletResponse response) throws Exception {
		Map<Object, Object> map = new HashMap<>();
		log.info("getting url");
		Url url = urlService.getShortenedUrl(shortLink).orElseThrow(() -> new Exception("Invalid Url."));
		map.put("Data", url);
		map.put("Success", true);
		// redirecting to the original URL.
		response.sendRedirect(url.getOriginalUrl());
		return ResponseEntity.ok(map);
	}

}
