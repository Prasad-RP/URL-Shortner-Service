package com.url.shortner.util;

import static com.google.common.hash.Hashing.murmur3_32_fixed;
import static java.nio.charset.StandardCharsets.UTF_8;

public class EncryptUtils {
	private EncryptUtils() {
	}
	
	public static String encrypt(String url) {
		return murmur3_32_fixed().hashString(url, UTF_8).toString();
	}
	
	
}
