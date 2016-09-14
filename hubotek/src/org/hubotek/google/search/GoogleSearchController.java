package org.hubotek.google.search;

import org.hubotek.Result;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoogleSearchController implements Searcher{

	@Override
	@RequestMapping(name="/search",method=RequestMethod.GET)
	public <String> Result<?> search(@RequestAttribute (name="query" , required=true , value="technology") String query) {
		return null;
	}

}
