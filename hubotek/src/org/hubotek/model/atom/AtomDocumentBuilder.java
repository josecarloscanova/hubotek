package org.hubotek.model.atom;

import org.hubotek.Builder;
import org.hubotek.google.xpath.DOMElementExtratorUtil;
import org.hubotek.google.xpath.XPathFactorySupplier;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * 
 * Construct the object that represent a RSS Feed from an Atom Source.
 * 
 * @author user
 *
 */
public class AtomDocumentBuilder extends DOMElementExtratorUtil<AtomDocumentElementsEnum> implements Builder<AtomDocument>{

	private AtomDocument atomDocument; 

	final String nameExpression = "/feed/author/name";
	final String emailExpression = "/feed/author/email";

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
			withAuthor(document);
			withItems(document);
		}
		return this;
	}
	
	
	private void withAuthor(Document document) {
		Node nameNode = getNodeWithXPath(nameExpression, document);
		String authorName = nameNode.getTextContent();
		Node emailNode = getNodeWithXPath(emailExpression, document);
		String authorEmail = emailNode.getTextContent();
	}

	private void withItems(Document document) {
	}

	public AtomDocument build()
	{ 
		return atomDocument;
	}
	
	private void withBody(Document document) 
	{ 
		String id  = getFromDocument(document , AtomDocumentElementsEnum.ID);
		String title = getFromDocument(document , AtomDocumentElementsEnum.TITLE);
		String language = getFromDocument(document, AtomDocumentElementsEnum.LANGUAGE);
		String link = getFromDocument(document , AtomDocumentElementsEnum.LINK);
		String copyRight = getFromDocument(document, AtomDocumentElementsEnum.RIGHTS);
		String version = getFromDocument(document , AtomDocumentElementsEnum.VERSION);
		String updated = getFromDocument(document , AtomDocumentElementsEnum.UPDATED);
		String description = getFromDocument(document , AtomDocumentElementsEnum.DESCRIPTION);

		AtomBody atomBody = new AtomBody(id , version, title, link, description, language, updated);
		
		atomDocument.setBody(atomBody);
	}

}
