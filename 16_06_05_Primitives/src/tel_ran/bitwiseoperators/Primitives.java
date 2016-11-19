package tel_ran.bitwiseoperators;

public class Primitives {

	public Primitives() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String [] types = {"byte","short","int","long","char","float","double"};
		String [] max = new String[7];
		String [] min = new String[7];
		min[0]=String.valueOf(Byte.MIN_VALUE);
		max[0]=String.valueOf(Byte.MAX_VALUE);
		min[1]=String.valueOf(Short.MIN_VALUE);
		max[1]=String.valueOf(Short.MAX_VALUE);
		min[2]=String.valueOf(Integer.MIN_VALUE);
		max[2]=String.valueOf(Integer.MAX_VALUE);
		min[3]=String.valueOf(Long.MIN_VALUE);
		max[3]=String.valueOf(Long.MAX_VALUE);
		min[4]=String.valueOf((int)Character.MIN_VALUE);
		max[4]=String.valueOf((int)Character.MAX_VALUE);
		min[5]=String.valueOf(Float.MIN_VALUE);
		max[5]=String.valueOf(Float.MAX_VALUE);
		min[6]=String.valueOf(Double.MIN_VALUE);
		max[6]=String.valueOf(Double.MAX_VALUE);

			if (args.length==0)  { 
				for (int j = 0; j < 7; j++) {
				 System.out.println(types[j]+": min="+min[j]+", max="+max[j]);
				}
			} else {
					int num=args.length;
					for (int i=0; i<num; i++) {
						for (int j = 0; j < 7; j++) {
							if (types[j].equals(args[i])) System.out.println(types[j]+": min="+min[j]+", max="+max[j]);
						}
					}
			}
			
	
	}
		
}
	
	/*
    * ����� �� ���� �������������� ����
    * ������ 2 ������� �����
    * 1-� ������ - ���� ������ (8 �����) ������ ��������
    * 2-� ������ - ������ ���������� MIN �������� - toString
    * 3-� ������ - ������������ ��������.
    * 
    * Switch case
    * 
    * ����� ����������� � ������������ �������� ��� ����������
    * � ��������� ������ ������ ���������
    * ���� ������� ���������� �� ��� ��������
    * ���� �����-�� �� ������ �� ������� ������
    * 
    * ����� ����������� � ������������ ��� ��������� �� ���� ������� �� �������� ������
    * 
    * 
    * 
    * ��������� (�����) ���������
    * O(N) -  ���������������� N
    * O(LnN) - ��������������� ���������
    * O(N^2) ����������
    * O(1) - �� ��������� �� N
    * 
    * 
    * ���������� �� ��� - 
    * ���������� ������������ � ����������� ���� ��� ���� ����������
    * 
    */
	/*	Integer a=10;
		Integer b=10;
		Integer c=150;
		Integer d=150;
		if (a==b) System.out.println("True"); else System.out.println("False");
		if (c==d) System.out.println("True"); else System.out.println("False");
		if (a.equals(b)) System.out.println("True"); else System.out.println("False");
		if (c.equals(d)) System.out.println("True"); else System.out.println("False");
		
		
	*/	
		


