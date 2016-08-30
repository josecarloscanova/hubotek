package org.hubotek.google.news;

import java.util.concurrent.ExecutionException;

import org.hubotek.HubotekException;
import org.hubotek.rss.RssDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleRestController {

	@Autowired 
	private GoogleNewsFeed googleNewsFeed;
	
	@RequestMapping(name="/googleNews",method=RequestMethod.GET)
	public RssDocument getGoogleNewsFeed(@RequestParam(value="lang", defaultValue="en_US") String lang , @RequestParam(value="num" , defaultValue="5") String count , @RequestParam(value="topic" , defaultValue="all") String topic , @RequestParam(value="query" , defaultValue="") String query , @RequestParam(value="output" , defaultValue="rss") String output , @RequestParam(value="edition" , defaultValue="en") String edition) {
		RssDocument document = null;
		try {
				GoogleNewsUrlBuilder googleUrlBuilder = new GoogleNewsUrlBuilder();
				googleUrlBuilder.withResultCount(count).withLang(lang).withQuery(query).withResultCount(count).withTopic(topic).withOutput(output);
				document =  googleNewsFeed.requestNewsFeed(googleUrlBuilder.build()).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new HubotekException(e);
		}
		return document;
	}
	
	public GoogleNewsFeed getGoogleNewsFeed() {
		return googleNewsFeed;
	}

	public void setGoogleNewsFeedParser(GoogleNewsFeed googleNewsFeedParser) {
		this.googleNewsFeed = googleNewsFeedParser;
	}

}