package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.service.DireccionService;

@Controller
public class DireccionController {
	
	private static final Logger log = LoggerFactory.getLogger(DireccionController.class);
	
	@Autowired
	private DireccionService direccionService;
	
	@GetMapping("/direcciones")
	public ModelAndView findAll() {
		
		log.info(DireccionController.class.getSimpleName() + " - listamos las direcciones");
		
		ModelAndView mv = new ModelAndView("direccion");
		List<DireccionDTO> listaDireccionDTO = direccionService.findAll();
		
		mv.addObject("listaDireccionDTO", listaDireccionDTO);
		return mv;
		
	}
}
