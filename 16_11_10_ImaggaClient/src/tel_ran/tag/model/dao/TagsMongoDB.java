package tel_ran.tag.model.dao;
import org.springframework.beans.factory.annotation.Autowired;

import tel_ran.tag.entities.TagImage;
import tel_ran.tag.repo.TagRepository;

public class TagsMongoDB {

	@Autowired
	TagRepository tags;

	public boolean addTag(TagImage tag) {

		if (tag == null || tags.exists(tag.getImage()))
			return false;
		tags.save(tag);
		return true;
	}

	public boolean addTags(Iterable<TagImage> tags) {
		this.tags.save(tags);
		return true;
	}

	public Iterable<TagImage> getAllTags() {
		return tags.findAll();
	}


	public boolean removeTag(String url) {
		if (!tags.exists(url))
			return false;
		tags.delete(url);
		return true;
	}

	public TagImage getTag(String url) {
		return tags.findOne(url);
	}

}
