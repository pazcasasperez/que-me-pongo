package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.repository.dao.ArticuloRepository;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.service.mapper.ArticuloMapper;

@Service
public class ArticuloServiceImpl implements ArticuloService {
	@Autowired
	private ArticuloRepository articuloRepository;
	private static final Logger log = LoggerFactory.getLogger(ArticuloServiceImpl.class);
	@Autowired
	private final ArticuloMapper articuloMapper=null;

	@Override
	public List<ArticuloDTO> findAll() {
		log.info(ArticuloServiceImpl.class.getSimpleName() + " -- Solicitamos la lista de articulos al servicio");
		
		List<Articulo> listaArticulos = articuloRepository.findAll();/*
		List<ArticuloDTO> listaArticulosDTO = new ArrayList<ArticuloDTO>();
		for(Articulo a : listaArticulos) {
			ArticuloDTO art =articuloMapper.toDTO(a);
			//ArticuloDTO art = ArticuloMapper.INSTANCE.toDTO(a);
			listaArticulosDTO.add(art);
			//listaArticulosDTO.add(ArticuloDTO.convertToDTO(a));
		}*/
		return listaArticulos.stream().map(articuloMapper::toDTO).collect(Collectors.toList());
		//return listaArticulosDTO;
	}

	@Override
	public ArticuloDTO findById(Long idArticulo) {
		log.info(ArticuloServiceImpl.class.getSimpleName() + " -- Solicitamos el articulo con id " + idArticulo + " al servicio");
		
		Articulo a = articuloRepository.findById(idArticulo).get();
		ArticuloDTO articuloDTO = ArticuloDTO.convertToDTO(a);
		
		return articuloDTO;
	}

}
