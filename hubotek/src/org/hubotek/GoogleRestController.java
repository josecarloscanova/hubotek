package org.hubotek;

import java.util.concurrent.ExecutionException;

import org.hubotek.google.news.RssDocument;
import org.hubotek.services.google.GoogleNewsFeed;
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
	public RssDocument getGoogleNewsFeed(@RequestParam(value="lang", defaultValue="en_US") String lang , @RequestParam(value="num" , defaultValue="5") String count , @RequestParam(value="topic" , defaultValue="all") String topic , @RequestParam(value="query" , defaultValue="") String query , @RequestParam(value="output" , defaultValue="rss") String output) {
		RssDocument document = null;
		try {
			  document =  googleNewsFeed.requestNewsFeed(null).get();
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