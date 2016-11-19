package tel_ran.math;

import java.util.Arrays;

public class Matrix<T> {				//	ряд		строка
								/* column row*/
	Object [][] matrix = new Object[0][0];
	public int size=0;
	
		public Matrix(Object[][] matrix) {
		this.matrix = matrix;
		this.size=matrix.length;
	}

	/*добавление ряда (колонки) */
	public void addColumn(T[] column) {
		int len=column.length;
		int max=0;
		if (len>size) max=len; else max=size+1;
		Object matNew [] [] = new Object [max] [max]; 
			
			for (int i=0; i<size; i++) {
				System.arraycopy(matrix[i], 0, matNew[i], 0, size);
			}
			System.arraycopy(column, 0, matNew[size], 0, len);
			matrix = matNew;
			size=max;
		

		/**
		 *  Если колонка меньше то недостающие добавить null
		 *  Если колонка больше остальных то добавить в недостающие элементы null
		 *  
		 *  T obj = (T) matrix [0][0]; - можно внутри работать с типом которого мы не знаем - 
		 *  параметризованные типы
		 */
		 
	}
	
	/* добавление строки */
	public void addRow(T[] row) {
		int len=row.length;
		int max=0;
		if (len>size) max=len; else max=size+1;
		Object matNew [] [] = new Object [max] [max]; 
		for (int i=0; i<size; i++) {
			System.arraycopy(matrix[i], 0, matNew[i], 0, size);
		}
		for (int i = 0; i < len; i++) {
			matNew[i][size]=row[i];
		}
		matrix = matNew;
		size=max;
		/**
		 *  Если строка меньше то недостающие добавить null
		 *  Если строка больше остальных то добавить в недостающие элементы null
		 */
		 
	}
	/**
	 * 1 2 3    1 4
	 * 4 5 6 	2 5	
	 			3 6 */
	public void transp(){
		Object matNew [] [] = new Object [size] [size]; 
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matNew[i][j] = matrix[j][i];
			}
		}
		matrix=matNew;
	}
	
	public void print() {
		System.out.println("---=:[Matrix "+size+"x"+size+"]:=---");
		for (int i = 0; i < size; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
}
