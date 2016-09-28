package org.hubotek.services;

import org.hubotek.http.ResponseCallback;
import org.hubotek.model.atom.AtomDocument;

public class HttpAtomRequestAccessor extends HttpRequestAccessor<AtomDocument>{

	@Override
	public AtomDocument doRequest(String location, ResponseCallback callback) {
		return null;
	}

}
