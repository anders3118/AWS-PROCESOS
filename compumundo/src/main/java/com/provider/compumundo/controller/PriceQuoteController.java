/**
 * 
 */
package com.provider.compumundo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.provider.compumundo.component.CreatePriceQuote;
import com.provider.compumundo.generatePriceQuotationFile.CreateExcel;
import com.provider.compumundo.model.PriceQuote;
import com.provider.compumundo.model.Product;
import com.provider.compumundo.smtp.SendPriceQuoteEmail;



/**
 * @author Macaipe
 *
 */
@RestController
public class PriceQuoteController {
	
	@RequestMapping(value = {
	"/ventas/crearCotizacion" }, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	
	public ResponseEntity<PriceQuote> createPriceQuote(@RequestBody(required = true) List<Product> productListReq) {
		CreatePriceQuote createPriceQuote = new CreatePriceQuote();
		PriceQuote priceQuote =  createPriceQuote.CreatePricingQuote(productListReq);
		ResponseEntity<PriceQuote> response = new ResponseEntity<PriceQuote>(priceQuote, HttpStatus.OK);
		SendPriceQuoteEmail sendEmail = new SendPriceQuoteEmail();
		CreateExcel createExcel = new CreateExcel();
		createExcel.generatePriceQuote(priceQuote);
		sendEmail.sendEmail();
		return response;
	}

}
