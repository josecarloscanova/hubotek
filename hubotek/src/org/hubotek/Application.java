package org.hubotek;

import org.hubotek.google.news.GoogleNewsFeed;
import org.hubotek.google.news.feed.FeedParser;
import org.hubotek.services.HttpRequestAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc
public class Application {

    @Bean
    GoogleNewsFeed createGoogleNewsFeedParser()
    { 
    	return new GoogleNewsFeed();
    }
    
    @Bean
    HttpRequestAccessor createHttpRequestAccessor()
    { 
    	return new HttpRequestAccessor();
    }
    
    @Bean
    FeedParser createFeedParser()
    { 
    	return new FeedParser();
    }

}