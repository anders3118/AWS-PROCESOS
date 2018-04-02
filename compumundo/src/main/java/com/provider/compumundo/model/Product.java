/**
 * 
 */
package com.provider.compumundo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Macaipe
 *
 */
public class Product {

	@JsonProperty("description")
	private String description;
	@JsonProperty("quantity")
	private int quantity;
	@JsonProperty("id")
	private int id;
	@JsonProperty("thumbnail_url")
	private String thumbnail_url;
	@JsonProperty("title")
	private String title;
	@JsonProperty("price")
	private int price;
	/**
	 * 
	 */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
