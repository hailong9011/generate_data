package atwom.work.receive_ms_kafka.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import atwom.work.receive_ms_kafka.constant.KafkaConst;

@Service
public class KafkaConsumerService {
	private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@KafkaListener(topics = "kafka", groupId = KafkaConst.GROUP_ID)
	public void listenTopic(String message) {
		logger.info(String.format("Message recieved -> %s", message));
	}
	
	@KafkaListener(topics = "demo", groupId = KafkaConst.GROUP_ID)
	public void listenTopic1(String message) {
		logger.info(String.format("Message recieved -> %s", message));
	}
	
	@KafkaListener(topics = "stag", groupId = KafkaConst.GROUP_ID)
	public void listenTopic2(String message) {
		logger.info(String.format("Message recieved -> %s", message));
	}
}
