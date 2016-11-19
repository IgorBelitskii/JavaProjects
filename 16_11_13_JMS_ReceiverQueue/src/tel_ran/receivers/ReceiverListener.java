package tel_ran.receivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class ReceiverListener {
	static final String NAME ="Receiver1";
	@JmsListener(destination="tel_ran_group")
	public void readTextMessage(String message) {
		System.out.println(NAME+ message);
	}
}
