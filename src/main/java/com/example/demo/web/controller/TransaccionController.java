package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.ArticuloTransaccionDTO;
import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.repository.entity.ArticuloTransaccion;
import com.example.demo.service.ArticuloService;
import com.example.demo.service.TransaccionService;


@Controller
public class TransaccionController {
	@Autowired
	private TransaccionService transaccionService;
	@Autowired
	private ArticuloService articuloService;
	private static final Logger log = LoggerFactory.getLogger(ArticuloController.class);

	@GetMapping("/transacciones")
	public ModelAndView findAll() {
		log.info(TransaccionController.class.getSimpleName() + "  -- Listando todas las transacciones");

		ModelAndView mav = new ModelAndView("transacciones");
		List<TransaccionDTO> listaTransaccionesDTO = transaccionService.findAll();

		mav.addObject("listaTransaccionesDTO", listaTransaccionesDTO);
		return mav;
	}

	@GetMapping("/articulos/{idArticulo}/transacciones")
	public ModelAndView findByArticulo(@PathVariable("idArticulo") Long idArticulo) {
		log.info(TransaccionController.class.getSimpleName() + "  -- Listando todas las transacciones");

		ArticuloDTO articuloDTO = new ArticuloDTO();
		articuloDTO.setId(idArticulo);
		articuloDTO = articuloService.findById(idArticulo);

		log.info("articulo " + articuloDTO.toString());
		

		List<ArticuloTransaccionDTO> listaArticuloTransaccionDTO = transaccionService.findByArticulo(articuloDTO);

		ModelAndView mav = new ModelAndView("articulotransaccion");

		mav.addObject("listaArticuloTransaccionDTO", listaArticuloTransaccionDTO);
		return mav;
	}

	
}
