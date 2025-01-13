package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;

@Controller
public class UsuarioController {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);		

	// Inyectamos el servicio en el controlador
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ModelAndView findAll() {
		log.info(UsuarioController.class.getSimpleName()+" - listamos todos los usuarios");
		
		ModelAndView mv = new ModelAndView("usuarios");
		List<UsuarioDTO> listaUsuarioDTO = usuarioService.findAll();
		
		mv.addObject("listaUsuarioDTO", listaUsuarioDTO);
		return mv;
	}
}