package org.hubotek.model.rss;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hubotek.Builder;
import org.hubotek.HubotekException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * Construct the object that represent a RSS Feed from Google News.
 * 
 * @author user
 *
 */
public class RssDocumentBuilder implements Builder<RssDocument>{

	private RssDocument rssNewsDocument; 

	public RssDocumentBuilder(){
		prepare();
	}

	public void prepare()
	{ 
		rssNewsDocument = new RssDocument();
	}
	
	
	public RssDocumentBuilder withDocument (Document rssDocument)
	{ 
		//TODO: remove this later.
		if (rssDocument !=null){ 
			withBody(rssDocument);
			withImage(rssDocument);
			withItems(rssDocument);
		}
		return this;
	}

	public RssDocument build()
	{ 
		return rssNewsDocument;
	}

	private RssDocumentBuilder withItems(Document rssDocument) {
		try{ 
				List<RssItem> feedItems = new ArrayList<RssItem>(); 
				String itemParentExpression = "/rss/channel/item";
				XPath xPath =  XPathFactory.newInstance().newXPath();
				NodeList itemNodes = getNodeListWithXPath(itemParentExpression , rssDocument);
				if (itemNodes!=null)
					for (int i = 0 ; i < itemNodes.getLength();i++)
					{ 
						int nodeposition = i+1;
						StringBuilder itemChildBaseExpression = new StringBuilder().append(itemParentExpression).append("[").append(nodeposition).append("]");
						
						StringBuilder itemTitleExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.TITLE.valueOf());
						Node titleNode = (Node)xPath.compile(itemTitleExpression.toString()).evaluate(rssDocument, XPathConstants.NODE);
						String title = getTextContent(titleNode);
						
						StringBuilder categoryExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.CATEGORY.valueOf());
						Node categoryNode = (Node)xPath.compile(categoryExpression.toString()).evaluate(rssDocument, XPathConstants.NODE);
						String category = getTextContent(categoryNode);
						 
						 
						StringBuilder linkExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.LINK.valueOf());
	//					Node linkNode = (Node)xPath.compile(linkExpression.toString()).evaluate(rssDocument, XPathConstants.NODE);
						NodeList linkNodeList = getNodeListWithXPath(linkExpression.toString(),  rssDocument);
						String link = "";
						if (linkNodeList.getLength() >0){
							link = getTextContent(linkNodeList.item(0));
						}
						
						StringBuilder guidExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.GUID.valueOf());
						Node guidNode = (Node)xPath.compile(guidExpression.toString()).evaluate(rssDocument, XPathConstants.NODE);
						String guid = getTextContent(guidNode);
	
						StringBuilder pubDateExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.PUBDATE.valueOf());
						Node pubDateNode = (Node)xPath.compile(pubDateExpression.toString()).evaluate(rssDocument, XPathConstants.NODE);
						String pubDate = getTextContent(pubDateNode);
	
						StringBuilder descriptionExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.DESCRIPTION.valueOf());
						Node descriptionNode = (Node)xPath.compile(descriptionExpression.toString()).evaluate(rssDocument, XPathConstants.NODE);
						String description = getTextContent(descriptionNode);
						
						RssItem rssItem = new RssItem (title , link , guid,category, pubDate , description);
						feedItems.add(rssItem);					
					}
				rssNewsDocument.setRssItems(feedItems);
		}catch (Exception e){ 
			throw new HubotekException(e);
		}
		return this;
	}

	private String getTextContent(Node titleNode) {
		return (titleNode!=null && titleNode.hasChildNodes()) ? titleNode.getTextContent() : "";
	}

	private RssDocumentBuilder withImage(Document rssDocument) {
		
		String imageParentExpression = "/rss/channel/image";
		NodeList imageNodes = getNodeListWithXPath(imageParentExpression , rssDocument);
		
		if (imageNodes.getLength() > 0){
			
				int nodeposition = 1;
				StringBuilder itemChildBaseExpression = new StringBuilder().append(imageParentExpression).append("[").append(nodeposition).append("]");
				
				StringBuilder imageTitleExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.TITLE.valueOf());
				Node titleNode = getNodeWithXPath(imageTitleExpression.toString() , rssDocument);
				String imageTitle = titleNode.getTextContent();
				
				StringBuilder imageUrlExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.URL.valueOf());
				Node imageUrlNode = getNodeWithXPath(imageUrlExpression.toString() , rssDocument); 
				String imageUrl = imageUrlNode.getTextContent();
				
				StringBuilder imageLinkExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.LINK.valueOf());
				Node imageLinkNode = getNodeWithXPath(imageLinkExpression.toString() , rssDocument); 
				String imageLink = imageLinkNode.getTextContent();
			
				RssImage rssImage  = new RssImage(imageTitle , imageUrl , imageLink);
				rssNewsDocument.setRssImage(rssImage);
			}
		return this;
	}

	private RssDocumentBuilder withBody(Document rssDocument)
	{ 
		String generator = getFromDocument(rssDocument , RssDocumentElementsEnum.GENERATOR);
		String title = getFromDocument(rssDocument , RssDocumentElementsEnum.TITLE);
		String link = getFromDocument(rssDocument , RssDocumentElementsEnum.LINK);
		String language = getFromDocument(rssDocument , RssDocumentElementsEnum.LANGUAGE);
		String webMaster = getFromDocument(rssDocument, RssDocumentElementsEnum.WEBMASTER);
		String copyRight = getFromDocument(rssDocument, RssDocumentElementsEnum.COPYRIGHT);
		String pubDate = getFromDocument(rssDocument , RssDocumentElementsEnum.PUBDATE);
		String lastBuildDate = getFromDocument(rssDocument , RssDocumentElementsEnum.LASTBUILDDATE);

		RssBody rssBody = new RssBody(generator,  title,  link,  language,  webMaster,  copyRight,
				pubDate,  lastBuildDate);
		rssNewsDocument.setRssBody(rssBody);
		return this;
	}

	private String getFromDocument(Document rssDocument , RssDocumentElementsEnum rssDocumentElementEnum) {
		String value = "";
		NodeList nodeList = rssDocument.getElementsByTagName(rssDocumentElementEnum.valueOf());
		Node node = nodeList.item(0);
		if (node !=null)
			value = node.getTextContent();
		return value;
	}

	
	private NodeList getNodeListWithXPath(String nodeExpression , Document rssDocument)
	{ 
		NodeList nodeList = null;
		try {
		XPath xPath =  XPathFactory.newInstance().newXPath();
		nodeList  = (NodeList) xPath.compile(nodeExpression).evaluate(rssDocument, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return nodeList;
	}
	
	private Node getNodeWithXPath(String nodeExpression , Document rssDocument)
	{ 
		Node node = null;
		try {
		XPath xPath =  XPathFactory.newInstance().newXPath();
		node = (Node) xPath.compile(nodeExpression).evaluate(rssDocument, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return node;
	}
}
