package org.hubotek.model.atom;

import org.w3c.dom.Document;

/**
 * 
 * Construct the object that represent a RSS Feed from an Atom Source.
 * 
 * @author user
 *
 */
public class AtomDocumentBuilder {

	private AtomDocument atomDocument; 

	public AtomDocumentBuilder(){ 
		prepare();
	}

	public void prepare()
	{ 
		atomDocument = new AtomDocument();
	}

	public AtomDocumentBuilder withDocument (Document document){ 
		if (document !=null)
		{ 
			withBody(document);
			withItems(document);
		}
		return this;
	}
	
	
	private void withItems(Document document) {
	}

	private void withBody(Document document) {
	}

	public AtomDocument build()
	{ 
		return atomDocument;
	}

}
