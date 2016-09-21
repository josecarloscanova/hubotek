package org.hubotek.model.atom;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hubotek.Builder;
import org.hubotek.HubotekException;
import org.hubotek.google.xpath.DOMElementExtratorUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * Construct the object that represent a Feed from an Atom Source.
 * 
 * @author user
 *
 */
public class AtomDocumentBuilder extends DOMElementExtratorUtil<AtomDocumentElementsEnum> implements Builder<AtomDocument>{

	private AtomDocument atomDocument; 

	final String nameExpression = "/feed/author/name";
	final String emailExpression = "/feed/author/email";
	final String entryParentExpression = "/feed/entry";
	
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
			withEntries(document);
		}
		return this;
	}
	
	public AtomDocument build()
	{ 
		return atomDocument;
	}
	
	
	private void withAuthor(Document document , AtomBody atomBody) {
		Node nameNode = getNodeWithXPath(nameExpression, document);
		String authorName = nameNode.getTextContent();
		Node emailNode = getNodeWithXPath(emailExpression, document);
		String authorEmail = emailNode.getTextContent();
		Author author = new Author(authorName , authorEmail);
		atomBody.setAuthor(author);
	}

	private void withEntries(Document document) {

			try{ 
				List<AtomEntry> feedEntries = new ArrayList<AtomEntry>(); 
				NodeList entryNodes = getNodeListWithXPath(entryParentExpression , document);
				if (entryNodes!=null)
					for (int i = 0 ; i < entryNodes.getLength();i++)
					{ 
						int nodeposition = i+1;
						String entryChildBaseExpression = new StringBuilder().append(entryParentExpression).append("[").append(nodeposition).append("]").toString();
						
						String id = getChildValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.ID);
						String title = getChildValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.TITLE);
						String category = getChildValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.CATEGORY);
						String content = getChildValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.CONTENT);
						String updated = getChildValueWithXPath(document , entryChildBaseExpression , AtomDocumentElementsEnum.UPDATED);
						
						
						StringBuilder linkExpression = new StringBuilder(entryChildBaseExpression).append("/").append(AtomDocumentElementsEnum.LINK.valueOf());
	//					Node linkNode = (Node)xPath.compile(linkExpression.toString()).evaluate(atomDocument, XPathConstants.NODE);
						NodeList linkNodeList = getNodeListWithXPath(linkExpression.toString(),  document);
						String link = "";
						if (linkNodeList.getLength() >0){
							link = getTextAttribute(linkNodeList.item(0) , "href");
						}
						AtomEntry feedEntry = new  AtomEntry(id, title, link, content, updated, category);
						feedEntries.add(feedEntry);					
					}
				atomDocument.setEntries(feedEntries);
			}catch (Exception e){ 
				throw new HubotekException(e);
			}
	}

	private String getChildValueWithXPath(Document  document , String parentExpression , AtomDocumentElementsEnum elementEnum) throws XPathExpressionException{
		XPath xPath =  XPathFactory.newInstance().newXPath();
		StringBuilder subExpression = new StringBuilder(parentExpression).append("/").append(elementEnum.valueOf());
		Node idNode = (Node)xPath.compile(subExpression.toString()).evaluate(document, XPathConstants.NODE);
		return getTextContent(idNode);
	}
	
	
	private void withBody(Document document) 
	{ 
		String idpath = "/feed/id"; 
		String titleXPath = "/feed/title";
		
		String id  = getFromDocument(document , AtomDocumentElementsEnum.ID);
		String title = getFromDocument(document , AtomDocumentElementsEnum.TITLE);
		String language = getFromDocument(document, AtomDocumentElementsEnum.LANGUAGE);
		String link = getFromDocument(document , AtomDocumentElementsEnum.LINK);
		String copyRight = getFromDocument(document, AtomDocumentElementsEnum.RIGHTS);
		String version = getFromDocument(document , AtomDocumentElementsEnum.VERSION);
		String updated = getFromDocument(document , AtomDocumentElementsEnum.UPDATED);
		String description = getFromDocument(document , AtomDocumentElementsEnum.DESCRIPTION);

		AtomBody atomBody = new AtomBody(id , version, title, link, description, language, updated);
		withAuthor(document , atomBody);		
		atomDocument.setBody(atomBody);
	}

}
