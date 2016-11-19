public class CalculatorExpression {
	
	public static void main(String args[]) {
		
		System.out.println(calculate("2+12-4"));
		System.out.println(calculate("15-7-3"));
		System.out.println(calculate("10+5/3"));
		System.out.println(calculate("2*2"));
		System.out.println(calculate(" 2*2"));
		System.out.println(calculate("2*2 "));
		System.out.println(calculate("1000/Test100-7")); //test bad symbols
		System.out.println(calculate("1000/0-7"));  //test division by zero
		
	}
	/**
	 *  все операции  + - * и делить без приоритетов 
	 * @param expression - string contains arithmetic expression, e.g. "10*3/2+5" with four arithmetic operations 
	 * and naturan > 0 matches
	 * if the given expression contains disallowed symbols the method should return 0
	 * in the case of zero division the method should return 0;
	 * arithmetic operation preferences are not taken into consideration
	 * @return
	 */
	public static int calculate(String expression) {
		expression=expression.trim();
		String req="\\D+"; //all not-digits go to array
		String numbers[]=expression.split(req);
		req="[^+-/*//]+"; //all non-operands go to array
		String operators[]=expression.split(req);
		req="[0-9+-/*//]+"; //test that string matches only numbers and operands
		boolean test=expression.matches(req);
		if ((numbers.length!=operators.length)||(test==false)) return 0;
		int res=Integer.parseInt(numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			switch (operators[i]) {
			case "+":
				res+=Integer.parseInt(numbers[i]);
					break;
			case "-":
				res-=Integer.parseInt(numbers[i]);
					break;
			case "*":
				res*=Integer.parseInt(numbers[i]);
					break;
			case "/":
				if (Integer.parseInt(numbers[i])!=0) res/=Integer.parseInt(numbers[i]);
				else return 0;
					break;
			default:
				return 0;
			}
		}
	
		return res;
	
	}

}
