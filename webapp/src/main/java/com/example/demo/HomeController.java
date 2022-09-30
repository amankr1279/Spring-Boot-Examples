package com.example.demo;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
//	@RequestMapping("home")
//	public String home(HttpServletRequest req) {
//		String name = req.getParameter("name");
//		System.out.println("Holaaa..." + name);
//		
//		// let's pass that param to webpage
//		HttpSession session = req.getSession();
//		session.setAttribute("uname", name);
//		
//		return "home"; // causes download of this file as by default Spring boot doesn't 
//		// officially support jasper files. So we added tomcat-jasper in dependencies and now it works
//	}
	
	// Better way
	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name") String myName) {
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("uname", myName);
		
		mView.setViewName("home");
		
		return mView; 
	}

	@RequestMapping("alien")
	public ModelAndView alien(Alien alien) {
		ModelAndView mView = new ModelAndView();
		mView.addObject("obj", alien);
		
		mView.setViewName("alien");

		return mView;
	}
	/*
	 * ModelAndView is easy to use and debug method of passing data in a session.
	 * We don't even need to take care of the webpage. It is automatically
	 * taken care of. 
	 * We can send multiple objects in ModelAndView.
	 */
}
