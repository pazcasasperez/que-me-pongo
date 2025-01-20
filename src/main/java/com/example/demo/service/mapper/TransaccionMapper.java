package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Transaccion;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {
	TransaccionMapper INSTACE = Mappers.getMapper(TransaccionMapper.class);
	
	TransaccionDTO toDTO(Transaccion transaccion);

	Transaccion toEntity(TransaccionDTO articuloDTO);
	
	Set<TransaccionDTO> transaccionesToTransaccionesDTO(Set<Transaccion> listaTransacciones);
	
	Set<Transaccion> transaccionesDTOToTransacciones(Set<TransaccionDTO> listaTransaccionesDTO);

}
