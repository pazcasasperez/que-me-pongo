package com.example.demo.service.mapper;

import java.util.List;
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
	@Mapping(target ="listaArticulosTransaccion", source = "listaArticulosTransaccion", ignore=true) 
	@Mapping(target = "listaVentas", source ="listaVentas", ignore=true) 
	@Mapping(target ="listaCompras", source = "listaCompras", ignore=true)
	@Mapping(target = "usuario", source = "usuario", ignore = true)
	ArticuloDTO toDTO(Articulo articulo); 
	
	// Mapeo inverso (opcional)
	@Named("toEntityA")
	@Mapping(target = "listaArticulosTransaccion", source ="listaArticulosTransaccion", ignore=true) 
	@Mapping(target= "listaVentas", source = "listaVentas", ignore=true)
	@Mapping(target = "listaCompras", source = "listaCompras", ignore=true) 
	@Mapping(target = "usuario", source = "usuario", ignore= true)
	Articulo toEntity(ArticuloDTO articuloDTO);
	
	@IterableMapping(qualifiedByName = "toDTOA") 
	List<ArticuloDTO> articulosToArticulosDTO(Set<Articulo> listaArticulos);
	
	@IterableMapping(qualifiedByName = "toEntityA") 
	Set<Articulo> articulosDTOToArticulos(List<ArticuloDTO> listaArticulosDTO);

}
