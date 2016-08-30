package org.hubotek.rss;

public enum RssDocumentElementsEnum {
	
	GENERATOR ("generator"),
	TITLE ("title"),
	LINK ("link"), 
	LANGUAGE("language"), 
	WEBMASTER("webMaster"),
	COPYRIGHT("copyright"),
	PUBDATE ("pubDate"), 
	LASTBUILDDATE ("lastBuildDate"),
	URL("url"),
	GUID("guid"),
	CATEGORY("category"),
	DESCRIPTION("description");
	
	private String elementName;
	
	private RssDocumentElementsEnum(String elementName)
	{ 
		this.elementName = elementName;
	}

	public String elementName() {
		return elementName;
	}
	
}
