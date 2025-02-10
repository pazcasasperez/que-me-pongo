package com.example.demo.service.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.PagoDTO;
import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Pago;

@Mapper(componentModel = "spring")
public interface PagoMapper {
	PagoMapper INSTACE = Mappers.getMapper(PagoMapper.class);
	
	@Named("toDTOP")
	@Mapping(target ="transaccionRecibida", source = "listaPagosCompras",qualifiedByName = "toDTOT", ignore=true) 
	@Mapping(target = "transaccionRealizada", source ="listaPagoVentas", qualifiedByName = "toDTOT", ignore=true) 
	PagoDTO toDTO(Pago pago);

	
	@Named("toEntityP")
	@Mapping(target ="listaPagosCompras", source = "transaccionRecibida",qualifiedByName = "toDTOT", ignore=true) 
	@Mapping(target = "listaPagoVentas", source ="transaccionRealizada", qualifiedByName = "toDTOT", ignore=true) 
	Pago toEntity(PagoDTO articuloDTO);
	
	@IterableMapping(qualifiedByName = "toDTOP") 
	Set<PagoDTO> pagosToPagosDTO(Set<Pago> listaPagos);
	
	@IterableMapping(qualifiedByName = "toEntityP") 
	Set<Pago> pagosDTOToPagos(Set<PagoDTO> listaPagosDTO);

}
