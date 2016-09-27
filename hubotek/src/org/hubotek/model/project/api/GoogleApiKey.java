package org.hubotek.model.project.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nanotek.Base;

@SuppressWarnings("serial")
@Entity
@Table(name="google_api_key")
public class GoogleApiKey implements Base<Long>{

	@Id
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="api_key_type")
	private ApiKeyEnum apiKeyType;
	
	@Column(name="key" , length=255 , insertable=true , updatable=true , nullable=false)
	private String key;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
}
