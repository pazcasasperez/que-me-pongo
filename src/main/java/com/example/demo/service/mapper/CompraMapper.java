package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.CompraDTO;
import com.example.demo.repository.entity.Compra;

@Mapper(componentModel = "spring")
public interface CompraMapper {
	CompraMapper INSTANCE = Mappers.getMapper(CompraMapper.class);
	
	@Named("toDTOC")
	@Mapping(target = "articulo", ignore = true)
	@Mapping(target = "transaccion", ignore = true)
	CompraDTO toDTO(Compra compra);
	@Named("toEntityC")
	@Mapping(target = "articulo", ignore = true)
	@Mapping(target = "transaccion", ignore = true)
	Compra toEntity(CompraDTO comprasDTO);
	
	@IterableMapping(qualifiedByName = "toDTOC")
	Set<CompraDTO> comprasToComprasDTO(Set<Compra> listaCompras);
	
	@IterableMapping(qualifiedByName = "toEntityC")
	Set<Compra> transaccionesDTOToTransacciones(Set<CompraDTO> listaComprasDTO);

}
