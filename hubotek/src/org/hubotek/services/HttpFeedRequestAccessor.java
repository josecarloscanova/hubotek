package org.hubotek.services;

import java.net.URI;

import org.hubotek.HubotekException;
import org.hubotek.google.news.feed.DomParser;
import org.hubotek.http.ResponseCallback;
import org.hubotek.model.rss.RssDocument;
import org.hubotek.model.rss.RssDocumentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

//TODO: Change the name of the class.
public class HttpFeedRequestAccessor extends HttpRequestAccessor<RssDocument>{
	
	@Autowired
	DomParser feedParser; 
	
	@Override
	public  RssDocument doRequest(String location, ResponseCallback callback)
	{ 
		Document rssDocument = null;
		RssDocument hubDocument = null;
		
		try { 
				ClientHttpRequest request = this.createRequest(new URI(location), HttpMethod.GET);
				ClientHttpResponse response = request.execute();
				if (response.getStatusCode() == HttpStatus.OK)
				{ 
					rssDocument = feedParser.parseFeed(new InputSource(response.getBody()));
					hubDocument = new RssDocumentBuilder().withDocument(rssDocument).build();
				}
		}catch (Exception ex)
		{ 
			throw new HubotekException(ex);
		}
		return hubDocument;
	}

}
