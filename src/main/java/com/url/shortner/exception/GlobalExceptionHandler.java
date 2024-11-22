package com.url.shortner.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public Map<Object, Object> handleException(Exception ex) {
		Map<Object, Object> map = new HashMap<>();
		map.put("Message", ex.getLocalizedMessage());
		map.put("Success", false);
		return map;
	}
}
