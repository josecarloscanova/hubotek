package org.hubotek.model.rss;

public class RssItem
{ 

	private String title; 
	private String link; 
	private String guid; 
	private String category;
	private String pubDate;
	private String description;
	
	public RssItem(){}
	
	
	public RssItem(String title, String link, String guid, String category, String pubDate, String description) {
		super();
		this.title = title;
		this.link = link;
		this.guid = guid;
		this.category = category;
		this.pubDate = pubDate;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}