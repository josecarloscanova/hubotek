package org.hubotek.google.news;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

//TODO: create a validation filter for url parameters.
public class GoogleNewsUrlBuilder {

	String baseUrl = "https://news.google.com/news";; 
	private EnumMap<GoogleNewsUrlParametersEnum,String> urlParameterMap = new EnumMap<GoogleNewsUrlParametersEnum,String>(GoogleNewsUrlParametersEnum.class);
	
	public GoogleNewsUrlBuilder(){}
	
	public GoogleNewsUrlBuilder withLang(String lang){ 
		put(GoogleNewsUrlParametersEnum.HL, lang);
		return this;
	}
	
	public GoogleNewsUrlBuilder withTopic(String topic)
	{ 
		put(GoogleNewsUrlParametersEnum.CF, topic);
		return this;
	}
	
	public GoogleNewsUrlBuilder withEdition(String edition)
	{ 
		put(GoogleNewsUrlParametersEnum.NED, edition);
		return this;
	}
	
	public GoogleNewsUrlBuilder withQuery(String query)
	{ 
		put(GoogleNewsUrlParametersEnum.QUERY, query);
		return this;
	}
	
	//TODO: Check if resultCount format is a "numeric integer value"
	public GoogleNewsUrlBuilder withResultCount(String resultCount)
	{ 
		put(GoogleNewsUrlParametersEnum.NUM, resultCount);
		return this;
	}
	
	private void put(GoogleNewsUrlParametersEnum parameter , String value)
	{ 
		urlParameterMap.put(parameter, value);
	}
	
	public List<String> prepareParameterList()
	{
		List<String> paramList = new ArrayList<String>();
		for (GoogleNewsUrlParametersEnum parameterKey : urlParameterMap.keySet())
		{
			StringBuilder param = new StringBuilder();
			param.append(parameterKey.getUrlParameter()).append("=").append(urlParameterMap.get(parameterKey));
			paramList.add(param.toString());
		}
		return paramList;
	}
	
	
	public String build()
	{ 
		StringBuilder sb = new StringBuilder("https://news.google.com/news");
		return sb.toString();
	}
}
