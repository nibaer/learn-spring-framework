package com.li.service;


import org.springframework.stereotype.Controller;

@Controller
public class AddService {

	public int add(int i, int j) {
		return i+j;
	}
	
}
