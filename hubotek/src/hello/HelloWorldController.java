package hello;

import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorldController {

	@RequestMapping("/hubotek")
	public String helloWorld(Model model) {
		getBlogData(model);
		return "home";
	}
 
//	@GetMapping(path = "/hubotek1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping("/hubotek1")
//	@JsonView(BlogData.class)
	@ResponseBody
	public BlogData getBlogDataById(Model model)
	{
		return new BlogData(1000);
	}
	
	public void getBlogData(Model model){ 
		URL url;
		try {
			url = new URL("https://www.googleapis.com/blogger/v3/blogs/2045640289942179582/posts/995164709712956077?key=AIzaSyDh0Bmqa-9RQIpASA1tNATVsD_PZF3CJRQ");
			InputStream is = url.openStream();
			JsonReader rdr = Json.createReader(is);
			JsonObject result = rdr.readObject();
			StringBuffer msgBuffer = new StringBuffer();
			//			JsonArray results = obj.getJsonArray("data");
			//			for (JsonObject result : results.getValuesAs(JsonObject.class)) {
			msgBuffer.append(result.getJsonObject("author").getString("displayName"));
			msgBuffer.append(": ");
			msgBuffer.append(result.getString("message", ""));
			msgBuffer.append("-----------");
			model.addAttribute("message", msgBuffer.toString());
			//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}