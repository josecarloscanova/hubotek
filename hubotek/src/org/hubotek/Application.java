package org.hubotek;

import org.hubotek.google.news.feed.FeedParser;
import org.hubotek.services.HttpRequestAccessor;
import org.hubotek.services.google.GoogleNewsFeed;
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

//    <bean class="org.springframework.format.support.FormattingConversionServiceFactoryBean" id="applicationConversionService">
//    <property name="converters">
//      <set>
//        <bean class="com.somecompany.dont.run.with.scissors.converters.StringToEntityConverterFactory"/>
//      </set>
//    </property>
//  </bean>
}