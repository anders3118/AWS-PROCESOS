/**
 * 
 */
package com.provider.compumundo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Macaipe
 *
 */
public class ProductList {
	
	@JsonProperty ("idProvider")
	private int idProvider;
	@JsonProperty ("idCatalog")
	private int idCatalog;
	@JsonProperty ("products")
	private List<Product> products;

	
	public ProductList() {
		super();
	}

	public int getIdProvider() {
		return idProvider;
	}
	
	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}
	
	public int getIdCatalog() {
		return idCatalog;
	}
	
	public void setIdCatalog(int idCatalog) {
		this.idCatalog = idCatalog;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	@JsonCreator
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
