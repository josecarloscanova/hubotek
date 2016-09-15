package org.hubotek.google.xpath;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hubotek.ElementEnum;
import org.hubotek.HubotekException;
import org.hubotek.model.rss.RssDocumentElementsEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMElementExtratorUtil {

	private XPathFactory xpathFactory;
	
	
	public DOMElementExtratorUtil(){
		prepare();
	}
	
	private void prepare() {
		xpathFactory = XPathFactory.newInstance();
	}

	protected <T extends ElementEnum<String>> String getFromDocument(Document rssDocument , T elementEnum) {
		String value = "";
		NodeList nodeList = rssDocument.getElementsByTagName(elementEnum.valueOf());
		Node node = nodeList.item(0);
		if (node !=null)
			value = node.getTextContent();
		return value;
	}
	
	protected NodeList getNodeListWithXPath(String nodeExpression , Document rssDocument)
	{ 
		NodeList nodeList = null;
		try {
		XPath xPath = createXPathFromFactory();
		nodeList  = (NodeList) xPath.compile(nodeExpression).evaluate(rssDocument, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return nodeList;
	}
	
	protected Node getNodeWithXPath(String nodeExpression , Document rssDocument)
	{ 
		Node node = null;
		try {
				XPath xPath = createXPathFromFactory();
				node = (Node) xPath.compile(nodeExpression).evaluate(rssDocument, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			throw new HubotekException(e);
		}
		return node;
	}
	
	private XPath createXPathFromFactory() {
		return  xpathFactory.newXPath();
	}
}
