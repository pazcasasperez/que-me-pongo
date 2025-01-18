package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.CompraDTO;
import com.example.demo.repository.entity.Compra;

@Mapper(componentModel = "spring")
public interface CompraMapper {
	CompraMapper INSTACE = Mappers.getMapper(CompraMapper.class);
	
	CompraDTO toDTO(Compra compra);

	Compra toEntity(CompraDTO comprasDTO);
	
	@Named("comprasToComprasDTO")
    @Mapping(target = "articulo", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "transaccion", ignore = true)
	Set<CompraDTO> comprasToComprasDTO(Set<Compra> listaCompras);
	
	Set<Compra> transaccionesDTOToTransacciones(Set<CompraDTO> listaComprasDTO);

}
