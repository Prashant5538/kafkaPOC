package com.kafka.service.message;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

	private CountDownLatch latch = new CountDownLatch(100);

	//Hello-Kafka
	@KafkaListener(topics = "${kafka.topic.helloKafka}")
	public void receive(String message) {
		System.out.println("received message= " + message);
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
