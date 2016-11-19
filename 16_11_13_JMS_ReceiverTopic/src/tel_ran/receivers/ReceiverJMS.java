package tel_ran.receivers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class ReceiverJMS {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ReceiverJMS.class, args);
	}

}
