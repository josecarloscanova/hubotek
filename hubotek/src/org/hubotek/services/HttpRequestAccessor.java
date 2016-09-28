package org.hubotek.services;

import org.hubotek.google.news.feed.DomParser;
import org.hubotek.http.ResponseCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.HttpAccessor;

public abstract class HttpRequestAccessor <T> extends HttpAccessor{

	public Boolean isHttpClient = false;
	
	@Autowired
	protected DomParser parser;

	public HttpRequestAccessor()
	{ 
		super();
	}
	
	public Boolean getIsHttpClient() {
		return isHttpClient;
	}

	public void setIsHttpClient(Boolean isHttpClient) {
		this.isHttpClient = isHttpClient;
	}
	
	
	public abstract T doRequest(String location, ResponseCallback callback);
	
}
