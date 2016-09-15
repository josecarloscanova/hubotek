package org.hubotek.model.atom;

import java.util.List;

import org.hubotek.model.HubDocument;

public class AtomDocument implements HubDocument{

	private AtomBody body;
	
	private List<AtomItem> items;
	
	public AtomDocument(){}
	
	public AtomBody getBody() {
		return body;
	}

	public void setBody(AtomBody body) {
		this.body = body;
	}

	public List<AtomItem> getItems() {
		return items;
	}

	public void setItems(List<AtomItem> items) {
		this.items = items;
	}

}
