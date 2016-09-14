package org.hubotek;

import javax.cache.CacheFactory;

import org.hubotek.google.cache.CacheFactorySupplier;
import org.hubotek.google.news.GoogleNewsFeed;
import org.hubotek.google.news.feed.FeedParser;
import org.hubotek.services.HttpRequestAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
    CacheFactory createCacheFactory(){ 
    	return new CacheFactorySupplier().get();
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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/googleNews").allowedOrigins("*");
            }
        };
    }
}