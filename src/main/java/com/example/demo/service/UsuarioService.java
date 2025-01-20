package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.UsuarioDTO;

public interface UsuarioService {
	List<UsuarioDTO> findAll();

	UsuarioDTO findById(UsuarioDTO usuarioDTO);

	//void save(UsuarioDTO usuarioDTO);
}
