package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	// Inyectamos el servicio en el controlador
	@Autowired
	private UsuarioService usuarioService;

	//@GetMapping("/usuarios")
	@GetMapping
	public List<UsuarioDTO> findAll() {
		log.info(UsuarioController.class.getSimpleName() + " - listamos todos los usuarios");

		//ModelAndView mv = new ModelAndView("usuarios");
		List<UsuarioDTO> listaUsuarioDTO = usuarioService.findAll();

		//mv.addObject("listaUsuarioDTO", listaUsuarioDTO);
		//return mv;
		return listaUsuarioDTO;
	}

	@GetMapping("/usuarios/add")
	public ModelAndView add() {

		log.info(UsuarioController.class.getSimpleName() + " - creamos un nuevo usuario");
		/*
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(idUsuario);
		usuarioDTO = usuarioService.findById(usuarioDTO);*/

		ModelAndView mv = new ModelAndView("usuariosForm");
		mv.addObject("usuarioDTO", new UsuarioDTO());
		mv.addObject("add", true);

		return mv;
	}
	/*
	@GetMapping("/usuarios/save")
	public ModelAndView save(@PathVariable Long idUsuario) {

		log.info(UsuarioController.class.getSimpleName() + " - guardamos el nuevo usuario");

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(idUsuario);

		usuarioService.save(usuarioDTO);
		ModelAndView mv = new ModelAndView("redirect:/usuarios");

		return mv;
	}*/
}