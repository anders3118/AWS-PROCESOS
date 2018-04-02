package com.provider.compumundo.component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.provider.compumundo.App;
import com.provider.compumundo.model.PriceQuote;
import com.provider.compumundo.model.PriceQuoteItem;
import com.provider.compumundo.model.Product;

public class CreatePriceQuote {
	
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	
	public PriceQuote CreatePricingQuote(List<Product> productLisReq) {
		Random rnd = new Random();
		double totalWithoutDiscount;
		int facturaRandomID = 1000000 +  rnd.nextInt(9000000);
		PriceQuote priceQuote = new PriceQuote();
		
		List<PriceQuoteItem> listPriceQuote = new ArrayList<>();
		
		Date today = Calendar.getInstance().getTime();
		Calendar validUnitl = Calendar.getInstance();
		validUnitl.setTime(today);
		validUnitl.add(Calendar.DATE, 15);
		
		String priceQuoteDate = df.format(today);
		priceQuote.setPriceQuoteDate(priceQuoteDate);
		priceQuote.setClientEmail("testingtester246@gmail.com");
		priceQuote.setClientName("Francisco Giraldo");
		priceQuote.setPriceQuotePaymentMethod("Contado");
		priceQuote.setPriceQuoteValidDate(df.format(validUnitl.getTime()));
		priceQuote.setPriceQuouteId(facturaRandomID);
		priceQuote.setPriceQuoteNotes("Solamente valido para pagos de contado.");
		
		for(Product productReq: productLisReq) {
			for(Product productCatalog : App.productCatalog) {
				if(productReq.getId() == productCatalog.getId() && 
						productReq.getTitle().equals(productCatalog.getTitle())) {
					PriceQuoteItem priceQuoteItem = new PriceQuoteItem();
					priceQuoteItem.setItemID(String.valueOf(productCatalog.getId()));
					priceQuoteItem.setItemQuantity(productReq.getQuantity());
					priceQuoteItem.setItemDescription(productCatalog.getDescription());
					priceQuoteItem.setItemUnityPrice(productCatalog.getPrice());
					totalWithoutDiscount =  productCatalog.getPrice()*productReq.getQuantity();
					priceQuoteItem.setItemTotal(totalWithoutDiscount);
					listPriceQuote.add(priceQuoteItem);
				}
			}
		}
		priceQuote.setPriceQuoteItem(listPriceQuote);
		return priceQuote;
	}

}
