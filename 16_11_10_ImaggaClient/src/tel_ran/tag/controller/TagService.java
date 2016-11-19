package tel_ran.tag.controller;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tel_ran.tag.entities.Settings;
import tel_ran.tag.entities.TagImage;
import tel_ran.tag.model.dao.TagsMongoDB;
import tel_ran.tag.repo.TagRepository;

@RestController
@SpringBootApplication
@ImportResource({ "classpath:beans.xml", "classpath:mbeansNoReg.xml" })
public class TagService {
	@Autowired
	TagRepository tagsRepository;

	@Autowired
	TagsMongoDB tagsMongo;

	@Autowired
	Settings settings;

	static RestTemplate restTemplate = new RestTemplate();
	static final String AUTH_TOKEN = "Basic YWNjXzg3YWVhMjA4Njc1MTA4ZjpjZDIwZmMyYjgyMmRkOGJjZTc3ZmY2Y2EzZDhmOGQwZQ==";
	static final String URL_SERVICE = "https://api.imagga.com/v1/tagging?url=";

	@RequestMapping(value = "getTag") // Targil 1
	public Map<String, Double> GetTag(String url, @RequestParam(defaultValue = "0") int k) {
		Map<String, Double> res = tagsMongo.getTag(url).getTagParsed();
		Set<String> keySet = res.keySet();
		int k1 = settings.getK();
		if (k != 0)
			k1 = k;
		for (Iterator iterator = res.keySet().iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (res.get(string) < k1)
				iterator.remove();
		}
		return res;
	}

	@RequestMapping(value = "getSimilars") // Targil 2
	public Iterable<String> GetSimilar(String url) {
		int m = settings.getM();
		System.out.println("M=" + m);
		Map<String, Double> tags = tagsMongo.getTag(url).getTagParsed();
		int numTags = tags.keySet().size();
		int numTagsMin = numTags * m / 100;
		Set<String> setPicture = tags.keySet();
		Iterable<TagImage> allImages = tagsMongo.getAllTags();
		Set<String> similars = new HashSet<String>();
		for (TagImage tagImage : allImages) {
			int numTagsSim = 0;
			Set<String> set = tagImage.getTagParsed().keySet();
			for (String str : set) {
				if (setPicture.contains(str))
					numTagsSim++;
			}
			if (numTagsSim >= numTagsMin)
				similars.add(tagImage.getImage());
		}

		return similars;
	}

	@RequestMapping(value = "getPictFromTags") // Targil 2
	public Iterable<String> GetPictFromTags(String[] tags) {
		int l = settings.getL();
		System.out.println("L=" + l);
		int numTags = tags.length;
		int numTagsMin = numTags * l / 100;
		System.out.println("numTagsMin=" + numTagsMin);
		Set<String> setPicture = new HashSet<>();
		for (int i = 0; i < tags.length; i++) {
			setPicture.add(tags[i]);
		}
		Iterable<TagImage> allImages = tagsMongo.getAllTags();
		Set<String> similars = new HashSet<String>();
		for (TagImage tagImage : allImages) {
			int numTagsSim = 0;
			Set<String> set = tagImage.getTagParsed().keySet();
			for (String str : set) {
				if (setPicture.contains(str))
					numTagsSim++;
			}
			if (numTagsSim >= numTagsMin)
				similars.add(tagImage.getImage());
		}
		return similars;
	}

	@RequestMapping(value = "addPicture") // Targil 1
	public boolean addPicture(String url) {
		TagImage tg = tagsMongo.getTag(url);
		if (tg == null) {
			List<TagImage> ListTag = new LinkedList<>();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", AUTH_TOKEN);
			HttpEntity<String> request = new HttpEntity<>(headers);
			ResponseEntity<Map> resp = restTemplate.exchange(URL_SERVICE + url, HttpMethod.GET, request, Map.class);
			Map<String, List<Map<String, Object>>> map = resp.getBody();
			List<Map<String, Object>> results = map.get("results");
			for (Map<String, Object> map2 : results) {
				TagImage tag = new TagImage(map2.get("tagging_id"), (String) map2.get("image"),
						(List<Map<String, Object>>) map2.get("tags"));
				ListTag.add(tag);
			}
			tagsMongo.addTags(ListTag);
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		SpringApplication.run(TagService.class, args);
	}
}
