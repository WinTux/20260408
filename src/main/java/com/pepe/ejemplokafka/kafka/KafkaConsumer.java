package com.pepe.ejemplokafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	@KafkaListener(topics="pruebita", groupId="miGrupito")
	public void consumir(String mensaje) {
		// Lógica de negocio
		logger.info(String.format("Se recibió el mensaje: %s", mensaje));
	}
}
