package tel_ran.tag.entities;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tags")
public class TagImage {
	Object tagging_id;
	@Id
	String image;
	List<Map<String, Object>> tags;
	Map<String,Double> tagParsed= new HashMap<>();
	public Object getTagging_id() {
		return tagging_id;
	}
	public String getImage() {
		return image;
	}
	public List<Map<String, Object>> getTags() {
		return tags;
	}
	
	public Map<String, Double> getTagParsed() {
		return tagParsed;
	}
	public TagImage(Object tagging_id, String image, List<Map<String, Object>> tags) {
		super();
		this.tagging_id = tagging_id;
		this.image = image;
		this.tags = tags;
		for (Map<String, Object> map : tags) {
			Double num = (Double) map.get("confidence");
			String ttt = (String) map.get("tag");
			tagParsed.put(ttt,num);
		}
	}

	@Override
	public String toString() {
		return "TagImage [tagging_id=" + tagging_id + ", image=" + image + ", tags=" + tags + ", tagParsed=" + tagParsed
				+ "]";
	}
	public TagImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}