package tel_ran.pictures.model.entities;

public class Picture {
String url;
String[] tags;
public String getUrl() {
	return url;
}
public String[] getTags() {
	return tags;
}
public Picture(String url, String[] tags) {
	this.url = url;
	this.tags = tags;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((url == null) ? 0 : url.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Picture other = (Picture) obj;
	if (url == null) {
		if (other.url != null)
			return false;
	} else if (!url.equals(other.url))
		return false;
	return true;
}

}
