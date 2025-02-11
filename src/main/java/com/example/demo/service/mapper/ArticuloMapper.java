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

@Mapper(componentModel = "spring", uses = { ArticuloTransaccionMapper.class, VentaMapper.class, CompraMapper.class })
public interface ArticuloMapper {
	ArticuloMapper INSTANCE = Mappers.getMapper(ArticuloMapper.class);
	//Mapeo principal de Articulo a ArticuloDTO 
	@Named("toDTOA")
	@Mapping(target ="listaArticulosTransaccion", source = "listaArticulosTransaccion",qualifiedByName = "toDTOT", ignore=true) 
	@Mapping(target = "listaVentas", source ="listaVentas", qualifiedByName = "toDTOV", ignore=true) 
	@Mapping(target ="listaCompras", source = "listaCompras", qualifiedByName = "toDTOC", ignore=true)
	ArticuloDTO toDTO(Articulo articulo); 
	
	// Mapeo inverso (opcional)
	@Named("toEntityA")
	@Mapping(target = "listaArticulosTransaccion", source ="listaArticulosTransaccion", qualifiedByName = "toEntityT", ignore=true) 
	@Mapping(target= "listaVentas", source = "listaVentas", qualifiedByName = "toEntityV", ignore=true)
	@Mapping(target = "listaCompras", source = "listaCompras", qualifiedByName ="toEntityC", ignore=true) 
	Articulo toEntity(ArticuloDTO articuloDTO);
	
	@IterableMapping(qualifiedByName = "toDTOA") 
	Set<ArticuloDTO> articulosToArticulosDTO(Set<Articulo> listaArticulos);
	
	@IterableMapping(qualifiedByName = "toEntityA") 
	Set<Articulo> articulosDTOToArticulos(Set<ArticuloDTO> listaArticulosDTO);

}
