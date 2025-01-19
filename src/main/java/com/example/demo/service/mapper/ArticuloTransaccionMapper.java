package com.example.demo.service.mapper;

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
	@Named("toDTOT")
	ArticuloTransaccionDTO toDTO(ArticuloTransaccion at); 
	// Mapeo inverso (opcional) 
	@Named("toEntityT")
	ArticuloTransaccion oEntity(ArticuloTransaccionDTO atDTO);
	
	@IterableMapping(qualifiedByName = "toDTOT")
	Set<ArticuloTransaccionDTO> articulosTransaccionesToArticulosTransaccionesDTO(Set<ArticuloTransaccion> listaArticulosTransacciones);

	@IterableMapping(qualifiedByName = "toEntityT")
	Set<ArticuloTransaccion> articulosTransaccionesDTOToArticulosTransacciones(Set<ArticuloTransaccionDTO> listaArticulosTransaccionesDTO);
}
