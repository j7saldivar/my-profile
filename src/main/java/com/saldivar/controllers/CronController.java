package com.saldivar.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saldivar.dao.ProductRepository;

@Component
public class CronController {

	private static final Logger logger = LoggerFactory.getLogger(CronController.class);

	@Autowired
	private ProductRepository pr;

	//@Scheduled(fixedRate = 1000)
	//@Scheduled(cron="*/30 * * * * *")
	public void getHome() {
		pr.deleteAll();
		Date date = new Date();
		
		logger.info(date.toString());
	}

}
