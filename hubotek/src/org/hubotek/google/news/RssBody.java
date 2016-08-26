package org.hubotek.google.news;

public class RssBody 
{ 
	private String generator;
	private String title;
	private String link;
	private String language; 
	private String webMaster; 
	private String copyright;
	private String pubDate; 
	private String lastBuildDate; 

	public RssBody(){}
	
	

	public RssBody(String generator, String title, String link, String language, String webMaster, String copyright,
			String pubDate, String lastBuildDate) {
		super();
		this.generator = generator;
		this.title = title;
		this.link = link;
		this.language = language;
		this.webMaster = webMaster;
		this.copyright = copyright;
		this.pubDate = pubDate;
		this.lastBuildDate = lastBuildDate;
	}



	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	
}