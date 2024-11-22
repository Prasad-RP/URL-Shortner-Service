package com.url.shortner.util;

import static com.google.common.hash.Hashing.murmur3_32_fixed;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.UUID.randomUUID;

public class EncryptUtils {
	private EncryptUtils() {
	}

	public static String encrypt(String url) {
		// Adding a unique salt (can use UUID or any random value)
		return murmur3_32_fixed().hashString(url + randomUUID().toString(), UTF_8).toString();
	}

}
