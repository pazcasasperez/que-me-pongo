package com.example.demo.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Pago;
import com.example.demo.repository.entity.Transaccion;
import com.example.demo.repository.entity.Usuario;

import lombok.Data;
import lombok.ToString;

@Data
public class TransaccionDTO {

    private Long id;
    private String estado;
    private double gastosEnvio;
    private LocalDate fecha;
    private Pago pagoCompra;
    private Direccion envio;
    private Direccion direccionVendedor;
    private Usuario usuarioCompra;
    @ToString.Exclude
    private List<Usuario> listaUsuariosVendedores;

    public static TransaccionDTO convertToDTO(Transaccion transaccion) {
        TransaccionDTO transaccionDTO = new TransaccionDTO();

        transaccionDTO.setId(transaccion.getId());
        transaccionDTO.setEstado(transaccion.getEstado());
        transaccionDTO.setGastosEnvio(transaccion.getGastosEnvio());
        transaccionDTO.setFecha(transaccion.getFecha());
        transaccionDTO.setPagoCompra(transaccion.getPagoCompra());
        transaccionDTO.setEnvio(transaccion.getEnvio());
        transaccionDTO.setDireccionVendedor(transaccion.getDireccionVendedor());
        transaccionDTO.setUsuarioCompra(transaccion.getUsuarioCompra());
        transaccionDTO.setDireccionVendedor(transaccion.getDireccionVendedor());

        return transaccionDTO;

    }

    public static Transaccion convertToEntity(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = new Transaccion();

        transaccion.setId(transaccionDTO.getId());
        transaccion.setEstado(transaccionDTO.getEstado());
        transaccion.setGastosEnvio(transaccionDTO.getGastosEnvio());
        transaccion.setFecha(transaccionDTO.getFecha());
        transaccion.setPagoCompra(transaccionDTO.getPagoCompra());
        transaccion.setEnvio(transaccionDTO.getEnvio());
        transaccion.setDireccionVendedor(transaccionDTO.getDireccionVendedor());
        transaccion.setUsuarioCompra(transaccionDTO.getUsuarioCompra());

       
        return transaccion;

    }

}
