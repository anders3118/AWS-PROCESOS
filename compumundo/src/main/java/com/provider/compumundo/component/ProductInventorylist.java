/**
 * 
 */
package com.provider.compumundo.component;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestOperations;

import com.provider.compumundo.model.ProductList;

/**
 * @author Macaipe
 *
 */
@Component
public class ProductInventorylist {

	/**
	 * 
	 */
	@Autowired
	private RestOperations restOperations;
	private final String url;
	private final String apiKey;
	private final String apiKeyValue;
	private HttpHeaders headers = new HttpHeaders();

	@Autowired
	public ProductInventorylist(@Value("${productInventoryList.service.url}") final String url,
			@Value("${productInventoryList.service.APIKey}") final String apiKey,
			@Value("${productInventoryList.service.APIKeyValue}") final String apiKeyValue) {
		this.url = url;
		this.apiKey = apiKey;
		this.apiKeyValue = apiKeyValue;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ProductList[]> getProductInventorylist() {
		headers.set(apiKey, apiKeyValue);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<ProductList[]> response = restOperations.exchange(url, HttpMethod.GET, entity,
				ProductList[].class);
		return response;

	}

}
