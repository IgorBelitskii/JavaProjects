package tel_ran.bitwiseoperators;

public class ClassWork {

	public ClassWork() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

			int sum=0;
			for (int i = 0; i < args.length; i++) {
				sum+=Integer.parseInt(args[i]);
			}
			System.out.println(sum);
			
			for (int i = Character.getNumericValue(Character.MIN_VALUE); i<Character.getNumericValue(Character.MAX_VALUE); i++) {
				System.out.print(Character.getNumericValue(i)+",");
			}
	}

}
