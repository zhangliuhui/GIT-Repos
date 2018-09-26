package org.lucas.funny.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String index() {
		return "login";
	}
	@RequestMapping("/toLogin")
	public String login() {
		return "index";
	}
}
