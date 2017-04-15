package com.kafka.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.dto.ConsumerReqDTO;
import com.kafka.dto.ConsumerResponseDTO;
import com.kafka.service.message.Receiver;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
	
	@Autowired
	private Receiver receiver;

	@Override
	public ConsumerResponseDTO fetchMessageInKafkaTopic(ConsumerReqDTO dto) {
		try {
			receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
