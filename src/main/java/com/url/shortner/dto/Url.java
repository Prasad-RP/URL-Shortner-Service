package com.url.shortner.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Url {
	
	private Long urlId;

	private String originalUrl;

	private String shortenedUrl;

	private LocalDateTime createdDate;

	private LocalDateTime expirationDate;
	
}
