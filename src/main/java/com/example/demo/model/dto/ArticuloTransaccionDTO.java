package com.example.demo.model.dto;

import com.example.demo.repository.entity.ArticuloTransaccion;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ArticuloTransaccionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ArticuloDTO articuloDTO;
    private TransaccionDTO transaccionDTO;
    private double precioVenta;
    private double precioFinal;

     public static ArticuloTransaccionDTO convertToDTO(ArticuloTransaccion articulosTransaccion) {
        ArticuloTransaccionDTO articulosTransaccionDTO = new ArticuloTransaccionDTO();

        articulosTransaccionDTO.setId(articulosTransaccion.getId());
        articulosTransaccionDTO.setPrecioVenta(articulosTransaccion.getPrecioVenta());
        articulosTransaccionDTO.setPrecioFinal(articulosTransaccion.getPrecioFinal());

        articulosTransaccionDTO.setArticuloDTO(ArticuloDTO.convertToDTO(articulosTransaccion.getArticulo()));
        articulosTransaccionDTO.setTransaccionDTO(TransaccionDTO.convertToDTO(articulosTransaccion.getTransaccion()));

        return articulosTransaccionDTO;
    }

    ArticuloTransaccion convertToEntity(ArticuloTransaccionDTO articulosTransaccionDTO) {
        ArticuloTransaccion articulosTransaccion = new ArticuloTransaccion();

        articulosTransaccion.setId(articulosTransaccionDTO.getId());
        
        articulosTransaccion.setPrecioVenta(articulosTransaccionDTO.getPrecioVenta());
        articulosTransaccion.setPrecioFinal(articulosTransaccionDTO.getPrecioFinal());

        articulosTransaccion.setArticulo(ArticuloDTO.convertToEntity(articulosTransaccionDTO.getArticuloDTO()));
        articulosTransaccion.setTransaccion(TransaccionDTO.convertToEntity(articulosTransaccionDTO.getTransaccionDTO()));

        return articulosTransaccion;
    }
}
