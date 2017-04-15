//package com.kafka;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.kafka.service.message.Receiver;
//import com.kafka.service.message.Sender;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringKafkaApplicationTests {
//	
//	@Autowired
//	private Sender sender;
//
//	@Autowired
//	private Receiver receiver;
//
//	@Test
//	public void testReceive() throws Exception {
//		sender.send("Hello-Kafka", "Hello Spring Kafka!");
//		
//		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//		receiver.receive("xyz");
//		assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//	}
//}
