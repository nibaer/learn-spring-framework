package com.li.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// replacement of li-servlet.xml
@EnableWebMvc
@ComponentScan("com.li")
public class MvcConfig extends WebMvcConfigurerAdapter{

}

