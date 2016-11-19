package tel_ran.queues;

public class LimitedQueue<T> {
Object[] queue;
int firstInd;
int size;
public LimitedQueue (int limit){
	queue=new Object[limit];
}
public void add(T obj) throws OutOfLimitException {
	if(size==queue.length)
		throw new OutOfLimitException();
	queue[(firstInd+size)%queue.length]=obj;
	size++;
	
}
@SuppressWarnings("unchecked")
public T offer() throws EmptyQueueException {
	if(size==0)
		throw new EmptyQueueException();
	
	T res=(T) queue[firstInd];
	queue[firstInd]=null;
	firstInd=(firstInd+1)%queue.length;
	size--;
	return res;
}
/**
 * 
 * @return maximal possible number of objects in the queue
 */
public int getLimit(){
	//TODO
	return queue.length;
}
/**
 * 
 * @return number of objects in the queue
 */
public int getSize() {
	//TODO
	return size;
}
}
