package com.procesos.colpensionesservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.procesos.colpensionesSoR.component.CreateCasos;
import com.procesos.colpensionesSoR.model.Casos;

@RestController
public class CasosController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CasosController.class);

	@RequestMapping(value = {
			"/sor/createCasosIncapacidad" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Casos> createCasoSoR(@RequestBody(required = true) Casos casosRQ) {
		LOGGER.info("Recibiendo petición para craer Caso en SOR");
		ResponseEntity<Casos> response = null;
		try {
			CreateCasos createCaso = new CreateCasos();
			createCaso.create(casosRQ);
			response = new ResponseEntity<>(casosRQ, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
