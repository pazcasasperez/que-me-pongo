package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	UsuarioMapper INSTACE = Mappers.getMapper(UsuarioMapper.class);

	@Named("toDTOU")
	@Mapping(target ="listaArticulos", source = "listaArticulos",qualifiedByName = "toDTOA", ignore=true) 
	@Mapping(target = "listaUsuarioDireccion", source ="listaUsuarioDireccion", qualifiedByName = "toDTOUD", ignore=true) 
	@Mapping(target ="listaVentas", source = "listaVentas", qualifiedByName = "toDTOV", ignore=true)
	@Mapping(target ="listaCompras", source = "listaCompras", qualifiedByName = "toDTOC", ignore=true)
    public UsuarioDTO toDTO(Usuario usuario);

	@Named("toEntityU")
	@Mapping(target ="listaArticulos", source = "listaArticulos",qualifiedByName = "toDTOA", ignore=true) 
	@Mapping(target = "listaUsuarioDireccion", source ="listaUsuarioDireccion", qualifiedByName = "toDTOUD", ignore=true) 
	@Mapping(target ="listaVentas", source = "listaVentas", qualifiedByName = "toDTOV", ignore=true)
	@Mapping(target ="listaCompras", source = "listaCompras", qualifiedByName = "toDTOC", ignore=true)
    Usuario toEntity(UsuarioDTO usuarioDTO);
	
	@IterableMapping(qualifiedByName = "toDTOU") 
	Set<UsuarioDTO> usuariosToUsuariosDTO(Set<Usuario> listaUsuarios);
	
	@IterableMapping(qualifiedByName = "toEntityU") 
	Set<Usuario> usuariosDTOToUsuarios(Set<UsuarioDTO> listaUsuariosDTO);

}
