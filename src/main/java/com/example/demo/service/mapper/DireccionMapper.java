package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.DireccionDTO;
import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Transaccion;

@Mapper(componentModel = "spring")
public interface DireccionMapper {
	DireccionMapper INSTACE = Mappers.getMapper(DireccionMapper.class);
	
	@Named("toDTOD")
	@Mapping(target ="listaUsuarioDireccion", source = "listaUsuarioDireccion",qualifiedByName = "toDTOUD", ignore=true) 
	@Mapping(target = "listaTransaccionesEnvios", source ="listaTransaccionesEnvios", qualifiedByName = "toDTOT", ignore=true) 
	@Mapping(target ="listaTransaccionesVendedores", source = "listaTransaccionesVendedores", qualifiedByName = "toDTOT", ignore=true)
	DireccionDTO toDTO(Direccion direccion);
	
	@Named("toEntityD")
	@Mapping(target ="listaUsuarioDireccion", source = "listaUsuarioDireccion",qualifiedByName = "toDTOUD", ignore=true) 
	@Mapping(target = "listaTransaccionesEnvios", source ="listaTransaccionesEnvios", qualifiedByName = "toDTOT", ignore=true) 
	@Mapping(target ="listaTransaccionesVendedores", source = "listaTransaccionesVendedores", qualifiedByName = "toDTOT", ignore=true)
	Direccion toEntity(DireccionDTO direccionDTO);
	
	@IterableMapping(qualifiedByName = "toDTOD") 
	Set<DireccionDTO> direccionesToDireccionesDTO(Set<Direccion> listaDirecciones);
	
	@IterableMapping(qualifiedByName = "toEntityD") 
	Set<Direccion> direccionesDTOToDirecciones(Set<DireccionDTO> listaDireccionesDTO);


}
