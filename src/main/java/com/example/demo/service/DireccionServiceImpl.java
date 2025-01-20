package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.repository.dao.DireccionRepository;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.service.mapper.DireccionMapper;
import com.example.demo.web.controller.DireccionController;

@Service
public class DireccionServiceImpl implements DireccionService{

	private static final Logger log = LoggerFactory.getLogger(DireccionController.class);

	@Autowired
	private DireccionRepository direccionRepository;
	
	@Override
	public List<DireccionDTO> findAll() {

		log.info(ArticuloServiceImpl.class.getSimpleName() + " -- Buscamos la lista de direcciones en el servicio");

		List<Direccion> listaDireccion = direccionRepository.findAll();
		List<DireccionDTO> listaDireccionDTO = new ArrayList<>();
		for(Direccion d : listaDireccion) {
			listaDireccionDTO.add(DireccionMapper.INSTACE.toDTO(d));
			//listaDireccionDTO.add(DireccionDTO.convertToDTO(d));
		}
		
		return listaDireccionDTO;
	}
}
