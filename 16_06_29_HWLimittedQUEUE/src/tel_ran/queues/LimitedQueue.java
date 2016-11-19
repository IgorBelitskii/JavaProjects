package tel_ran.queues;

public class LimitedQueue <T> {
	int limit=0, size=0,start=0, finish=0;
	Object [] queue;

	public LimitedQueue (int limit) {
		queue = new Object[limit];
		this.limit=limit;
		size=0;
		start=0;
		finish=0;
	}
	
	
	public Object getElement(int i) {
		return queue[i];
	}
	public void add(T obj) throws OutofLimitException {
		if (finish>=limit) {throw new OutofLimitException(); } else 
		{
			queue[finish] = obj;
			size++;
			finish++;
		}// (firdtInd+size)%length 
	}
	
	@SuppressWarnings("unchecked")
	public T offer() throws EmptyQueueException {
		if (start<finish){ 
		start++;
		size--;
		return (T) queue[start-1];}
		else {throw new EmptyQueueException();}
	}
	/**
	 * 
	 * @return maximal possible number of objects in the queue
	 */
	public int getLimit(){
	
	return limit;
	}
	/**
	 * 
	 * @return number of objects in the queue
	 */
	public int getSize() {
		return size;
	}
	public void info() {
		System.out.println("Start:"+start+" Last element:"+(finish-1)+" Limit:"+limit+"  Size:"+size);
	}
}
