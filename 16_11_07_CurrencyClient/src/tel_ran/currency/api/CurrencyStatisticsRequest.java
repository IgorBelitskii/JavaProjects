package tel_ran.currency.api;

public class CurrencyStatisticsRequest {
	String money;
	String yearFrom;
	String yearTo;
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getYearFrom() {
		return yearFrom;
	}
	public void setYearFrom(String yearFrom) {
		this.yearFrom = yearFrom;
	}
	public String getYearTo() {
		return yearTo;
	}
	public void setYearTo(String yearTo) {
		this.yearTo = yearTo;
	}
	public CurrencyStatisticsRequest(String money, String yearFrom, String yearTo) {
		super();
		this.money = money;
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
	}
	public CurrencyStatisticsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
