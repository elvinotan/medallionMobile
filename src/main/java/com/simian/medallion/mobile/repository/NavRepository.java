package com.simian.medallion.mobile.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simian.medallion.mobile.model.Nav;

@Repository
public interface NavRepository  extends JpaRepository<Nav, Long>, JpaSpecificationExecutor<Nav>{
	
	@Query(value=""
			+ "select a "
			+ "from Nav a "
			+ "where a.product.id = :id and a.date >= :fromDate and a.date <= :toDate order by a.date desc ")
    public List<Nav> getNavs(@Param("id") Long id, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query(value=""
			+ "select a "
			+ "from Nav a "
			+ "	left join fetch a.product "
			+ "where a.date >= :fromDate and a.date <= :toDate and a.product.id in (:ids) "
			+ "order by a.product.code, a.date desc")
	public List<Nav> getChartNav(@Param("ids") List<Long> ids, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
