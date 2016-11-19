package tel_ran.currency.entities;
import java.util.Date;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="currencies")
public class Currency {
    private String base;
    private Date date;
    private Map<String, Double> rates;
    @Id
    private long time;
    
    public Currency() {
		super();
	}
	public void setBase(String base) {
		this.base = base;
	}
	public void setDate(Date date) {
		this.date = date;
		this.time=date.getTime();
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	public Currency(String base, Date date, Map<String, Double> rates) {
		super();
		this.base = base;
		this.date = date;
		this.rates = rates;
		this.time=date.getTime();
	}

    public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getBase() {
        return base;
    }
    public Date getDate() {
        return date;
    }
    public Map<String, Double> getRates() {
        return rates;
    }
    @Override
    public String toString() {
 return "Currency [base=" + base + ", date=" + date + ", rates=" + rates + "]";
    }
    
    

}