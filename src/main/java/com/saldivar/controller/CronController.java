package com.saldivar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.saldivar.dao.ProductRepository;
import com.saldivar.dao.UserRepository;
import com.saldivar.utility.ProjectUtilities;

@Component
public class CronController {

	private static final Logger logger = LoggerFactory.getLogger(CronController.class);

	@Autowired
	private ProductRepository pr;
	
	@Autowired
	private UserRepository ur;

	@Scheduled(cron="0 0 0 * * *")
	public void cleanup() {
		
		pr.deleteAll();
		ur.deleteAll();
		logger.info("Database cleaned at " + ProjectUtilities.dateTimeNow());
	}

}
