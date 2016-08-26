package org.hubotek.google.news.feed;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hubotek.HubotekException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class FeedParser {

	DocumentBuilderFactory documentBuilderFactory;
	DocumentBuilder documentBuilder; 
	
	public FeedParser(){
		prepare();
	}

	private void prepare() {
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new HubotekException(e);
		}
	}
	
	
	public Document parseRssFeed (InputSource inputSource)
	{
		try {
			return documentBuilder.parse(inputSource);
		} catch (SAXException | IOException e) {
			throw new HubotekException(e);
		}
	}
}
