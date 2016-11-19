package senderjms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import tel_ran.common.Point;
import tel_ran.common.PointZ;

@SpringBootApplication
public class SenderJMS {
	@Bean
	public MessageConverter createMessageConverter() {
		MappingJackson2MessageConverter res = new MappingJackson2MessageConverter();
		res.setTargetType(MessageType.TEXT);
		res.setTypeIdPropertyName("_type");
		return res;
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SenderJMS.class, args);
		JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
		jmsTemplate.setPubSubDomain(false); // FALSE = QUEUE // TRUE = TOPIC
	//	jmsTemplate.convertAndSend("tel_ran_string","Hello json tel_ran");
		jmsTemplate.convertAndSend("tel_ran_point", new PointZ(2,3,4));
		ctx.close();

	}

}
