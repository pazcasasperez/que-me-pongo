package com.example.demo.service.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.ArticuloTransaccionDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.ArticuloTransaccion;

@Mapper(componentModel = "spring")
public interface ArticuloTransaccionMapper {
	ArticuloTransaccionMapper INSTANCE = Mappers.getMapper(ArticuloTransaccionMapper.class);
	@Named("toDTOAT")
	@Mapping(target ="articuloDTO", source = "articulo")
	@Mapping(target ="transaccionDTO", source = "transaccion")
	ArticuloTransaccionDTO toDTO(ArticuloTransaccion at); 
	// Mapeo inverso (opcional) 
	@Named("toEntityAT")
	@Mapping(target ="articulo", source = "articuloDTO")
	@Mapping(target ="transaccion", source = "transaccionDTO")
	ArticuloTransaccion toEntity(ArticuloTransaccionDTO atDTO);
	
	@IterableMapping(qualifiedByName = "toDTOAT")
	List<ArticuloTransaccionDTO> articulosTransaccionesToArticulosTransaccionesDTO(Set<ArticuloTransaccion> listaArticulosTransacciones);

	@IterableMapping(qualifiedByName = "toEntityAT")
	Set<ArticuloTransaccion> articulosTransaccionesDTOToArticulosTransacciones(List<ArticuloTransaccionDTO> listaArticulosTransaccionesDTO);
}
