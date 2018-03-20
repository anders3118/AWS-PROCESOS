package com.procesos.colpensionesservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.procesos.colpensionesSoR.component.AfiliadosInsert;
import com.procesos.colpensionesSoR.model.Afiliados;

@RestController
public class AfiliadoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AfiliadoController.class);

	@RequestMapping(value = {
			"/sor/afiliados" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Afiliados> afiliadosSoR(@RequestBody(required = true) Afiliados afiliadoRQ) {
		LOGGER.info("Recibiendo petición para insertar SOR");
		ResponseEntity<Afiliados> response = null;
		try {
			AfiliadosInsert insertAfiliados = new AfiliadosInsert();
			insertAfiliados.insertAfiliado(afiliadoRQ);
			response = new ResponseEntity<>(afiliadoRQ, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
