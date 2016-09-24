package org.hubotek.service.database;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hubotek.service.DAO;
import org.nanotek.Base;

public class BaseDAO <T extends Base<?>> implements DAO<T>{

	@PersistenceContext 
	private EntityManager entityManager;
	
	
	
}
