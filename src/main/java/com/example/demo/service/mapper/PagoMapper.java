package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.PagoDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Pago;

@Mapper(componentModel = "spring")
public interface PagoMapper {
	PagoMapper INSTACE = Mappers.getMapper(PagoMapper.class);

	PagoDTO toDTO(Pago pago);

	Pago toEntity(PagoDTO articuloDTO);
	
	Set<PagoDTO> pagosToPagosDTO(Set<Pago> listaPagos);
	
	Set<Pago> pagosDTOToPagos(Set<PagoDTO> listaPagosDTO);

}
