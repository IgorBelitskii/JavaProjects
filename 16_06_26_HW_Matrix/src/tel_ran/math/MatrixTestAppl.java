package tel_ran.math;

import java.util.Random;

public class MatrixTestAppl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] [] arra ={{"1","1","1"},{"2","2","2"},{"3","3","3"}};
		Matrix<String> matrix = new Matrix<String>(arra);
		matrix.print();
		String[] ar={"4","4","4","4","4"};
		matrix.addColumn(ar);
		matrix.print();
		String[] ar1={"6","6","6","6","6","6"};
		matrix.addRow(ar1);
		matrix.print();
		matrix.transp();
		matrix.print();
		
	}

}
