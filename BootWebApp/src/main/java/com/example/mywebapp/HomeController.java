package com.example.mywebapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String name= request.getParameter("name");
		System.out.println("Hi " + name);
		session.setAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("home2")
	public String home2(String name, HttpSession session) {
		System.out.println("Hi " + name);
		session.setAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("home3")
	public String home3(@RequestParam("name") String myName, HttpSession session) {
		System.out.println("Hi " + myName);
		session.setAttribute("name", myName);
		return "home";
	}
	
	@RequestMapping("home4")
	public ModelAndView home4(@RequestParam("name") String myName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("home");
		System.out.println("Hi " + myName);
		return mv;
	}
	
	@RequestMapping("home5")
	public ModelAndView home5(Alien alien) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home_alien");
		return mv;
	}


}
