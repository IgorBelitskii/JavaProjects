import java.io.*;
public class Hw03 {
	/* boolean isSum(int[] array, int sum)
	0{N} - если ли в массиве два числа равные этой сумме за 1 проход
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str="";
	    System.out.print("Введите число ");
	    int number=Integer.parseInt(reader.readLine());
	
	    System.out.print("Введите количество элементов массива:");
	    int nummas=Integer.parseInt(reader.readLine());
	    int arr[] = new int[nummas];
	    System.out.print("Введите массив из"+nummas+" чисел через Enter:");
	    for (int i=0; i<nummas; i++) {
	         str = reader.readLine();
	        arr[i] = Integer.parseInt(str);
	    }
	    System.out.println("Вы ввели "+nummas+" элементов:");
	    for (int i=0; i<nummas; i++) {
	       if (i!=nummas-1) System.out.print(arr[i]+", "); else System.out.print(arr[i]+".");
	    }
	    if (isSum(arr,number)==true) System.out.println("Есть!"); else System.out.println("Нету!");
	}
	public static boolean isSum(int[] array, int sum) {
	    int arr1[] = new int[sum];
		for (int i=0; i<array.length; i++) {
		if (array[i]<sum) {
				if (arr1[array[i]]==1) return true;
				else arr1[sum-array[i]]=1;			
			}
		}
		return false;
	}

}

