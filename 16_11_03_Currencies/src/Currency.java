import java.util.Date;
import java.util.Map;

public class Currency {
    private String base;
    private Date date;
    private Map<String, Double> rates;
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