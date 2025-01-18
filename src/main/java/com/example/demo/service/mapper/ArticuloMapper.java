package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.ArticuloTransaccion;
import com.example.demo.repository.entity.Compra;
import com.example.demo.repository.entity.Venta;

@Mapper(componentModel = "spring" , uses = {ArticuloTransaccionMapper.class, VentaMapper.class, CompraMapper.class})
public interface ArticuloMapper {
	ArticuloMapper INSTACE = Mappers.getMapper(ArticuloMapper.class);
	/*
	
	ArticuloDTO toDTO (Articulo articulo);*/
	
	// Mapeo principal de Articulo a ArticuloDTO
	@Mapping(target = "listaArticulosTransaccion",  source = "listaArticulosTransaccion",qualifiedByName = "articulosTransaccionesToArticulosTransaccionesDTO", ignore= true)
	@Mapping(target = "listaVentas", source = "listaVentas", qualifiedByName = "ventasToVentasDTO", ignore= true)
	@Mapping(target = "listaCompras", source = "listaCompras",qualifiedByName = "comprasToComprasDTO", ignore= true)
    ArticuloDTO toDTO(Articulo articulo);

    // Mapeo inverso (opcional)
    Articulo toEntity(ArticuloDTO articuloDTO);
	
	Set<ArticuloDTO> articulosToArticulosDTO(Set<Articulo> listaArticulos);
	
	Set<Articulo> articulosDTOToArticulos(Set<ArticuloDTO> listaArticulosDTO);

}
