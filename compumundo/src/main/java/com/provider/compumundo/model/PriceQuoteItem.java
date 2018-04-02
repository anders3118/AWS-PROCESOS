/**
 * 
 */
package com.provider.compumundo.model;

/**
 * @author Macaipe
 *
 */
public class PriceQuoteItem {
	
	private String itemID;
	private String itemDescription;
	private double itemQuantity;
	private double itemUnityPrice;
	private double itemTotal;
	
	public PriceQuoteItem() {
		super();
	}

	public PriceQuoteItem(String itemID, String itemDescription, int itemQuantity, int itemUnityPrice, int itemTotal) {
		super();
		this.itemID = itemID;
		this.itemDescription = itemDescription;
		this.itemQuantity = itemQuantity;
		this.itemUnityPrice = itemUnityPrice;
		this.itemTotal = itemTotal;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemUnityPrice() {
		return itemUnityPrice;
	}

	public void setItemUnityPrice(double itemUnityPrice) {
		this.itemUnityPrice = itemUnityPrice;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
}
