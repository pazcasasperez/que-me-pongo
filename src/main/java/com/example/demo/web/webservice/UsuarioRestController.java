package com.example.demo.web.webservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;
import com.example.demo.web.controller.UsuarioController;

@RestController
@RequestMapping("/api/usuarios") //Aqui es donde va a empezar a escuchar el mapping
public class UsuarioRestController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioRestController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioDTO> findAll() {
		log.info(UsuarioRestController.class.getSimpleName() + " - listamos todos los usuarios");

		ModelAndView mv = new ModelAndView("usuarios");
		List<UsuarioDTO> listaUsuarioDTO = usuarioService.findAll();

		return listaUsuarioDTO;
	}
	
}
