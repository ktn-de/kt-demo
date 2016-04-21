package com.kt.demo.currency.openexchange;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OpenExchangeConnector {

	private static final Logger log = LoggerFactory.getLogger(OpenExchangeConnector.class);

	private static final String TARGET_SERVER_URL = "https://openexchangerates.org";
	private static final String APP_ID = "c21795211eeb452bb96facb47bd4b33c";

	private URI buildURI(String path, MultiValueMap<String, String> params) {
		if (!params.containsKey("app_id")) {
			params.add("app_id", APP_ID);
		}
		URI uri = UriComponentsBuilder.fromHttpUrl(TARGET_SERVER_URL)
				.path(path)
				.queryParams(params)
				.build().toUri();
		log.info("build: uri=" + uri);
		return uri;
	}

	public <T> T getResponse(String path, MultiValueMap<String, String> params, Class<T> responseType) {
		URI uri = buildURI(path, params);
		T results = new RestTemplate().getForObject(uri, responseType);
		log.info("results: " + results);
		return results;
	}

}