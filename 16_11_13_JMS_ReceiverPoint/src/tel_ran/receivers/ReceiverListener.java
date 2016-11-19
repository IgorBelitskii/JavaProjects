package tel_ran.receivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tel_ran.common.PointZ;
import tel_ran.common.Point;
@Component
public class ReceiverListener {
	static final String NAME ="Receiver1";
	@JmsListener(destination="tel_ran_string")
	public void readString(String string) {
		System.out.println(NAME+" took as as string: " + string);
	}
	
	@JmsListener(destination="tel_ran_point")
	public void readPoint(Point point) {
		System.out.println(NAME+" took as a point: " + point);
	}
	

	
}
