package com.simian.medallion.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simian.medallion.mobile.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{
	
	@Query(value=""
			+ "select a "
			+ "from User a "
			+ "where a.username = :username")
    public User getUser(@Param("username") String username);
	
	@Modifying
	@Query(value=""
			+ "update User a "
			+ "set a.rememberme = :rememberme "
			+ "where a.username = :username")
	public void updateUser(@Param("username") String username, @Param("rememberme") boolean rememberme);
}
