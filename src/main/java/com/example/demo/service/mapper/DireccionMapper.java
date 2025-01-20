package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Transaccion;

@Mapper(componentModel = "spring")
public interface DireccionMapper {
	DireccionMapper INSTACE = Mappers.getMapper(DireccionMapper.class);
	
	DireccionDTO toDTO(Direccion direccion);

	Direccion toEntity(DireccionDTO direccionDTO);
	
	Set<DireccionDTO> direccionesToDireccionesDTO(Set<Direccion> listaDirecciones);
	
	Set<Direccion> direccionesDTOToDirecciones(Set<DireccionDTO> listaDireccionesDTO);


}
