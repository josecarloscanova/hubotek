package org.hubotek.google.search;

import org.hubotek.Result;

public interface Searcher {

	<T> Result<?> search(T params);
	
}
