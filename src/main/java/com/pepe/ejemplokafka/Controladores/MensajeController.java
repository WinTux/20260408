package com.pepe.ejemplokafka.Controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pepe.ejemplokafka.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka") // http://localhost:8080/api/v1/kafka
public class MensajeController {
	private KafkaProducer kafkaProd;

	public MensajeController(KafkaProducer kafkaProd) {
		super();
		this.kafkaProd = kafkaProd;
	}
	@GetMapping("/publicar") // http://localhost:8080/api/v1/kafka/publicar?mensajito=Pepe
	public ResponseEntity<String> publicar(@RequestParam("mensajito") String msj){
		kafkaProd.enviarMensaje(msj);
		return ResponseEntity.ok("Mensaje enviado al topic.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
