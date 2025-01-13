package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.service.ArticuloService;


@Controller
public class ArticuloController {
	//Inyectamos el servicio en el controlador
	@Autowired
	private ArticuloService articuloService;
	private static final Logger log = LoggerFactory.getLogger(ArticuloController.class);
	
	@GetMapping("/")
	public ModelAndView findAll() {
		log.info(ArticuloController.class.getSimpleName() + "  -- Listando los articulos");
		
		ModelAndView mav = new ModelAndView("articulos");
		List<ArticuloDTO> listaArticulosDTO =articuloService.findAll();
		
		mav.addObject("listaArticulosDTO", listaArticulosDTO);
		return mav;
	}
}
