package tel_ran.calculator.model;

import java.util.*;

import tel_ran.calculator.interfaces.IOperation;

public class CalculatorModel {
	Map<String, IOperation> mapOperations;

	public CalculatorModel() {
		mapOperations = new LinkedHashMap<>();
		mapOperations.put("+", (a, b) -> a + b);
		mapOperations.put("-", (a, b) -> a - b);
		mapOperations.put("*", (a, b) -> a * b);
		mapOperations.put("/", (a, b) -> b == 0 ? Double.MAX_VALUE : a / b);
	}

	public Set<String> getOperations() {
		return mapOperations.keySet();
	}

	public double calculate(double op1, double op2, String operation) {
		if (!mapOperations.containsKey(operation))
			return Double.NaN;
		return mapOperations.get(operation).calculate(op1, op2);
	}

}
