package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Transaccion;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {
	TransaccionMapper INSTACE = Mappers.getMapper(TransaccionMapper.class);
	
	@Named("toDTOT")
	@Mapping(target ="articulosTransacciones", source = "articulosTransacciones",qualifiedByName = "toDTOAT", ignore=true) 
	@Mapping(target = "listaVentas", source ="listaVentas", qualifiedByName = "toDTOV", ignore=true) 
	@Mapping(target ="listaCompras", source = "listaCompras",qualifiedByName = "toDTOC", ignore=true) 
	TransaccionDTO toDTO(Transaccion transaccion);
	
	@Named("toEntityT")
	@Mapping(target ="articulosTransacciones", source = "articulosTransacciones",qualifiedByName = "toDTOAT", ignore=true) 
	@Mapping(target = "listaVentas", source ="listaVentas", qualifiedByName = "toDTOV", ignore=true) 
	@Mapping(target ="listaCompras", source = "listaCompras",qualifiedByName = "toDTOC", ignore=true) 
	Transaccion toEntity(TransaccionDTO articuloDTO);
	
	@IterableMapping(qualifiedByName = "toDTOT") 
	Set<TransaccionDTO> transaccionesToTransaccionesDTO(Set<Transaccion> listaTransacciones);
	
	@IterableMapping(qualifiedByName = "toEntityT") 
	Set<Transaccion> transaccionesDTOToTransacciones(Set<TransaccionDTO> listaTransaccionesDTO);

}
