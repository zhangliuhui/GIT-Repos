package org.lucas.funny.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@ResponseBody
	@RequestMapping(value="/addUser")
	public String addUser(){
		return null;
	}
}
