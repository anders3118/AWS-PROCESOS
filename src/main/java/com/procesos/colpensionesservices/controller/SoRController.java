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
import com.procesos.colpensionesSoR.component.CreateCasos;
import com.procesos.colpensionesSoR.component.CreateDocumentos;
import com.procesos.colpensionesSoR.component.CreateLiquidacion;
import com.procesos.colpensionesSoR.model.Afiliados;
import com.procesos.colpensionesSoR.model.Casos;
import com.procesos.colpensionesSoR.model.Documentos;
import com.procesos.colpensionesSoR.model.Liquidacion;

@RestController
public class SoRController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SoRController.class);

	@RequestMapping(value = {
			"/sor/createAfiliados" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> afiliadosSoR(@RequestBody(required = true) Afiliados afiliadoRQ) {
		LOGGER.info("Recibiendo petición para insertar SOR");
		ResponseEntity<String> response = null;
		try {
			AfiliadosInsert insertAfiliados = new AfiliadosInsert();
			boolean responseInsert = insertAfiliados.insertAfiliado(afiliadoRQ);
			response = new ResponseEntity<>((responseInsert ? "{\"status\": \"SUCCESS!\"}" : "{\"status\": \"ERROR!\"}"), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(value = {
			"/sor/createCasoIncapacidad" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Casos> createCasoSoR(@RequestBody(required = true) Casos casosRQ) {
		LOGGER.info("Recibiendo petición para craer Caso en SOR");
		ResponseEntity<Casos> response = null;
		try {
			CreateCasos createCaso = new CreateCasos();
			Integer idCaso = createCaso.create(casosRQ);
			casosRQ.setIdCaso(idCaso);

			response = new ResponseEntity<>(casosRQ, HttpStatus.OK);
			LOGGER.info("Caso => " + casosRQ);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(value = {
			"/sor/createDocumentosIncapacidad" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Documentos> createDocumentosoR(@RequestBody(required = true) Documentos documentosRQ) {
		LOGGER.info("Recibiendo petición para craer Caso en SOR");
		ResponseEntity<Documentos> response = null;
		try {
			CreateDocumentos createCaso = new CreateDocumentos();
			createCaso.create(documentosRQ);
			response = new ResponseEntity<>(documentosRQ, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

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
