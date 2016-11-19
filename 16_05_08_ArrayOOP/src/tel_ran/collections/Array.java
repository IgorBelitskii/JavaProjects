package src.tel_ran.collections;

public class Array {
Object [] array;
int capacity=10;
int size=0;
	public Array(){
		array = new Object[capacity];
		
	}
	public Array(int capacity) {
		this.capacity=capacity;
		array=new Object[capacity];
	}
	public void add(Object obj){
		if (size>=capacity) increaseCapacity();
		
		array[size++]=obj; //  запишет в Array[size] , затем size++;
				
	}
	public void increaseCapacity(){
		capacity=capacity*2;
		Object [] tmp=new Object[capacity];
		for (int i=0; i<size; i++) {
			tmp[i]=array[i];
		}
		array=tmp;
	}
	public int size() {
		return size;
	}
	/**
	 * 
	 * @param index
	 * @return object at the given index
	 */
	public Object get(int index){
		if (index>=size) 
			index=size-1;
		return array[index];
	}
	/**
	 * 
	 * @param index
	 * @param obj ƒобавить по индексу - если индекс не существует не делаем
	 *если индекс соответтствует то она раздвигает массив и то что вправо сдвигаетс€
	 *index<=size, index>=0
	 */
	public void add(int index, Object obj) {
		if ((index<=size)&&(index>=0)) {
			capacity=capacity+1;
			Object [] tmp=new Object[capacity];
			for (int i=0; i<index; i++) {
			tmp[i]=array[i];
			}
			tmp[index]=obj;
			for (int i=index+1; i<capacity; i++) {
				tmp[i]=array[i-1];
				}
			array=tmp;
		}
	}
	/**
	 * 
	 * @param index
	 * @return remove reference from the array at the given index;
	 * if the index value is out of [0;size-1] the function returns null
	 * otherwise function returns the reference
	 */
	public Object remove(int index) {
		if ((index<size)&&(index>=0)) {
			capacity=capacity-1;
			Object [] tmp=new Object[capacity];
			for (int i=0; i<index; i++) {
			tmp[i]=array[i];
			}
			Object obj=array[index];
			for (int i=index; i<capacity; i++) {
				tmp[i]=array[i+1];
				}
			array=tmp;
			return obj;
		} else return null;
	}
}


/*
Ќаписать три функции:
ƒобавить по индексу

boolean isSum(int[] array, int sum)
0{N} - если ли в массиве два числа равные этой сумме за 1 проход

*/