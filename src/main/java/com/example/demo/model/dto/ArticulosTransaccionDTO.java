package com.example.demo.model.dto;

import com.example.demo.repository.entity.ArticulosTransaccion;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ArticulosTransaccionDTO {

      @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long idArticulo;
    private Long idTransaccion;
    private double preciVenta;
    private double precioFinal;

    ArticulosTransaccionDTO convertToDTO(ArticulosTransaccion articulosTransaccion) {
        ArticulosTransaccionDTO articulosTransaccionDTO = new ArticulosTransaccionDTO();

        articulosTransaccionDTO.setId(articulosTransaccion.getId());
        articulosTransaccionDTO.setIdArticulo(articulosTransaccion.getIdArticulo());
        articulosTransaccionDTO.setIdTransaccion(articulosTransaccion.getIdTransaccion());
        articulosTransaccionDTO.setPreciVenta(articulosTransaccion.getPreciVenta());
        articulosTransaccionDTO.setPrecioFinal(articulosTransaccion.getPrecioFinal());

        return articulosTransaccionDTO;
    }
    

    ArticulosTransaccion convertToEntity(ArticulosTransaccionDTO articulosTransaccionDTO) {
        ArticulosTransaccion articulosTransaccion= new ArticulosTransaccion();

        articulosTransaccion.setId(articulosTransaccionDTO.getId());
        articulosTransaccion.setIdArticulo(articulosTransaccionDTO.getIdArticulo());
        articulosTransaccion.setIdTransaccion(articulosTransaccionDTO.getIdTransaccion());
        articulosTransaccion.setPreciVenta(articulosTransaccionDTO.getPreciVenta());
        articulosTransaccion.setPrecioFinal(articulosTransaccionDTO.getPrecioFinal());

        return articulosTransaccion;
    }
}
