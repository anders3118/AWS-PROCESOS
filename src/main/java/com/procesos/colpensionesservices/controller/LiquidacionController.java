package com.procesos.colpensionesservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.procesos.colpensionesSoR.component.CreateLiquidacion;
import com.procesos.colpensionesSoR.model.Liquidacion;

@RestController
public class LiquidacionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LiquidacionController.class);

	@RequestMapping(value = {
			"/sor/createLiquidacionIncapacidad" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Liquidacion> createLiquidacionoR(@RequestBody(required = true) Liquidacion liquidacionRQ) {
		LOGGER.info("Recibiendo petición para craer Caso en SOR");
		ResponseEntity<Liquidacion> response = null;
		try {
			CreateLiquidacion createCaso = new CreateLiquidacion();
			createCaso.create(liquidacionRQ);
			response = new ResponseEntity<>(liquidacionRQ, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
