import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import tel_ran.tag.entities.TagImage;
import tel_ran.tag.model.dao.TagsMongoDB;

public class ImagaClientTestAppl {
	static LinkedList<String> URLs = new LinkedList<>();
	static RestTemplate restTemplate = new RestTemplate();
	static TagsMongoDB tagsMongo; 
	static String urlPicture = "http://cbsnews2.cbsistatic.com/hub/i/r/2015/05/31/7cecb2a0-6bb0-4f9d-bd8d-559c706906a0/thumbnail/620x350/52baa5b68d0bcb54a6127be0842ccd16/putin474954598.jpg";
	static final String AUTH_TOKEN = "Basic YWNjXzg3YWVhMjA4Njc1MTA4ZjpjZDIwZmMyYjgyMmRkOGJjZTc3ZmY2Y2EzZDhmOGQwZQ==";
	static final String URL_SERVICE = "https://api.imagga.com/v1/tagging?url=";

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		tagsMongo = ctx.getBean(TagsMongoDB.class);
		readFile();
		parseFile();

	}

	public static void readFile() {
		String line;
		String fileName = "images.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while ((line = reader.readLine()) != null) {
				URLs.add(line);
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void parseFile() {
		List<TagImage> ListTag = new LinkedList<>();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", AUTH_TOKEN);
		HttpEntity<String> request = new HttpEntity<>(headers);
		for (String string : URLs) {
			ResponseEntity<Map> resp = restTemplate.exchange(URL_SERVICE + string, HttpMethod.GET, request, Map.class);
			Map<String, List<Map<String, Object>>> map = resp.getBody();
			List<Map<String, Object>> results = map.get("results");
			for (Map<String, Object> map2 : results) {
				TagImage tag = new TagImage(map2.get("tagging_id"), (String) map2.get("image"),
						(List<Map<String, Object>>) map2.get("tags"));
				ListTag.add(tag);
			}
			
		}
		tagsMongo.addTags(ListTag);
		
	}
}