package com.example.demo.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.example.demo.repository.entity.Pago;
import com.example.demo.repository.entity.Transaccion;
import com.example.demo.repository.entity.Usuario;
import com.example.demo.repository.entity.Venta;
import com.example.demo.repository.entity.ArticuloTransaccion;
import com.example.demo.repository.entity.Compra;
import com.example.demo.repository.entity.Direccion;

import lombok.Data;
import lombok.ToString;

@Data
public class TransaccionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long id;
    private String estado;
    private double gastosEnvio;
    private LocalDate fecha;
    private Pago pagoCompra;
    private Pago pagoVenta;
    private Direccion envio;
    private Direccion direccionVendedor;
    // @ToString.Exclude
    // private List<Usuario> listaUsuariosVendedores;
    @ToString.Exclude
    private List<ArticuloTransaccionDTO> articulosTransacciones;
    private Set<VentaDTO> listaVentas;
	private Set<CompraDTO> listaCompras;

    public static TransaccionDTO convertToDTO(Transaccion transaccion) {
        TransaccionDTO transaccionDTO = new TransaccionDTO();

        transaccionDTO.setId(transaccion.getId());
        transaccionDTO.setEstado(transaccion.getEstado());
        transaccionDTO.setGastosEnvio(transaccion.getGastosEnvio());
        transaccionDTO.setFecha(transaccion.getFecha());
        transaccionDTO.setPagoCompra(transaccion.getPagoCompra());
        transaccionDTO.setPagoVenta(transaccion.getPagoVenta());
        transaccionDTO.setEnvio(transaccion.getEnvio());
        transaccionDTO.setDireccionVendedor(transaccion.getDireccionVendedor());
        transaccionDTO.setDireccionVendedor(transaccion.getDireccionVendedor());
        
        // Mirar las conversiones de las listas
         
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

        return transaccion;

    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransaccionDTO other = (TransaccionDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
    
    

}
