package com.procesos.colpensionesservices.controller;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.procesos.colpensionesservices.model.Afiliado;



@RestController
public class RulesServices {

	private static final Logger LOGGER = LoggerFactory.getLogger(RulesServices.class);

	@RequestMapping(value = {
			"/calcularPorcentajeLiquidacion" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Afiliado> calcularPorcentajeLiquidacion(@RequestBody(required = true) Afiliado afiliadoRQ) {
		ResponseEntity<Afiliado> response = null;
		LOGGER.info("Recibiendo petición para calcular porcentaje de liquidación");
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			FactHandle fact1;

			fact1 = kSession.insert(afiliadoRQ);
			kSession.fireAllRules();


			response = new ResponseEntity<>(afiliadoRQ, HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("Error al calcular porcentaje de liquidación", e);
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	
}
