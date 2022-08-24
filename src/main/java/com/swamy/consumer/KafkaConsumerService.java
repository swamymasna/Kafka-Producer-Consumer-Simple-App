package com.swamy.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.swamy.messagestore.MessageStore;

@Component
public class KafkaConsumerService {

	@Autowired
	private MessageStore messageStore;
	
	@KafkaListener(topics = "myTopic1", groupId = "group-id")
	public void readMessage(String message) {
		messageStore.addMessages(message);
		System.out.println(message);
	}
}

