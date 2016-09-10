package org.hubotek.tests.parser;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hubotek.google.news.feed.FeedParser;
import org.hubotek.tests.TestException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class GoogleAtomParser {

	DocumentBuilderFactory documentBuilderFactory;
	
	@Autowired
	private FeedParser feedParser;
	
	@Before
	public void AtomParser()
	{
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
	}
	
	@Test
	public void testAtomParser()
	{ 
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			
			FileInputStream fis = new FileInputStream(new File("C:\\cygwin64\\home\\user\\hubotek\\hubotek\\war\\google_news_feed_sample.xml"));
			Document atomDocument = feedParser.parseFeed(new InputSource(fis));
//			TODO: remove the parser from the request accessor.
			
			
		} catch (Exception e) {
			throw new TestException(e);
		}
		
	}
	
}
