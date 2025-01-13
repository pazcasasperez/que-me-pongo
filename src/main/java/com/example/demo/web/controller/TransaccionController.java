package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.service.TransaccionService;

@Controller
public class TransaccionController {
	@Autowired
	private TransaccionService transaccionService;
	private static final Logger log = LoggerFactory.getLogger(ArticuloController.class);

	@GetMapping("/transacciones")
	public ModelAndView findAll() {
		log.info(TransaccionController.class.getSimpleName() + "  -- Listando todas las transacciones");

		ModelAndView mav = new ModelAndView("transacciones");
		List<TransaccionDTO> listaTransaccionesDTO = transaccionService.findAll();

		mav.addObject("listaTransaccionesDTO", listaTransaccionesDTO);
		return mav;
	}
}
