package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dto.ConsumerReqDTO;
import com.kafka.dto.ConsumerResponseDTO;
import com.kafka.dto.ProducerReqDTO;
import com.kafka.service.KafkaConsumerService;
import com.kafka.service.KafkaProducerService;

@RestController
@RequestMapping("/v1")
public class KafkaProducerController {
	
	@Autowired
	private KafkaProducerService producerService;
	@Autowired
	private KafkaConsumerService consumerService;
	
	@RequestMapping(value = "/produce", method = RequestMethod.POST)
	public ResponseEntity<Boolean> postMessageInKafkaTopic(@RequestBody ProducerReqDTO dto) {
		Boolean resp = producerService.produceDataInKafkTopic(dto);
		return new ResponseEntity<Boolean>(resp, HttpStatus.OK);
	}

	@RequestMapping(value = "/consume", method = RequestMethod.POST)
	public ResponseEntity<ConsumerResponseDTO> fetchMessageInKafkaTopic(@RequestBody ConsumerReqDTO dto) {
		ConsumerResponseDTO resp = consumerService.fetchMessageInKafkaTopic(dto);
		return new ResponseEntity<ConsumerResponseDTO>(resp, HttpStatus.OK);
	}
	
}
