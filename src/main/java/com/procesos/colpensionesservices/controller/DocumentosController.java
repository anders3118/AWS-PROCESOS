package com.procesos.colpensionesservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.procesos.colpensionesSoR.component.CreateDocumentos;
import com.procesos.colpensionesSoR.model.Documentos;

@RestController
public class DocumentosController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentosController.class);

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

}
