package hello;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "blog_data")
@JsonPropertyOrder({ "id" })
public class BlogData {

	@JsonProperty("id")
	private Integer id = 1000;
	
	public BlogData ()
	{ 
	}

	public BlogData (Integer id)
	{ 
		this.id =id;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
