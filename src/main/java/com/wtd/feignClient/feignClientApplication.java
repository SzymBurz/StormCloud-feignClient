package com.wtd.feignClient;

import com.wtd.feignClient.controller.GreetingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableFeignClients
@SpringBootApplication
public class feignClientApplication {

	@Autowired
	private GreetingClient greetingClient;


	public static void main(String[] args) {
		SpringApplication.run(feignClientApplication.class, args);
	}

	@RequestMapping("/get-greeting")
	public String greeting(Model model) {
		model.addAttribute("greeting", greetingClient.greeting());
		return "greeting-view";
	}

	@RequestMapping(value = "/whoami/{username}")
	public String whoami(Model model, @PathVariable("username") String username) {
		model.addAttribute("whoami", greetingClient.whoami(username));
		return "whoami-view";
	}
}
