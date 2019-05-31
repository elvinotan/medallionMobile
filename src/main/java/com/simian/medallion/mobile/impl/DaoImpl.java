package com.simian.medallion.mobile.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.simian.medallion.mobile.repository.NavRepository;
import com.simian.medallion.mobile.repository.ProductRepository;
import com.simian.medallion.mobile.repository.UserRepository;

public class DaoImpl {
	
	@Autowired
	protected NavRepository navRepo;
	
	@Autowired
	protected UserRepository userRepo;
	
	@Autowired
	protected ProductRepository productRepo;
	
	@Autowired
    protected PasswordEncoder passwordEncoder;
}
