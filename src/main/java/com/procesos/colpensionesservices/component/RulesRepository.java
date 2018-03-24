package com.procesos.colpensionesservices.component;

import javax.annotation.PostConstruct;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RulesRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(RulesRepository.class);
	private KieSession kieSessionNormatividad;
	private KieSession kieSessionFavorabilidad;
	
	public RulesRepository() {
	}

	@PostConstruct
	public void startUp() {
		rulesVerificarnormatividad();
		rulesFavorabilidad();
	}
	
	private void rulesVerificarnormatividad() {
		try {
			KieServices kieServices = KieServices.Factory.get();
			Resource dt = ResourceFactory.newClassPathResource("rules.xls", getClass());
			KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);

			KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
			kieBuilder.buildAll();

			KieRepository kieRepository = kieServices.getRepository();

			ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
			KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);

			this.kieSessionNormatividad = kieContainer.newKieSession();

		} catch (Exception e) {
			LOGGER.error("Error al cargar las reglas de negocio de normatividad", e);
		}
	}
	
	private void rulesFavorabilidad() {
		try {
			KieServices kieServices = KieServices.Factory.get();
			Resource dt = ResourceFactory.newClassPathResource("rulesFavorabilidad.xls", getClass());
			KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);

			KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
			kieBuilder.buildAll();

			KieRepository kieRepository = kieServices.getRepository();

			ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
			KieContainer kieContainer = kieServices.newKieContainer(krDefaultReleaseId);

			this.kieSessionFavorabilidad = kieContainer.newKieSession();

		} catch (Exception e) {
			LOGGER.error("Error al cargar las reglas de negocio de favorabilidad", e);
		}
	}

	public KieSession getKieSessionNormatividad() {
		return kieSessionNormatividad;
	}

	public void setKieSessionNormatividad(KieSession kieSessionNormatividad) {
		this.kieSessionNormatividad = kieSessionNormatividad;
	}

	public KieSession getKieSessionFavorabilidad() {
		return kieSessionFavorabilidad;
	}

	public void setKieSessionFavorabilidad(KieSession kieSessionFavorabilidad) {
		this.kieSessionFavorabilidad = kieSessionFavorabilidad;
	}
	
	
}
