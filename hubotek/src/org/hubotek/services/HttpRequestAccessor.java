package org.hubotek.services;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

import org.hubotek.HubotekException;
import org.hubotek.google.news.feed.FeedParser;
import org.hubotek.http.ResponseCallback;
import org.hubotek.rss.RssDocument;
import org.hubotek.rss.RssDocumentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpAccessor;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

//TODO: Change the name of the class.
public class HttpRequestAccessor extends HttpAccessor{
	
	public Boolean isHttpClient = false;
	
	@Autowired
	FeedParser feedParser; 
	
	
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
	
	public RssDocument doRequest(String location, ResponseCallback callback) 
	{ 
		Document rssDocument = null;
		try { 
				ClientHttpRequest request = this.createRequest(new URI(location), HttpMethod.GET);
				ClientHttpResponse response = request.execute();
				if (response.getStatusCode() == HttpStatus.OK)
				{ 
					HttpHeaders headers = response.getHeaders();
					Iterator<String> headerKeyIterator = headers.keySet().iterator();
					while (headerKeyIterator.hasNext()){ 
						String headerKey = headerKeyIterator.next();
						List<String> headerValues = headers.getValuesAsList(headerKey);
						StringBuffer sb = new StringBuffer();
						for (String headerValue: headerValues){ 
							sb.append(headerValue).append(" ");
						}
					}
//					FileInputStream fis = new FileInputStream(new File("C:\\cygwin64\\home\\user\\hubotek\\hubotek\\war\\google_news_feed_sample.xml"));
//					rssDocument = feedParser.parseRssFeed(new InputSource(fis));
					//TODO: remove the parser from the request accessor.
					rssDocument = feedParser.parseRssFeed(new InputSource(response.getBody()));
				}
		}catch (Exception ex)
		{ 
			throw new HubotekException(ex);
		}
		return new RssDocumentBuilder().withDocument(rssDocument).build();
	}
}
