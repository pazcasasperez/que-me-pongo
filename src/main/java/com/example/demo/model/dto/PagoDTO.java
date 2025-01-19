package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.demo.repository.entity.Pago;
import com.example.demo.repository.entity.Transaccion;

import lombok.Data;

@Data
public class PagoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String tipo;
	private String numeroTarjeta;
	private String fechaCaducidadTarjeta;
	private String nombreTarjeta;
	private String cvcTarjeta;
	private String correo;
	private String numeroTelefono;
	
	//Relaciones
	
	private List<TransaccionDTO> transaccionRecibida = new ArrayList<TransaccionDTO>();
	private List<TransaccionDTO> transaccionRealizada = new ArrayList<TransaccionDTO>();
	
	// Conversiones
	public static PagoDTO convertToDTO(Pago pago) {
		PagoDTO pagoDTO = new PagoDTO();
		pagoDTO.setId(pago.getId());
		pagoDTO.setTipo(pago.getTipo());
		pagoDTO.setNumeroTarjeta(pago.getNumeroTarjeta());
		pagoDTO.setFechaCaducidadTarjeta(pago.getFechaCaducidadTarjeta());
		pagoDTO.setNombreTarjeta(pago.getNombreTarjeta());
		pagoDTO.setCvcTarjeta(pago.getCvcTarjeta());
		pagoDTO.setCorreo(pago.getCorreo());
		pagoDTO.setNumeroTelefono(pago.getNumeroTelefono());
		
		return pagoDTO;
	}
	
	public static Pago convertToEntity(PagoDTO pagoDTO) {
		Pago pago = new Pago();
		pago.setId(pagoDTO.getId());
		pago.setTipo(pagoDTO.getTipo());
		pago.setNumeroTarjeta(pagoDTO.getNumeroTarjeta());
		pago.setFechaCaducidadTarjeta(pagoDTO.getFechaCaducidadTarjeta());
		pago.setNombreTarjeta(pagoDTO.getNombreTarjeta());
		pago.setCvcTarjeta(pagoDTO.getCvcTarjeta());
		pago.setCorreo(pagoDTO.getCorreo());
		pago.setNumeroTelefono(pagoDTO.getNumeroTelefono());
		
		return pago;
	}
	
	//HASH Y EQUALS
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagoDTO other = (PagoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	
}
