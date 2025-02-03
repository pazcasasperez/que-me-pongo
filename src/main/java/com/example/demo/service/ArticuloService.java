package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ArticuloDTO;

public interface ArticuloService {

	List<ArticuloDTO> findAll();

	int save(ArticuloDTO articuloDTO);

	ArticuloDTO findById(ArticuloDTO articuloDTO);

	ArticuloDTO delete(ArticuloDTO articuloDTO);

}
