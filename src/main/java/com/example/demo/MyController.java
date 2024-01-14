package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;






@Controller
public class MyController {
	/*
	@GetMapping("/")
	public String index_get() {
		return "Grettings from Spring boot";
	}

	@GetMapping("/redirect") 
	public RedirectView redirect() {
		return new RedirectView("/page");
	}

	@GetMapping("/setcookie")
	public String setcookie(HttpServletResponse response) {
		
		Cookie cookie1 = new Cookie("login", "true"); 
		Cookie cookie2 = new Cookie("password", "true"); 
		cookie1.setMaxAge(10);
		cookie2.setMaxAge(10);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		return "set cookie";
	}

	@GetMapping("/getcookie")
	public String getcookie(
			@CookieValue(value="login", defaultValue="x") String login,
			@CookieValue(value="password", defaultValue="x") String password
			) {
		String ans = String.format("login: %s \n password: %s", login, password); 
		return ans;
	}

	@GetMapping("/setsession")
	public String setSession(HttpSession session) {
		session.setAttribute("variable", "goodjob");
		Object sess = session.getAttribute("variable");
		return String.format("session is set: %s", sess);
	}

	@GetMapping("/page")
	public String page_get() {
		return "page";
	}
	*/
	@GetMapping("/page")
	public String pageGet() {
		return "page";
	}
}
