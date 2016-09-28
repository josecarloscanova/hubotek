package org.hubotek.service.database;

import org.hubotek.model.project.api.ApiKey;
import org.hubotek.model.project.api.ApiKeyEnum;
import org.hubotek.model.project.api.GoogleApiKey;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyDAO extends BaseDAO<Long,ApiKey>{
	
	public ApiKey findById(Long id)
	{ 
		return findById(ApiKey.class, id);
	}
	
	public ApiKey findApiKeyByNameType(String name)
	{ 
		return entityManager.createQuery("Select a from ApiKey" , ApiKey.class).getResultList().stream().findFirst().orElse(new ApiKey());
	}
	
	public GoogleApiKey findApiKeyByNameType(String name , ApiKeyEnum keyType)
	{ 
		return entityManager.createQuery("Select a from ApiKey" , GoogleApiKey.class).getResultList().stream().findFirst().orElse(new GoogleApiKey());
	}
	
}
