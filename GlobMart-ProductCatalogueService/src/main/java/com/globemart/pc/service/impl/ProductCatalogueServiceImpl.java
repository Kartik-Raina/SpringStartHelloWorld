/**
 * 
 */
package com.globemart.pc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globemart.pc.model.Product;
import com.globemart.pc.repository.ProductCatalogueRepository;
import com.globemart.pc.service.IProductCatalogueService;

/**
 * @author Kartik Raina
 *
 */
@Service
public class ProductCatalogueServiceImpl implements IProductCatalogueService {

	@Autowired
	ProductCatalogueRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(ProductCatalogueServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.globemart.pc.service.IProductCatalogueService#addNewProduct(com.
	 * globemart.pc.model.Product)
	 */
	@Override
	public boolean addNewProduct(Product product) {
		try {
			repository.save(product);
			return true;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.globemart.pc.service.IProductCatalogueService#getAll()
	 */
	@Override
	public List<Product> getAll() {
		try {
			logger.debug("get all Products");
			return repository.findAll();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.globemart.pc.service.IProductCatalogueService#getProductByType(java.
	 * lang.String)
	 */
	@Override
	public List<Product> getProductByType(String productType) {
		try {
			logger.debug("get Product by type " + productType);
			return repository.findByType(productType);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.globemart.pc.service.IProductCatalogueService#getProductByName(java.
	 * lang.String)
	 */
	@Override
	public List<Product> getProductByName(String productName) {
		try {
			logger.debug("get Product by name " + productName);
			return repository.findByName(productName);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.globemart.pc.service.IProductCatalogueService#getProductById(java.
	 * lang.String)
	 */
	@Override
	public Product getProductById(Long productId) {
		try {
			logger.debug("get Product by id " + productId);
			return repository.findById(productId);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.globemart.pc.service.IProductCatalogueService#deleteProduct()
	 */
	@Override
	public boolean deleteProduct(Long productId) {
		try {
			logger.info("Delete product id " + productId);
			repository.delete(productId);
			return true;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}

		return false;
	}

}
