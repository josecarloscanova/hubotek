package org.hubotek.google.news;

public enum GoogleNewsUrlParametersEnum {
	
	CF("cf"),
	HL("hl"),
	PZ("pz"),
	NED("ned"),
	QUERY("q"),
	NUM("num"),
	OUTPUT("output");
	
	private String urlParameter;

	private GoogleNewsUrlParametersEnum(String urlParameter){
		this.urlParameter = urlParameter;
	}
	
	public String getUrlParameter()
	{ 
		return urlParameter;
	}
	
}
