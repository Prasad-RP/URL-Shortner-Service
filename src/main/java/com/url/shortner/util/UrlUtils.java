package com.url.shortner.util;

import static com.url.shortner.dto_mapper.URLMapper.TO_URL_MASTER;
import static com.url.shortner.util.EncryptUtils.encrypt;

import java.time.LocalDateTime;

import com.url.shortner.dto.Url;
import com.url.shortner.entity.UrlMaster;

public class UrlUtils {

	private UrlUtils() {
	}

	public static UrlMaster toPersistUrl(Url url) throws Exception {
		UrlMaster master = TO_URL_MASTER.apply(url)
				.orElseThrow(() -> new Exception("Unable to convert entity to dto."));
		master.setShortenedUrl(encrypt(url.getOriginalUrl()));
		master.setCreatedDate(LocalDateTime.now());
		return master;
	}
}
