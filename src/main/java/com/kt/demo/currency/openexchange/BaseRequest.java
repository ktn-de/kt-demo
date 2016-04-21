package com.kt.demo.currency.openexchange;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public abstract class BaseRequest {
	String path;
	MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MultiValueMap<String, String> getParams() {
		return params;
	}

	public void setParams(MultiValueMap<String, String> params) {
		this.params = params;
	}

}