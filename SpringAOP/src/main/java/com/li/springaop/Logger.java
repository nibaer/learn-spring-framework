package com.li.springaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Logger {
	
	@Before("execution(public void show()) ")
	public void log() {
		System.out.println("show called");
	}

}
