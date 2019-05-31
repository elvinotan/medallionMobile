package com.simian.medallion.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simian.medallion.mobile.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{
	
	@Query(value=""
			+ "select a "
			+ "from Product a where a.code like %:code% ")
    public List<Product> getProducts(@Param("code") String code);
	
	@Query(value=""
			+ "select a "
			+ "from Product a "
			+ "where a.id = :id")
    public Product getProduct(@Param("id") Long id);
}
