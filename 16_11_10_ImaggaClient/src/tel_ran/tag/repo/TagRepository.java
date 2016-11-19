package tel_ran.tag.repo;

import org.springframework.data.repository.CrudRepository;

import tel_ran.tag.entities.TagImage;

public interface TagRepository extends CrudRepository<TagImage, String> {

}
