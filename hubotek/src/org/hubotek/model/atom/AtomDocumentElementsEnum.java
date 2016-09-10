package org.hubotek.model.atom;

public enum AtomDocumentElementsEnum {
	
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
	
	private AtomDocumentElementsEnum(String elementName)
	{ 
		this.elementName = elementName;
	}

	public String elementName() {
		return elementName;
	}
}
