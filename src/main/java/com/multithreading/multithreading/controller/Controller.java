package com.multithreading.multithreading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multithreading.multithreading.dao.incrementDAOInterface;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private incrementDAOInterface incrementDAO;

	//@Async
	@PostMapping("/increment")
	public String increment() {
		return incrementDAO.increment();
	}
	
	//@Async
	@GetMapping("/increment")
	public int check() {
		return incrementDAO.check();
	}
}
