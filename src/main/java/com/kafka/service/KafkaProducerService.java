package com.kafka.service;

import com.kafka.dto.ProducerReqDTO;

public interface KafkaProducerService {

	Boolean produceDataInKafkTopic(ProducerReqDTO dto);

}
