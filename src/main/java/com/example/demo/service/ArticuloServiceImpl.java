package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.repository.dao.ArticuloRepository;
import com.example.demo.repository.entity.Articulo;

@Service
public class ArticuloServiceImpl implements ArticuloService {
	@Autowired
	private ArticuloRepository articuloRepository;
	private static final Logger log = LoggerFactory.getLogger(ArticuloServiceImpl.class);

	@Override
	public List<ArticuloDTO> findAll() {
		log.info(ArticuloServiceImpl.class.getSimpleName() + " -- Solicitamos la lista de articulos al servicio");
		
		List<Articulo> listaArticulos = articuloRepository.findAll();
		List<ArticuloDTO> listaArticulosDTO = new ArrayList<ArticuloDTO>();
		for(Articulo a : listaArticulos) {
			listaArticulosDTO.add(ArticuloDTO.convertToDTO(a));
		}
		
		return listaArticulosDTO;
	}

}
