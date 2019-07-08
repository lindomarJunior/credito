package com.credito.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaginaController {
	
	@RequestMapping("/")
	public String irParaHome() {
		return "index";
	}
}
