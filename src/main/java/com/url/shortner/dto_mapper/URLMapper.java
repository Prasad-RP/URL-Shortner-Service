package com.url.shortner.dto_mapper;

import static com.url.shortner.util.CollectionUtil.newList;
import static com.url.shortner.util.FunctionUtil.evalMapper;
import static com.url.shortner.util.FunctionUtil.evalMapperCollection;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.url.shortner.dto.Url;
import com.url.shortner.entity.UrlMaster;

public class URLMapper {
	private URLMapper() {}

	public static final Function<UrlMaster, Optional<Url>> TO_URL = e -> evalMapper(e, Url.class);

	public static final Function<Url, Optional<UrlMaster>> TO_URL_MASTER = e -> evalMapper(e,
			UrlMaster.class);

	public static final Function<List<UrlMaster>, List<Url>> TO_URLS = e -> newList(
			evalMapperCollection(e, Url.class));

	public static final Function<List<Url>, List<UrlMaster>> TO_URL_MASTERS = e -> newList(
			evalMapperCollection(e, UrlMaster.class));
}
