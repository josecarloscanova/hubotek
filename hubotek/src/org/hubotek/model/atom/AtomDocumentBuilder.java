package org.hubotek.model.atom;

import org.hubotek.Builder;
import org.hubotek.google.xpath.XPathFactorySupplier;
import org.w3c.dom.Document;

/**
 * 
 * Construct the object that represent a RSS Feed from an Atom Source.
 * 
 * @author user
 *
 */
public class AtomDocumentBuilder implements Builder<AtomDocument>{

	private AtomDocument atomDocument; 
	
	private XPathFactorySupplier xpathFactorySupplier;

	public AtomDocumentBuilder(){ 
		prepare();
	}

	public void prepare()
	{ 
		atomDocument = new AtomDocument();
		xpathFactorySupplier = new XPathFactorySupplier();
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
