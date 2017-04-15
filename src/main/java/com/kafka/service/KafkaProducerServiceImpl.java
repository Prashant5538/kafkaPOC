package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kafka.dto.ProducerReqDTO;
import com.kafka.service.message.Sender;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

	@Autowired
	private Sender sender;
	@Value("${kafka.topic.helloworld}")
	private String topic;

	@Override
	public Boolean produceDataInKafkTopic(ProducerReqDTO dto) {
		sender.send(topic, dto.getMessage());
		return true;
	}

}
