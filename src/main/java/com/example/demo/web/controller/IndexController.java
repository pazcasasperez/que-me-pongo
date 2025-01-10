package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;
	
	@Value("${asignatura}")
	private String nombreAsignatura;
	
	@GetMapping("/")
    public ModelAndView index() {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("titulo", nombreAplicacion);
		mv.addObject("nombreAsignatura", nombreAsignatura);
		
		return mv;
	}
}
