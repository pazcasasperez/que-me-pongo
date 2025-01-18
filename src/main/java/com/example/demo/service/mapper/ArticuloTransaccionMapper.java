package com.example.demo.service.mapper;

import java.util.Set;

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
	ArticuloTransaccionMapper INSTACE = Mappers.getMapper(ArticuloTransaccionMapper.class);
	
	

    ArticuloTransaccionDTO toDTO(ArticuloTransaccion at);

    // Mapeo inverso (opcional)
    ArticuloTransaccion toEntity(ArticuloTransaccionDTO atDTO);
	
    @Named("articulosTransaccionesToArticulosTransaccionesDTO")
    @Mapping(target = "articuloDTO", source = "articulo", ignore = true)
    @Mapping(target = "transaccionDTO",source = "transaccion", ignore = true)
	Set<ArticuloTransaccionDTO> articulosTransaccionesToArticulosTransaccionesDTO(Set<ArticuloTransaccion> listaArticulosTransacciones);
	
	Set<ArticuloTransaccion> articulosTransaccionesDTOToArticulosTransacciones(Set<ArticuloTransaccionDTO> listaArticulosTransaccionesDTO);

}
