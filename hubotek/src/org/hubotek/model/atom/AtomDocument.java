package org.hubotek.model.atom;

import java.util.List;

import org.hubotek.model.HubDocument;

public class AtomDocument implements HubDocument{

	public String version = "1.0";
	public String title; 
	public String link; 
	public String description;
	public String language; 
	public String updated; 
	
	public List<AtomItem> items;
	
	public AtomDocument(){}

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

	public List<AtomItem> getItems() {
		return items;
	}

	public void setItems(List<AtomItem> items) {
		this.items = items;
	}
	
}
