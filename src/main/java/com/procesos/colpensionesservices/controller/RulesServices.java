package com.procesos.colpensionesservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.procesos.colpensionesservices.component.RulesRepository;
import com.procesos.colpensionesservices.model.Afiliado;

@RestController
public class RulesServices {

	private static final Logger LOGGER = LoggerFactory.getLogger(RulesServices.class);

	@Autowired
	public RulesRepository repository;

	@RequestMapping(value = {
			"rules/verificarNormatividad/edad/{edad}/semanasCotizadas/{semanasCotizadas}/tiempoCotizacion/{tiempoCotizando}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Afiliado> verificarNormatividad(@PathVariable Integer edad,
			@PathVariable Integer semanasCotizadas, @PathVariable Integer tiempoCotizando) {
		ResponseEntity<Afiliado> response = null;
		LOGGER.info("Recibiendo petición para verificar Normatividad");
		try {
			Afiliado afiliadoRQ = new Afiliado();
			afiliadoRQ.setEdad(edad);
			afiliadoRQ.setSemanasCotizadas(semanasCotizadas);
			afiliadoRQ.setTiempoCotizacion(tiempoCotizando);

			repository.getKieSessionNormatividad().insert(afiliadoRQ);
			repository.getKieSessionNormatividad().fireAllRules();
			response = new ResponseEntity<>(afiliadoRQ, HttpStatus.OK);
			LOGGER.info("Respuesta => " + afiliadoRQ);
		} catch (Exception e) {
			LOGGER.error("Error al verificar la normatividad", e);
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(value = {
			"rules/verificarFavorabilidad/e/{edad}/s/{semanasCotizadas}/t/{tiempoCotizando}/a/{aplica}/p/{perdida}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Afiliado> verificarFavorabilidad(@PathVariable Integer edad,
			@PathVariable Integer semanasCotizadas, @PathVariable Integer tiempoCotizando, @PathVariable Boolean aplica,
			@PathVariable Integer perdida) {
		ResponseEntity<Afiliado> response = null;
		LOGGER.info("Recibiendo petición para verificar Favorabilidad");
		try {
			Afiliado afiliadoRQ = new Afiliado();
			afiliadoRQ.setEdad(edad);
			afiliadoRQ.setSemanasCotizadas(semanasCotizadas);
			afiliadoRQ.setTiempoCotizacion(tiempoCotizando);
			afiliadoRQ.setAplicaPensionInvalidez(aplica);
			afiliadoRQ.setPerdidaCapacidadLaboral(perdida);
			
			repository.getKieSessionFavorabilidad().insert(afiliadoRQ);
			repository.getKieSessionFavorabilidad().fireAllRules();
			response = new ResponseEntity<>(afiliadoRQ, HttpStatus.OK);
			LOGGER.info("Respuesta => " + afiliadoRQ);
		} catch (Exception e) {
			LOGGER.error("Error al verificar la normatividad", e);
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
