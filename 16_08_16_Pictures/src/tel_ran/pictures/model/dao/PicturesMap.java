package tel_ran.pictures.model.dao;

import tel_ran.pictures.model.entities.Picture;
import tel_ran.pictures.model.interfaces.IPictures;
import java.util.*;
import java.util.Map.Entry;
public class PicturesMap implements IPictures {
 // ключ будет tag
	
	// все картинки имеют так спорт
	//TODO Инициализовать = new
	// tag 			list url
	private HashMap<String, HashSet <String>> tagsPictures= new HashMap<>(); // key - tag; value - (Hash)set of url's designated pictures with the tag
	// url			picture
	private HashMap<String, Picture> pictures = new HashMap<>(); // key - url; value - picture object reference with url
	
	@Override
	public boolean addPicture(Picture picture) {
		String url=picture.getUrl();
		if (pictures.containsKey(url)) return false;
		pictures.put(url, picture);
		
		for (String tag : picture.getTags()) {
			HashSet<String> arrurls = new HashSet<>();
			if (tagsPictures.containsKey(tag)) 
				 arrurls = tagsPictures.get(tag);			
			arrurls.add(url);
			tagsPictures.put(tag, arrurls);
		}
		return true;
	}

	@Override
	/**
	 * Similar if between two pictures number of tags is 
	 * совпадает больше 50% тагов то они похожи
	 * 
	 */
	public Iterable<Picture> findSimilar(Picture picture) {
			String[] tags =picture.getTags();
			String url=picture.getUrl();
			int porog=(int)(0.5+tags.length/2);
			HashSet<Picture> result = new HashSet<Picture>();
			int count=0;
			HashMap<String, Integer> hashmap = new HashMap<>();
			for (String tag: tags) {
				for (String url1: tagsPictures.get(tag)) {
	//			- Все URL имеющие tag
					Integer x = hashmap.put(url1,1);
					if (x!=null) 
						hashmap.put(url1,x+1);
				}
			}
			for (Map.Entry<String,Integer> entry: hashmap.entrySet()) {
				if (entry.getValue()>=porog) {
					result.add(pictures.get(entry.getKey()));
				}
			}

						
			return result;
	}

	@Override
	public Picture getPicture(String url) {

		return pictures.get(url);
	}

}
