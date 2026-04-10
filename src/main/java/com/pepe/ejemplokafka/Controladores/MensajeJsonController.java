package com.pepe.ejemplokafka.Controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pepe.ejemplokafka.Modelos.Usuario;
import com.pepe.ejemplokafka.kafka.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MensajeJsonController {
	private JsonKafkaProducer kafkaJsonProd;

	public MensajeJsonController(JsonKafkaProducer kafkaJsonProd) {
		super();
		this.kafkaJsonProd = kafkaJsonProd;
	}
	@PostMapping("/publicar")
	public ResponseEntity<String> publicarJson(@RequestBody Usuario u){
		kafkaJsonProd.enviarMensajeJson(u);
		return ResponseEntity.ok("Se envió el mensaje de objeto al topic de Kafka");
	}

}
