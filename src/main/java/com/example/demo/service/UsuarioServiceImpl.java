package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repository.dao.UsuarioRepository;
import com.example.demo.repository.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);		
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<UsuarioDTO> findAll() {
		
		log.info(UsuarioServiceImpl.class.getName()+ " - Listamos todos los usuarios");
		
		List<UsuarioDTO> listarUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> listarUsuario = usuarioRepository.findAll();
		for(Usuario a : listarUsuario) {
			listarUsuarioDTO.add(UsuarioDTO.convertToDTO(a));
		}
		
		return listarUsuarioDTO;
	}

	@Override
	public UsuarioDTO findById(UsuarioDTO usuarioDTO) {

		log.info(UsuarioServiceImpl.class.getName()+ " - Buscamos el cliente por el id");

		Optional<Usuario> usuario = usuarioRepository.findById(usuarioDTO.getId());
		if (usuario.isPresent()) {
			usuarioDTO = UsuarioDTO.convertToDTO(usuario.get());
			return usuarioDTO;
		}		
		return null;
	}
	/*
	@Override
	public void save(UsuarioDTO usuarioDTO) {
		
		log.info(UsuarioServiceImpl.class.getName()+ " - Guardamos el usuario");
		
		Usuario usuario = UsuarioDTO.convertToEntity(usuarioDTO);
		usuarioRepository.save(usuario);
	}*/
}
