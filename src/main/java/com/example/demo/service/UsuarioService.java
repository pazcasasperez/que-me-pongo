package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.UsuarioDTO;

public interface UsuarioService {
	
	List<UsuarioDTO> findAll();

	UsuarioDTO findById(UsuarioDTO usuarioDTO);

	int login(UsuarioDTO usuarioDTO);

	UsuarioDTO findByNombreUsuario(UsuarioDTO usuarioDTO);

	void delete(UsuarioDTO usuarioDTO);

	UsuarioDTO save(UsuarioDTO usuarioDTO);

	//void save(UsuarioDTO usuarioDTO);
}
