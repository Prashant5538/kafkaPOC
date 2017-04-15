package com.kafka.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class Sender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(final String topic, final String message) {
		// the KafkaTemplate provides asynchronous send methods returning a
		// Future
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
		
		// you can register a callback with the listener to receive the result
		// of the send asynchronously
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("sent message='{}' with offset={}" + message + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("unable to send message= " + message + ex.getMessage());
				ex.printStackTrace();
			}
		});
	}

	// alternatively, to block the sending thread, to await the result,
	// invoke the future's get() method

}
