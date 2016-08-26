package org.hubotek.services.google;

import java.net.URI;
import java.util.concurrent.Future;

import org.hubotek.google.news.RssDocument;
import org.hubotek.services.HttpRequestAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

//Still on design...
@Service
public class GoogleNewsFeed  {
	
	@Autowired
	private HttpRequestAccessor httpRequestAcessor;
	
	public GoogleNewsFeed(){ 
	}

	public HttpRequestAccessor getHttpRequestAcessor() {
		return httpRequestAcessor;
	}

	public void setHttpRequestAcessor(HttpRequestAccessor httpRequestAcessor) {
		this.httpRequestAcessor = httpRequestAcessor;
	}

	@Async
	public Future<RssDocument> requestNewsFeed(URI url)
	{ 
		String baseUrl = "https://news.google.com/news?cf=all&hl=en&pz=1&ned=us&output=rss";
		return new AsyncResult<RssDocument>(httpRequestAcessor.doRequest(baseUrl , null));
	}

}
