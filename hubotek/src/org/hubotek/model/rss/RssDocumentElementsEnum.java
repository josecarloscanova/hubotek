package org.hubotek.model.rss;

import org.hubotek.ElementEnum;

public enum RssDocumentElementsEnum implements ElementEnum<String>{
	
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

	@Override
	public String valueOf() {
		return elementName;
	}
	
}
