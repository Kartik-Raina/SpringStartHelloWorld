/**
 * 
 */
package com.globemart.pc.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.globemart.pc.model.Product;

/**
 * @author Kartik Raina
 *
 */
@Repository
public interface ProductCatalogueRepository extends JpaRepository<Product, Long> {

	@Query(value = "select p from Product p where p.type = :type")
	List<Product> findByType(@Param("type") String type);

	@Query(value = "select p from Product p where p.name like %:name%")
	List<Product> findByName(@Param("name") String name);

	@Query(value = "select p from Product p where p.id = :id")
	Product findById(@Param("id") Long id);

}
