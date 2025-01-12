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

    private Long idArticulo;
    private Long idTransaccion;
    private double precioVenta;
    private double precioFinal;

     public static ArticuloTransaccionDTO convertToDTO(ArticuloTransaccion articulosTransaccion) {
        ArticuloTransaccionDTO articulosTransaccionDTO = new ArticuloTransaccionDTO();

        articulosTransaccionDTO.setId(articulosTransaccion.getId());
        articulosTransaccionDTO.setIdArticulo(articulosTransaccion.getIdArticulo());
        articulosTransaccionDTO.setIdTransaccion(articulosTransaccion.getIdTransaccion());
        articulosTransaccionDTO.setPrecioVenta(articulosTransaccion.getPrecioVenta());
        articulosTransaccionDTO.setPrecioFinal(articulosTransaccion.getPrecioFinal());

        return articulosTransaccionDTO;
    }

    ArticuloTransaccion convertToEntity(ArticuloTransaccionDTO articulosTransaccionDTO) {
        ArticuloTransaccion articulosTransaccion = new ArticuloTransaccion();

        articulosTransaccion.setId(articulosTransaccionDTO.getId());
        articulosTransaccion.setIdArticulo(articulosTransaccionDTO.getIdArticulo());
        articulosTransaccion.setIdTransaccion(articulosTransaccionDTO.getIdTransaccion());
        articulosTransaccion.setPrecioVenta(articulosTransaccionDTO.getPrecioVenta());
        articulosTransaccion.setPrecioFinal(articulosTransaccionDTO.getPrecioFinal());

        return articulosTransaccion;
    }
}
