package org.hubotek.model.rss;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.xml.xpath.XPathExpressionException;

import org.hubotek.Builder;
import org.hubotek.TranformationException;
import org.hubotek.google.xpath.DOMElementExtratorUtil;
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
public class RssDocumentBuilder extends DOMElementExtratorUtil<RssDocumentElementsEnum> implements Builder<RssDocument>{

	private RssDocument rssNewsDocument; 

	public RssDocumentBuilder(){
		prepare();
	}

	public void prepare()
	{ 
		rssNewsDocument = new RssDocument();
	}


	//TODO: Change the exception for another checked exception 
	public RssDocumentBuilder withDocument (@NotNull Document rssDocument) throws TranformationException
	{ 
		withBody(rssDocument);
		withImage(rssDocument);
		withItems(rssDocument);
		return this;
	}

	public RssDocument build()
	{ 
		return rssNewsDocument;
	}

	private RssDocumentBuilder withItems(Document rssDocument) throws TranformationException {
		List<RssItem> feedItems = new ArrayList<RssItem>(); 
		String itemParentExpression = "/rss/channel/item";
		NodeList itemNodes = getNodeListWithXPath(itemParentExpression , rssDocument);
		try{ 		
			if (itemNodes!=null)
				for (int i = 0 ; i < itemNodes.getLength();i++)
				{ 
					int nodeposition = i+1;
					StringBuilder itemChildBaseExpression = new StringBuilder().append(itemParentExpression).append("[").append(nodeposition).append("]");
					String title = getChildNodeTextValueWithXPath(rssDocument , itemChildBaseExpression.toString() , RssDocumentElementsEnum.TITLE);
					String category =  getChildNodeTextValueWithXPath(rssDocument , itemChildBaseExpression.toString() , RssDocumentElementsEnum.CATEGORY);
					StringBuilder linkExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.LINK.valueOf());
					NodeList linkNodeList = getNodeListWithXPath(linkExpression.toString(),  rssDocument);
					String link = "";
					if (linkNodeList.getLength() >0){
						link = getTextContent(linkNodeList.item(0));
					}

					String guid = getChildNodeTextValueWithXPath(rssDocument , itemChildBaseExpression.toString() , RssDocumentElementsEnum.GUID);
					String pubDate = getChildNodeTextValueWithXPath(rssDocument , itemChildBaseExpression.toString() , RssDocumentElementsEnum.PUBDATE);
					String description = getChildNodeTextValueWithXPath(rssDocument , itemChildBaseExpression.toString() , RssDocumentElementsEnum.DESCRIPTION);
					RssItem rssItem = new RssItem (title , link , guid,category, pubDate , description);
					feedItems.add(rssItem);					
				}
			rssNewsDocument.setRssItems(feedItems);
		}catch (XPathExpressionException e){ 
			throw  new TranformationException(e);
		}
		return this;
	}

	private void withImage(Document rssDocument) throws TranformationException {

		try { 

			String imageParentExpression = "/rss/channel/image";
			NodeList imageNodes = getNodeListWithXPath(imageParentExpression , rssDocument);

			if (imageNodes.getLength() > 0){

				int nodeposition = 1;
				StringBuilder itemChildBaseExpression = new StringBuilder().append(imageParentExpression).append("[").append(nodeposition).append("]");

				String imageTitle = getChildNodeTextValueWithXPath(rssDocument , itemChildBaseExpression.toString() , RssDocumentElementsEnum.TITLE);


				StringBuilder imageUrlExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.URL.valueOf());
				Node imageUrlNode = getNodeWithXPath(imageUrlExpression.toString() , rssDocument); 
				String imageUrl = imageUrlNode.getTextContent();

				StringBuilder imageLinkExpression = new StringBuilder(itemChildBaseExpression).append("/").append(RssDocumentElementsEnum.LINK.valueOf());
				Node imageLinkNode = getNodeWithXPath(imageLinkExpression.toString() , rssDocument); 
				String imageLink = imageLinkNode.getTextContent();

				RssImage rssImage  = new RssImage(imageTitle , imageUrl , imageLink);
				rssNewsDocument.setRssImage(rssImage);
			}
		}catch (XPathExpressionException e){ 
			throw  new TranformationException(e);
		}
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

}
