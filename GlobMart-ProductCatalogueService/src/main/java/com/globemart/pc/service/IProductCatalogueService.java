/**
 * 
 */
package com.globemart.pc.service;

import java.util.List;

import com.globemart.pc.model.Product;
import com.globemart.pc.service.impl.ProductCatalogueServiceImpl;

/**
 * Service interface Also see {@link ProductCatalogueServiceImpl}
 * 
 * @author Kartik Raina
 *
 */
public interface IProductCatalogueService {

	/**
	 * This method adds a {@link Product} to the DB
	 * 
	 * @return boolean is the record is saved or not
	 */
	boolean addNewProduct(Product product);

	/**
	 * This method fetches all the records from DB
	 * 
	 * @return {@link List} of {@link Product}
	 */
	List<Product> getAll();

	/**
	 * This method fetches all the records from DB on the basis of type of
	 * product
	 * 
	 * @param productType
	 *            {@link String}
	 * @return @return {@link List} of {@link Product}
	 */
	List<Product> getProductByType(String productType);

	/**
	 * This method fetches all the records from DB on the basis of name if
	 * product
	 * 
	 * @param productName
	 *            {@link String}
	 * @return @return {@link List} of {@link Product}
	 */
	List<Product> getProductByName(String productName);

	/**
	 * This method fetches the record from DB on the basis of id of product
	 * 
	 * @param productId
	 *            {@link Long}
	 * @return
	 */
	Product getProductById(Long productId);

	/**
	 * This method deletes the record from DB that with respect to the product
	 * id
	 * 
	 * @return a boolean that shows if the recorder or not.
	 */
	boolean deleteProduct(Long id);
}
