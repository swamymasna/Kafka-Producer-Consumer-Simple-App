package com.swamy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.messagestore.MessageStore;
import com.swamy.producer.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class MessageRestController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@Autowired
	private MessageStore messageStore;

	@GetMapping("/send/{message}")
	public String publish(@PathVariable String message) {
		kafkaProducerService.sendData(message);
		return "Published Successfully..!";
	}
	// http://localhost:9090/kafka/send/hello

	@GetMapping("/all")
	public String getData() {
		return messageStore.getListData();
	}
	// http://localhost:9090/kafka/all
}
