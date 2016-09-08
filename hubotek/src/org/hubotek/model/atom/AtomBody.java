package org.hubotek.model.atom;

public class AtomBody {

	private String version = "1.0";
	private String title; 
	private String link; 
	private String description;
	private String language; 
	private String updated;
	
	public AtomBody(){}
	
	
	public AtomBody(String version, String title, String link, String description, String language, String updated) {
		super();
		this.version = version;
		this.title = title;
		this.link = link;
		this.description = description;
		this.language = language;
		this.updated = updated;
	}

	public String getVersion() {
		return version;
	}
	
	
	public void setVersion(String version) {
		this.version = version;
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
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public String getUpdated() {
		return updated;
	}
	
	public void setUpdated(String updated) {
		this.updated = updated;
	} 
	
}
