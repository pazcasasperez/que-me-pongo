package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Objects;

import com.example.demo.repository.entity.Compra;
import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Usuario;
import com.example.demo.repository.entity.UsuarioDireccion;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
public class UsuarioDireccionDTO implements Serializable  {
	private static final long serialVersionUID = 1L;
	private Long id;
	private UsuarioDTO usuario;
	private DireccionDTO direccion;
	
	//Conversiones
	
	public static UsuarioDireccionDTO convertToDTO(UsuarioDireccion ud) {
		UsuarioDireccionDTO udDTO = new UsuarioDireccionDTO();
		
		udDTO.setDireccion(DireccionDTO.convertToDTO(ud.getDireccion()));
		udDTO.setUsuario(UsuarioDTO.convertToDTO(ud.getUsuario()));
		return udDTO;
	}
	
	public static UsuarioDireccion convertToEntity(UsuarioDireccionDTO udDTO) {
		UsuarioDireccion ud = new UsuarioDireccion();
		
		ud.setDireccion(DireccionDTO.convertToEntity(udDTO.getDireccion()));
		ud.setUsuario(UsuarioDTO.convertToEntity(udDTO.getUsuario()));
		
		return ud;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDireccionDTO other = (UsuarioDireccionDTO) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

}
