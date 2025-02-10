package com.example.demo.service.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.PagoDTO;
import com.example.demo.model.dto.UsuarioDireccionDTO;
import com.example.demo.repository.entity.Pago;
import com.example.demo.repository.entity.UsuarioDireccion;

@Mapper(componentModel = "spring")
public interface UsuarioDireccionMapper {
	UsuarioDireccionMapper INSTACE = Mappers.getMapper(UsuarioDireccionMapper.class);
	
	@Named("toDTOUD")
	@Mapping(target ="usuario", source = "usuario")
	@Mapping(target ="direccion", source = "direccion")
	UsuarioDireccionDTO toDTO(UsuarioDireccion ud);
	
	@Named("toEntityUD")
	@Mapping(target ="usuario", source = "usuario")
	@Mapping(target ="direccion", source = "direccion")
	UsuarioDireccion toEntity(UsuarioDireccionDTO udDTO);
	
	@IterableMapping(qualifiedByName = "toDTOUD")
	List<UsuarioDireccionDTO> usuariosDireccionesToUsuariosDireccionesDTO(Set<UsuarioDireccion> listaUsuariosDirecciones);
	
	@IterableMapping(qualifiedByName = "toEntityUD")
	Set<UsuarioDireccion> usuariosDireccionesDTOToUsuariosDirecciones(List<UsuarioDireccionDTO> listaUsuariosDireccionesDTO);
}
