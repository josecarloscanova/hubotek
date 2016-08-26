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
	public RssDocument getGoogleNewsFeed(@RequestParam(value="lang", defaultValue="en_US") String lang) {
		RssDocument document = null;
		try {
			 //TODO: a timeout manager.. here.
			  document =  googleNewsFeed.requestNewsFeed(null).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new HubotekException(e);
		}
		return document;
	}
	
//	@GetMapping(path = "/hubotek1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping("/hubotek1")
//	@JsonView(BlogData.class)
//	@ResponseBody
//	public BlogData getBlogDataById(Model model)
//	{
//		return new BlogData(1000);
//	}
	
	public GoogleNewsFeed getGoogleNewsFeed() {
		return googleNewsFeed;
	}

	public void setGoogleNewsFeedParser(GoogleNewsFeed googleNewsFeedParser) {
		this.googleNewsFeed = googleNewsFeedParser;
	}

}