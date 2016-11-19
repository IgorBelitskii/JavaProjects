package tel_ran.calculator.api;

public class CalculateRequest {
	double op1;
	double op2;
	String operation;
	

	public CalculateRequest(double op1, double op2, String operation) {
		super();
		this.op1 = op1;
		this.op2 = op2;
		this.operation = operation;
	}
	public CalculateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getOp1() {
		return op1;
	}
	public double getOp2() {
		return op2;
	}
	public String getOperation() {
		return operation;
	}
	
}
