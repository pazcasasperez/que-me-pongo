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
	
	@Named("toDTOV")
	@Mapping(target ="usuario", source = "usuario") 
	@Mapping(target ="articulo", source = "articulo")
	@Mapping(target ="transaccion", source = "transaccion")
    VentaDTO toDTO(Venta venta);

    // Mapeo inverso (opcional)
	@Named("toEntityV")
	@Mapping(target ="usuario", source = "usuario") 
	@Mapping(target ="articulo", source = "articulo")
	@Mapping(target ="transaccion", source = "transaccion")
    Venta toEntity(VentaDTO ventaDTO);
    
    @IterableMapping(qualifiedByName = "toDTOV")
	Set<VentaDTO> ventasToVentasDTO(Set<Venta> listaVentas);
    @IterableMapping(qualifiedByName = "toEntityV")
	Set<Venta> ventasDTOToVentas(Set<VentaDTO> listaVentasDTO);

}
