/**
 * 
 */
package com.provider.compumundo.model;

import java.util.List;

/**
 * @author Macaipe
 *
 */
public class PriceQuote {
	
	private int priceQuouteId;
	private final String companyName = "CompuMundo";
	private final String companyAddress = "Av Siempre Viva Calle false 15";
	private final String companyCity = "Bogota";
	private final String companyMobile = "315-890 8345";
	private final String companyEmail = "pujarqesp@gmail.com";
	private final String asesorName = "Milagros Urbina";
	
	private String clientName;
	private String priceQuoteDate;
	private String clientEmail;
	private String priceQuoteValidDate;
	private String priceQuotePaymentMethod;
	private String priceQuoteNotes;
	private List<PriceQuoteItem> priceQuoteItem;
		
	public PriceQuote() {
		super();
	}

	public int getPriceQuouteId() {
		return priceQuouteId;
	}

	public void setPriceQuouteId(int priceQuouteId) {
		this.priceQuouteId = priceQuouteId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPriceQuoteDate() {
		return priceQuoteDate;
	}

	public void setPriceQuoteDate(String priceQuoteDate) {
		this.priceQuoteDate = priceQuoteDate;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getPriceQuoteValidDate() {
		return priceQuoteValidDate;
	}

	public void setPriceQuoteValidDate(String priceQuoteValidDate) {
		this.priceQuoteValidDate = priceQuoteValidDate;
	}

	public String getPriceQuotePaymentMethod() {
		return priceQuotePaymentMethod;
	}

	public void setPriceQuotePaymentMethod(String priceQuotePaymentMethod) {
		this.priceQuotePaymentMethod = priceQuotePaymentMethod;
	}

	public List<PriceQuoteItem> getPriceQuoteItem() {
		return priceQuoteItem;
	}

	public void setPriceQuoteItem(List<PriceQuoteItem> priceQuoteItem) {
		this.priceQuoteItem = priceQuoteItem;
	}

	public String getAsesorName() {
		return asesorName;
	}
	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public String getCompanyMobile() {
		return companyMobile;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public String getPriceQuoteNotes() {
		return priceQuoteNotes;
	}

	public void setPriceQuoteNotes(String priceQuoteNotes) {
		this.priceQuoteNotes = priceQuoteNotes;
	}
	
}