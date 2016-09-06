package org.hubotek.model.inet;

import java.util.List;

public class WebAddress {

	private Long id; 
	
	private String baseUrl;
	
	private Boolean hasHttp; 
	
	private List<WebAddress> feedAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public Boolean getHasHttp() {
		return hasHttp;
	}

	public void setHasHttp(Boolean hasHttp) {
		this.hasHttp = hasHttp;
	}

	public List<WebAddress> getFeedAddress() {
		return feedAddress;
	}

	public void setFeedAddress(List<WebAddress> feedAddress) {
		this.feedAddress = feedAddress;
	}
	
}
