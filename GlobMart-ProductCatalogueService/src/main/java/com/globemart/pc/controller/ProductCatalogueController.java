package com.globemart.pc.controller;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globemart.pc.interfaces.ApplicationConstants;
import com.globemart.pc.model.Product;
import com.globemart.pc.service.IProductCatalogueService;

@RestController
public class ProductCatalogueController {

	@Autowired
	private IProductCatalogueService catalogueService;

	@Autowired
	private Environment env;

	@PostMapping("/catalogue/product/")
	ResponseEntity<String> addProduct(@RequestBody Product product) {
		boolean result = catalogueService.addNewProduct(product);
		return result == true
				? new ResponseEntity<String>(env.getProperty(ApplicationConstants.SUCCES_MESSAGE_SAVE_PROPERTY),
						HttpStatus.OK)
				: new ResponseEntity<String>(env.getProperty(ApplicationConstants.ERROR_MESSAGE_GENERAL_PROPERTIES),
						HttpStatus.BAD_REQUEST);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/catalogue/product/")
	ResponseEntity getAllProducts() {
		List<Product> result = catalogueService.getAll();
		if (result != null && result.size() == 0) {
			return new ResponseEntity(new Error(env.getProperty(ApplicationConstants.ERROR_MESSAGE_NO_RECORD_FOUND)),
					HttpStatus.NO_CONTENT);
		}
		return result != null ? new ResponseEntity<List<Product>>(result, HttpStatus.OK)
				: new ResponseEntity(new Error(env.getProperty(ApplicationConstants.ERROR_MESSAGE_GENERAL_PROPERTIES)),
						HttpStatus.BAD_REQUEST);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/catalogue/product/type/{type}")
	ResponseEntity getByTypeProduct(@PathVariable(value = "type") String productType) {
		List<Product> result = catalogueService.getProductByType(productType);
		return result != null ? new ResponseEntity<List<Product>>(result, HttpStatus.OK)
				: new ResponseEntity(new Error(env.getProperty(ApplicationConstants.ERROR_MESSAGE_GENERAL_PROPERTIES)),
						HttpStatus.BAD_REQUEST);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/catalogue/product/id/{id}")
	ResponseEntity getByIdProduct(@PathVariable(value = "id") Long productId) {
		Product result = catalogueService.getProductById(productId);
		return result != null ? new ResponseEntity<Product>(result, HttpStatus.OK)
				: new ResponseEntity(new Error(env.getProperty(ApplicationConstants.ERROR_MESSAGE_GENERAL_PROPERTIES)),
						HttpStatus.BAD_REQUEST);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/catalogue/product/name/{name}")
	ResponseEntity getByNameProduct(@PathVariable(value = "name") String productName) {
		List<Product> result = catalogueService.getProductByName(productName);
		return result != null ? new ResponseEntity<List<Product>>(result, HttpStatus.OK)
				: new ResponseEntity(new Error(env.getProperty(ApplicationConstants.ERROR_MESSAGE_GENERAL_PROPERTIES)),
						HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/catalogue/product/{id}")
	ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Long productId) {
		boolean result = catalogueService.deleteProduct(productId);
		return result == true
				? new ResponseEntity<String>(MessageFormat.format(
						(String) env.getProperty(ApplicationConstants.SUCCES_MESSAGE_DELETE_PROPERTY), productId),
						HttpStatus.OK)
				: new ResponseEntity<String>(env.getProperty(ApplicationConstants.ERROR_MESSAGE_GENERAL_PROPERTIES),
						HttpStatus.BAD_REQUEST);

	}
}
