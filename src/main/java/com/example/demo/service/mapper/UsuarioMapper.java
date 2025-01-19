package com.example.demo.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	UsuarioMapper INSTACE = Mappers.getMapper(UsuarioMapper.class);
	/*
	
	ArticuloDTO toDTO (Articulo articulo);*/
	
	// Mapeo principal de Articulo a ArticuloDTO
	
    UsuarioDTO toDTO(Usuario usuario);

    // Mapeo inverso (opcional)
    Usuario toEntity(UsuarioDTO usuarioDTO);

}
