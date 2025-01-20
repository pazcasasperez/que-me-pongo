package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.example.demo.repository.entity.Compra;
import com.example.demo.repository.entity.Venta;

import lombok.Data;

@Data 
public class CompraDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private UsuarioDTO usuario;
	private ArticuloDTO articulo;
	private TransaccionDTO transaccion;

	//Conversiones
	public static CompraDTO convertToDTO(Compra compra) {
		CompraDTO compraDTO = new CompraDTO();
		compraDTO.setId(compra.getId());
		compraDTO.setArticulo( ArticuloDTO.convertToDTO(compra.getArticulo()));
		compraDTO.setUsuario(UsuarioDTO.convertToDTO(compra.getUsuario()));
		compraDTO.setTransaccion(TransaccionDTO.convertToDTO(compra.getTransaccion()));
		
		return compraDTO;
	}
	
	public static Compra convertToEntity(CompraDTO compraDTO) {
		Compra compra = new Compra();
		compra.setId(compraDTO.getId());
		compra.setArticulo( ArticuloDTO.convertToEntity(compraDTO.getArticulo()));
		compra.setUsuario(UsuarioDTO.convertToEntity(compraDTO.getUsuario()));
		compra.setTransaccion(TransaccionDTO.convertToEntity(compraDTO.getTransaccion()));
		
		return compra;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompraDTO other = (CompraDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
