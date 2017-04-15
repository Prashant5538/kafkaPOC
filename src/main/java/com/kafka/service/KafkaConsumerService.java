package com.kafka.service;

import com.kafka.dto.ConsumerReqDTO;
import com.kafka.dto.ConsumerResponseDTO;

public interface KafkaConsumerService {

	ConsumerResponseDTO fetchMessageInKafkaTopic(ConsumerReqDTO dto);

}
