import java.io.*;
public class Hw03 {
	/* boolean isSum(int[] array, int sum)
	0{N} - ���� �� � ������� ��� ����� ������ ���� ����� �� 1 ������
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str="";
	    System.out.print("������� ����� ");
	    int number=Integer.parseInt(reader.readLine());
	
	    System.out.print("������� ���������� ��������� �������:");
	    int nummas=Integer.parseInt(reader.readLine());
	    int arr[] = new int[nummas];
	    System.out.print("������� ������ ��"+nummas+" ����� ����� Enter:");
	    for (int i=0; i<nummas; i++) {
	         str = reader.readLine();
	        arr[i] = Integer.parseInt(str);
	    }
	    System.out.println("�� ����� "+nummas+" ���������:");
	    for (int i=0; i<nummas; i++) {
	       if (i!=nummas-1) System.out.print(arr[i]+", "); else System.out.print(arr[i]+".");
	    }
	    if (isSum(arr,number)==true) System.out.println("����!"); else System.out.println("����!");
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

