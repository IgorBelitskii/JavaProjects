package tel_ran.currency.api;

public class CurrencyRequest {
String cur1;
public CurrencyRequest(String cur1, String cur2, double count) {
	super();
	this.cur1 = cur1;
	this.cur2 = cur2;
	this.count = count;
}
String cur2;
double count;

public CurrencyRequest() {
	super();
	// TODO Auto-generated constructor stub
}

public String getCur1() {
	return cur1;
}
public String getCur2() {
	return cur2;
}
public double getCount() {
	return count;
}
@Override
public String toString() {
	return "CurrencyRequest [cur1=" + cur1 + ", cur2=" + cur2 + ", count=" + count;
}

public void setCur1(String cur1) {
	this.cur1 = cur1;
}

public void setCur2(String cur2) {
	this.cur2 = cur2;
}

public void setCount(double count) {
	this.count = count;
}

}
