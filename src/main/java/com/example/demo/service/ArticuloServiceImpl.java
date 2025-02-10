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
		//listaArticulos.stream().map(articuloMapper::toDTO).collect(Collectors.toSet());
		return listaArticulos.stream().map(articuloMapper::toDTO).collect(Collectors.toList());
		//return listaArticulosDTO;
	}

	@Override
	public ArticuloDTO findById(ArticuloDTO articuloDTO) {
		log.info(ArticuloServiceImpl.class.getSimpleName() + " -- Solicitamos el articulo con id " + articuloDTO.getId() + " al servicio");

		Articulo a = articuloRepository.findById(articuloDTO.getId()).get();
		articuloDTO = ArticuloDTO.convertToDTO(a);
		
		return articuloDTO;
	}
	/**
	 *  Vamos a guardar el articulo, como hemos realizado hasta ahora, pero devolveremos
	 *  un articulo al controlador, para poder controlar el error
	 */
	@Override
	public ArticuloDTO save(ArticuloDTO articuloDTO) {
		log.info(ArticuloServiceImpl.class.getSimpleName() + " -- Guardamos en el servicio un nuevo articulo");
		log.info("ArticuloDTO " + articuloDTO.toString());
		Articulo articulo = ArticuloMapper.INSTANCE.toEntity(articuloDTO);
		Articulo art = articuloRepository.save(articulo);
		articuloDTO = ArticuloMapper.INSTANCE.toDTO(art);
		log.info("ArticuloDTO MYSQL" + articuloDTO.toString());
		return articuloDTO ;
	}

	@Override
	public void delete(ArticuloDTO articuloDTO) {
		log.info(ArticuloServiceImpl.class.getSimpleName() + " -- Desactivamos en el servicio el articulo: " + articuloDTO.getId());
		Articulo articulo = articuloRepository.findById(articuloDTO.getId()).get();
		articulo.setActivo(false);
		articuloRepository.save(articulo);
	}
}
