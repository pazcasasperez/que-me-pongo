package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.VentaDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Venta;

@Mapper(componentModel = "spring")
public interface VentaMapper {
	VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);
	/*
	
	ArticuloDTO toDTO (Articulo articulo);*/
	
	// Mapeo principal de Articulo a ArticuloDTO
	
	@Named("toDTOV")
	@Mapping(target = "articulo", ignore = true)
	@Mapping(target = "transaccion", ignore = true)
    VentaDTO toDTO(Venta venta);

    // Mapeo inverso (opcional)
	@Named("toEntityV")
	@Mapping(target = "articulo", ignore = true)
	@Mapping(target = "transaccion", ignore = true)
    Venta toEntity(VentaDTO ventaDTO);
    
    @IterableMapping(qualifiedByName = "toDTOV")
	Set<VentaDTO> ventasToVentasDTO(Set<Venta> listaVentas);
    @IterableMapping(qualifiedByName = "toEntityV")
	Set<Venta> ventasDTOToVentas(Set<VentaDTO> listaVentasDTO);

}
