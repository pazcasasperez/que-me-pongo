package com.example.demo.service.mapper;

import java.util.Set;

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
	
	VentaMapper INSTACE = Mappers.getMapper(VentaMapper.class);
	/*
	
	ArticuloDTO toDTO (Articulo articulo);*/
	
	// Mapeo principal de Articulo a ArticuloDTO
	

    VentaDTO toDTO(Venta venta);

    // Mapeo inverso (opcional)
    Venta toEntity(VentaDTO ventaDTO);
    
    @Named("ventasToVentasDTO")
    @Mapping(target = "articulo", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "transaccion", ignore = true)
	Set<VentaDTO> ventasToVentasDTO(Set<Venta> listaVentas);
	
	Set<Venta> ventasDTOToVentas(Set<VentaDTO> listaVentasDTO);

}
