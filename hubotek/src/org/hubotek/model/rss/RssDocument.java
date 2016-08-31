package org.hubotek.model.rss;

import java.util.ArrayList;
import java.util.List;
import org.hubotek.model.Document;

public class RssDocument implements Document{

	private RssBody rssBody; 
	private RssImage rssImage; 
	private List<RssItem> rssItems; 
	
	public RssDocument(){
		rssItems = new ArrayList<RssItem>();
	}
	
	public RssDocument(RssBody body,RssImage image,List<RssItem>items)
	{ 
		this.rssBody = body; 
		this.rssImage= image; 
		this.rssItems = items;
	}

	public RssBody getRssBody() {
		return rssBody;
	}

	public void setRssBody(RssBody rssBody) {
		this.rssBody = rssBody;
	}

	public RssImage getRssImage() {
		return rssImage;
	}

	public void setRssImage(RssImage rssImage) {
		this.rssImage = rssImage;
	}

	public List<RssItem> getRssItems() {
		return rssItems;
	}

	public void setRssItems(List<RssItem> rssItems) {
		this.rssItems = rssItems;
	}
	
}
