package org.hubotek.services;

import org.hubotek.http.ResponseCallback;
import org.springframework.http.client.support.HttpAccessor;

public abstract class HttpBaseRequestAccessor<T> extends HttpAccessor{

public Boolean isHttpClient = false;
	
	public HttpBaseRequestAccessor()
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
