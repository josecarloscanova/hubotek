package org.hubotek.google.search;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hubotek.model.rss.RssDocument;

public class CustomSearchAdapter {

	private static final Logger logger = Logger.getLogger(CustomSearchAdapter.class);

	public RssDocument searchGoogle(@NotNull Map<SearchParameterEnum,String> parameters)
	{ 
		String queryString = parameters.keySet().stream().flatMap(t->prepareParameter(t,parameters)).reduce(new BinaryOperator<String>(){
			@Override
			public String apply(String t, String u) {
				return t + "&" + u;
			}}).orElse("");
		logger.debug("The Query String : " + queryString);
		return null;
	}

	private Stream<String> prepareParameter(SearchParameterEnum sp, Map<SearchParameterEnum, String> parameters) {
		return Arrays.asList(getQueryStringParameter(sp,parameters)).stream();
	}

	private String getQueryStringParameter(SearchParameterEnum sp,
			Map<SearchParameterEnum, String> parameters) {
		return sp.valueOf()+"="+parameters.get(sp);
	}


}
