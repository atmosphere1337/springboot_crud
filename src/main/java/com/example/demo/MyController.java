package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;






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

	private UserRepository userRepo;
	private CityRepository cityRepo;
	@GetMapping("/login")
	public String loginGet() {
		return "login";
	}

	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}


	/*
	@PostMapping("/login/process")
	public RedirectView loginPost ( @RequestParam("login") String login,
								    @RequestParam("password") String password,
								    HttpSession session ) {
		if (!validateUserInput(login, password)) {
			return new RedirectView("/login");
		}
		List<User> users = userRepo.findByLoginAndPassword(login, password);
		if (users.size() == 0) {
			return new RedirectView("/login");
		}
		session.setAttribute("id", users.get(0));
		return new RedirectView("/page");
	}
	*/
	@PostMapping("/login/process")
	public String test() {
		return "page";
	}

	@PostMapping("/register/process")
	public RedirectView registerPost(@RequestParam("login") String login, @RequestParam("password") String password)  {
		User newUser = new User();
		if (!validateUserInput(login, password))
			return new RedirectView("/login");
		newUser.setLogin(login);
		newUser.setPassword(password);
		if (!validateUserExists(newUser))
			return new RedirectView("/login");
		userRepo.save(newUser);
		return new RedirectView("/register");

	}
	
	@GetMapping("/page")
	public String pageGet(Model model) {
		Iterable<City> allCities = cityRepo.findAll();
		model.addAttribute("context", allCities);
		return "page";
	}
	
	@PostMapping("/page/add")
	public RedirectView pageAddPost(
		@RequestParam("city") String city,
		@RequestParam("country") String country,
		@RequestParam("population") Integer population
	) {
		if (!validateCityInput(city, country, population))
			return new RedirectView("/page");
		City newCity = new City();
		newCity.setCity(city);
		newCity.setCountry(country);
		newCity.setPopulation(population);
		cityRepo.save(newCity);
		return new RedirectView("/page");
		
	}
	

	@PostMapping("/page/update")
	public RedirectView pageUpdatePost(
		@RequestParam("id") Integer id,
		@RequestParam("city") String city,
		@RequestParam("country") String country,
		@RequestParam("population") Integer population
	) {
		Optional<City> cityToEdit = cityRepo.findById(id);
		if (cityToEdit.isPresent()) {
			cityToEdit.get().setCity(city);
			cityToEdit.get().setCountry(country);
			cityToEdit.get().setPopulation(population);
			cityRepo.save( cityToEdit.get() );
		}
		return new RedirectView("/page");
	}

	@PostMapping("/page/delete")
	public RedirectView pageDeletePost(
		@RequestParam("id") Integer id
	) {
		cityRepo.deleteById(id);
		return new RedirectView("/page");
		
	}

	private boolean validateUserInput(String login, String password) {
		return true;
	}
	private boolean validateUserExists(User user) {
		return true;
	}
	private boolean validateCityInput(String city, String country, Integer population) { 
		return true;
	}
	/*
	private boolean validateCityExsist(City city) {
		return true;
	}
	*/
}
