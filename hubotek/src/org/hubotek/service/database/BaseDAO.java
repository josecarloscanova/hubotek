package org.hubotek.service.database;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hubotek.service.DAO;
import org.nanotek.Base;


public class BaseDAO <K extends Serializable , T extends Base<K>> implements DAO<T>{

	@PersistenceContext 
	protected EntityManager entityManager;
	
	public T findById(Class<T> clazz , K id )
	{ 
		return entityManager.find(clazz, id);
	}
	
	
}
