package senderjms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SenderJMS {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SenderJMS.class, args);
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.setPubSubDomain(true); // for topic regardless of application properties
	
		
		for (int i = 0; i < 1000; i++) {
			String message="Hello Telran "+i;
			jmsTemplate.send("tel_ran_group", session->session.
					createTextMessage(message));
		}
		ctx.close();

	}

}
