/**
 * 
 */
package com.globemart.pc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globemart.pc.model.Product;
import com.globemart.pc.service.IProductCatalogueService;

/**
 * @author kartik.raina
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTest {

	@Autowired
	private IProductCatalogueService productCatalogueService;

	private Product product;

	private String productName = "Sony Bravia LED";
	private String productType = "Electronics";
	private String productDescription = "The best LED in the world!!!";
	private Float productPrice = 9999.99F;
	private Long productId = 1L;

	@Before
	public void setupMock() {
		product = new Product();
		product.setName(productName);
		product.setType(productType);
		product.setDescription(productDescription);
		product.setPrice(productPrice);
	}

	@Test
	public void test1_AddServcie() {
		System.out.println("Testing insersion of product: " + productDescription.toString());
		assertTrue(productCatalogueService.addNewProduct(product));
	}

	@Test
	public void test2_GetProductByName() {
		System.out.println("Testing search of product by name: " + productName);
		List<Product> searchResult = productCatalogueService.getProductByName(productName);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
	}

	@Test
	public void test3_GetProductByType() {
		System.out.println("Testing search of product by type: " + productType);
		List<Product> searchResult = productCatalogueService.getProductByType(productType);
		assertNotNull(searchResult);
		assertTrue(searchResult.size() > 0);
	}

	@Test
	public void test4_GetProductById() {
		System.out.println("Testing search of product by id: " + productId);
		Product searchResult = productCatalogueService.getProductById(productId);
		assertNotNull(searchResult);
		System.out.println("product found by id: " + searchResult.toString());
	}

	@Test
	public void test5_DeleteServcie() {
		System.out.println("Testing deletion of product id: " + productId);
		assertTrue(productCatalogueService.deleteProduct(productId));
	}

}
