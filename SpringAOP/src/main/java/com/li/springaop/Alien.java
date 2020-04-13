package com.li.springaop;

import org.springframework.stereotype.Component;

@Component
public class Alien {
	
	public void show() {
		//log -> 2 lines
		//security -> 1 line
		//transaction -> Beginn
		
		// 15 statements -> business logic
		
		//transaction -> commit
		
		System.out.println("Hello World");
		
		//log -> 2 lines
	}
	

}
