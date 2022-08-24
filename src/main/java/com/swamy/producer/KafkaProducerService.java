package com.swamy.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, String>kafkaTemplate;
	
	private static final String TOPIC = "myTopic1";
	
	public void sendData(String message) {
		kafkaTemplate.send(TOPIC, message);
	}
}
