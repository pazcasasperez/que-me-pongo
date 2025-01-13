package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.PagoDTO;
import com.example.demo.service.PagoService;

@Controller
public class PagoController {
	
	@Autowired
	private PagoService pagoService;
	private static final Logger log = LoggerFactory.getLogger(PagoController.class);
	
	@GetMapping("/pagos")
	public ModelAndView findAll() {
		log.info(PagoController.class.getSimpleName() + "  -- Listando los pago");
		
		ModelAndView mav = new ModelAndView("pagos");
		List<PagoDTO> listaPagosDTO = pagoService.findAll();
		
		log.info("datos pago   " +listaPagosDTO.toString());

		
		mav.addObject("listaPagosDTO", listaPagosDTO);
		return mav;
	}

}
