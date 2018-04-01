package com.procesos.colpensionesservices.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.procesos.colpensionesSoR.component.AfiliadosInsert;
import com.procesos.colpensionesSoR.component.CalcularLiquidacion;
import com.procesos.colpensionesSoR.component.CasosDAO;
import com.procesos.colpensionesSoR.component.DocumentosDAO;
import com.procesos.colpensionesSoR.component.LiquidacionDAO;
import com.procesos.colpensionesSoR.component.SorDAO;
import com.procesos.colpensionesSoR.model.ActualizaSor;
import com.procesos.colpensionesSoR.model.Afiliados;
import com.procesos.colpensionesSoR.model.Casos;
import com.procesos.colpensionesSoR.model.Documentos;
import com.procesos.colpensionesSoR.model.ReabrirCaso;

@RestController
public class SoRController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SoRController.class);

	
	@RequestMapping(value = {
	"sor/createAfiliados/idAfiliadoSystema/{idAfiliadoSystema}/segmentoAfiliado/{segmentoAfiliado}/estadoProcAfiliado/{estadoProcAfiliado}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> afiliadosSoR(@PathVariable String idAfiliadoSystema,  @PathVariable String segmentoAfiliado, @PathVariable String estadoProcAfiliado) {
		LOGGER.info("Recibiendo petición para insertar SOR");
		ResponseEntity<String> response = null;
		try {
			Afiliados afiliado = new Afiliados(idAfiliadoSystema, segmentoAfiliado, estadoProcAfiliado);
			AfiliadosInsert insertAfiliados = new AfiliadosInsert();
			boolean responseInsert = insertAfiliados.insertAfiliado(afiliado);
			response = new ResponseEntity<>(
					(responseInsert ? "{\"status\": \"SUCCESS!\"}" : "{\"status\": \"ERROR!\"}"), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(value = {
			"sor/createCasoIncapacidad/n/{n}/d/{d}/a/{a}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Casos> createCasoSoR(@PathVariable String n,  @PathVariable String d, @PathVariable Integer a) {
		LOGGER.info("Recibiendo petición para craer Caso en SOR");
		ResponseEntity<Casos> response = null;
		try {
			Casos casos = new Casos();
			casos.setDescripcion(d);
			casos.setNumeroAfiliado(n);
			casos.setIdCasoAnterior(a);
			
			CasosDAO createCaso = new CasosDAO();
			Integer idCaso = createCaso.create(casos);
			casos.setIdCaso(idCaso);

			response = new ResponseEntity<>(casos, HttpStatus.OK);
			LOGGER.info("Caso => " + casos);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@RequestMapping(value = {
	"sor/createDocumentosoR/i/{i}/n/{n}/" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Documentos> createDocumentosoR(@PathVariable Integer i,  @PathVariable String n) {
		LOGGER.info("Recibiendo petición para craer Caso en SOR");
		ResponseEntity<Documentos> response = null;
		try {
			Documentos documentos = new Documentos();
			documentos.setDocumentName(n);
			documentos.setDocumentPath("PROCESOS_ROOT/SOLICITUDES/"+i);
			documentos.setDocumentStatus("PENDIENTE");
			documentos.setIdCaso(i);
			
			DocumentosDAO createCaso = new DocumentosDAO();
			createCaso.create(documentos);
			response = new ResponseEntity<>(documentos, HttpStatus.OK);
			LOGGER.info("Respuesta crear documento " + documentos);
		} catch (Exception e) {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}


	/**
	 * Este metodo actualiza la fecha fin del documento Si NO es viable se coloca
	 * liquidacion en cero Si SI es viable se actualiza fecha fin de liquidacion
	 * 
	 * @param casoRQ
	 * @return
	 */
	@RequestMapping(value = {
	"sor/actualizaSor/i/{i}/f/{f}/b/{b}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> actualizaSor(@PathVariable Integer i, @PathVariable Boolean f, @PathVariable String b) {
		LOGGER.info("Recibiendo petición para actualizar documento en SOR");
		ResponseEntity<String> response = null;
		try {
			ActualizaSor actualizaSor = new ActualizaSor();
			actualizaSor.setIdCaso(i);
			actualizaSor.setFavorable(f);
			actualizaSor.setBaseCotizacion(b);
			
			SorDAO sorDAO = new SorDAO();
			sorDAO.actualizarSor(actualizaSor);
			response = new ResponseEntity<>("{\"status\": \"SUCCESS!\"}", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>("{\"status\": \"ERROR!\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	
	/**
	 * Este metodo actualiza la fecha fin del documento Si NO es viable se coloca
	 * liquidacion en cero Si SI es viable se actualiza fecha fin de liquidacion
	 * 
	 * @param casoRQ
	 * @return
	 */
	
	
	@RequestMapping(value = {
	"sor/reabrirCaso/i/{idAnt}/id/{identificacion}/d/{docTutelaName}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> reabrirCaso(@PathVariable Integer idAnt, @PathVariable String identificacion, @PathVariable String docTutelaName) {
		LOGGER.info("Recibiendo petición para reabrir caso en el SOR");
		ResponseEntity<String> response = null;
		try {
			ReabrirCaso reabrirCaso = new ReabrirCaso();
			reabrirCaso.setCaso(new Casos());
			reabrirCaso.setDocumento(new Documentos());
			
			reabrirCaso.getCaso().setDescripcion("TUTELA");
			reabrirCaso.getCaso().setIdCasoAnterior(idAnt);
			reabrirCaso.getCaso().setNumeroAfiliado(identificacion);
			
			reabrirCaso.getDocumento().setDocumentName(docTutelaName);
			reabrirCaso.getDocumento().setDocumentPath("/PROCESOS_ROOT/SOLICITUDES/"+idAnt);
			reabrirCaso.getDocumento().setDocumentStatus("OK");
			reabrirCaso.getDocumento().setEndDate(new java.sql.Date((new Date()).getTime()));
			reabrirCaso.getDocumento().setStartDate(new java.sql.Date((new Date()).getTime()));
			reabrirCaso.getDocumento().setIdCaso(null);
			
			reabrirCaso.setBaseCotizacion("0");
			
			SorDAO sorDAO = new SorDAO();
			int idCaso = sorDAO.reabrirCaso(reabrirCaso); 
			response = new ResponseEntity<>("{\"idCaso\": " + idCaso + "}", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>("{\"idCaso\": \"0\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	/**
	 * Este metodo actualiza la fecha fin del documento Si NO es viable se coloca
	 * liquidacion en cero Si SI es viable se actualiza fecha fin de liquidacion
	 * 
	 * @param casoRQ
	 * @return
	 */
	
	@RequestMapping(value = {
	"sor/calcularLiquidacion/i/{i}/b/{b}/di/{di}/dm/{dm}" }, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> calcularLiquidacion(@PathVariable Integer i, @PathVariable String b, @PathVariable Integer di,  @PathVariable Integer dm) {
		LOGGER.info("Recibiendo petición para calcular liquidacion");
		ResponseEntity<String> response = null;
		try {
			CalcularLiquidacion liquidacion = new CalcularLiquidacion();
			liquidacion.setIdCaso(i);
			liquidacion.setBaseCotizacion(b);
			liquidacion.setDiasIncapacidad(di);
			liquidacion.setDiasMora(dm);
			
			LOGGER.info("Calculando liquidacion con ==> " + liquidacion);
			
			LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
			liquidacionDAO.updateLiquidacion(liquidacion);			
			response = new ResponseEntity<>("{\"status\": \"SUCCESS!\"}", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al calcular liquidacion ", e);
			response = new ResponseEntity<>("{\"status\": \"ERROR!\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
