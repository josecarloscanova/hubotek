package org.hubotek.services;

import java.net.URI;

import org.hubotek.HubotekException;
import org.hubotek.http.ResponseCallback;
import org.hubotek.model.atom.AtomDocument;
import org.hubotek.model.atom.AtomDocumentBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class HttpAtomRequestAccessor extends HttpRequestAccessor<AtomDocument>{

	@Override
	public AtomDocument doRequest(String location, ResponseCallback callback)
		{ 
			Document rssDocument = null;
			AtomDocument hubDocument = null;

			try { 
				ClientHttpRequest request = this.createRequest(new URI(location), HttpMethod.GET);
				ClientHttpResponse response = request.execute();
				if (response.getStatusCode() == HttpStatus.OK)
				{ 
					rssDocument = parser.parseInput(new InputSource(response.getBody()));
					hubDocument = new AtomDocumentBuilder().withDocument(rssDocument).build();
				}
			}catch (Exception ex)
			{ 
				throw new HubotekException(ex);
			}
			return hubDocument;
		}
}