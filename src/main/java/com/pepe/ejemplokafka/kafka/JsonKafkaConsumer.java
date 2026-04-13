package com.pepe.ejemplokafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pepe.ejemplokafka.Modelos.Usuario;

@Service
public class JsonKafkaConsumer {
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	@KafkaListener(topics="pruebitaJson", groupId="miGrupito")
	public void consumir(Usuario mensaje) {
		// Lógica de negocio
		logger.info(String.format("Se recibió el mensaje json: %s", mensaje));
	}
}
