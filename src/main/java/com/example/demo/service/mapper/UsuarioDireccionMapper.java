package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.PagoDTO;
import com.example.demo.model.dto.UsuarioDireccionDTO;
import com.example.demo.repository.entity.Pago;
import com.example.demo.repository.entity.UsuarioDireccion;

@Mapper(componentModel = "spring")
public interface UsuarioDireccionMapper {
	UsuarioDireccionMapper INSTACE = Mappers.getMapper(UsuarioDireccionMapper.class);

	UsuarioDireccionDTO toDTO(UsuarioDireccion ud);

	UsuarioDireccion toEntity(UsuarioDireccionDTO udDTO);
	
	Set<UsuarioDireccionDTO> usuariosDireccionesToUsuariosDireccionesDTO(Set<UsuarioDireccion> listaUsuariosDirecciones);

	Set<UsuarioDireccion> usuariosDireccionesDTOToUsuariosDirecciones(Set<UsuarioDireccionDTO> listaUsuariosDireccionesDTO);
}
