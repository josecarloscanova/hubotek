package org.hubotek.model.atom;

/**
 * 
 * Construct the object that represent a RSS Feed from an Atom Source.
 * 
 * @author user
 *
 */
public class AtomDocumentBuilder {

	private AtomDocument atomDocument; 

	public AtomDocumentBuilder(){ 
		prepare();
	}

	public void prepare()
	{ 
		atomDocument = new AtomDocument();
	}


}
