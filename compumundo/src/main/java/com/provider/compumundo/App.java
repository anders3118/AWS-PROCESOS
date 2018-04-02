/**
 * 
 */
package com.provider.compumundo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import com.provider.compumundo.component.ProductInventorylist;
import com.provider.compumundo.model.Product;
import com.provider.compumundo.model.ProductList;

/**
 * @author Macaipe
 *
 */

@SpringBootApplication
public class App implements CommandLineRunner{
	
	public static List<Product> productCatalog;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Autowired
	public ProductInventorylist productList;
	
	@Override
	public void run(String... args) throws Exception {
		ResponseEntity<ProductList[]> response = productList.getProductInventorylist();
		productCatalog = response.getBody()[0].getProducts();
	}
}
