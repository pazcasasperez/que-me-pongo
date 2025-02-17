package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.repository.entity.Articulo;

public interface ArticuloService {

	List<ArticuloDTO> findAll();

	ArticuloDTO save(ArticuloDTO articuloDTO);

	ArticuloDTO findById(ArticuloDTO articuloDTO);


	void delete(ArticuloDTO articuloDTO);


    List<ArticuloDTO> findByTipo(String tipo);

}
