package tel_ran.collections;

public interface Collection<T> extends Iterable<T>{

	void add(T number);

	void remove(T number);

	void retainAll(Collection<T> collection);

	void removeAll(Collection<T> collection);

	boolean contains(T number);

}
