package org.hubotek.google.news;

import java.util.concurrent.ExecutionException;
import org.hubotek.HubotekException;
import org.hubotek.model.rss.RssDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 	CF("cf"), //limited ti q(quotes),i(images),b(blogs)
	HL("hl"),
	PZ("pz"), //limited to 0-1
	NED("ned"),
	QUERY("q"),
	NUM("num"),
	OUTPUT("output"),
	COUNTRY("gl"),
	LATITUDE_LONGITUDE("gll"),
	REGION("gr"),
	METRO("gm"),
	ZIPCODE("gpc"),
	CITY("gcs"),
	SCORING("scoring"),//limited to r,n,d,o
	EXACT_PHRASE("as_epq");
 * @author user
 *
 */

@RestController
public class GoogleRestController {

	@Autowired 
	private GoogleNewsFeed googleNewsFeed;
	
	@RequestMapping(name="/googleNews",method=RequestMethod.GET)
	public RssDocument getGoogleNewsFeed(@RequestParam(value="lang", defaultValue="en_US") String lang , 
										 @RequestParam(value="num" , defaultValue="5") String count , 
										 @RequestParam(value="topic" , defaultValue="all") String topic , 
										 @RequestParam(value="query" , defaultValue="") String query , 
										 @RequestParam(value="output" , defaultValue="rss") String output , 
										 @RequestParam(value="edition" , defaultValue="en") String edition , 
										 @RequestParam(value="scoring" , defaultValue="r") String scoring ,
										 @RequestParam(value="city" , defaultValue="")String city) {
		RssDocument document = null;
		try {
				GoogleNewsUrlBuilder googleUrlBuilder = new GoogleNewsUrlBuilder();
				googleUrlBuilder.withResultCount(count).withLang(lang).withQuery(query).withTopic(topic).withOutput(output).withEdition(edition).withScoring(scoring).withCity(city);
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