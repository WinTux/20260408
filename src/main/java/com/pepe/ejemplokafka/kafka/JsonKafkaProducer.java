package com.pepe.ejemplokafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.pepe.ejemplokafka.Modelos.Usuario;

@Service
public class JsonKafkaProducer {
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
	private KafkaTemplate<String,Usuario> kafkaTemplate;
	public JsonKafkaProducer(KafkaTemplate<String, Usuario> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	public void enviarMensajeJson(Usuario usu) {
		logger.info(String.format("Mensaje json enviado: %s", usu.toString()));
		Message<Usuario> mensaje = MessageBuilder
				.withPayload(usu)
				.setHeader(KafkaHeaders.TOPIC, "pruebitaJson")
				.build();
		kafkaTemplate.send(mensaje);
	}
}
