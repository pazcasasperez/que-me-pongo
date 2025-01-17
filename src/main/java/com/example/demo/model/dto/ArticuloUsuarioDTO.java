package com.example.demo.model.dto;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.ArticuloUsuario;
import com.example.demo.repository.entity.Direccion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data 

public class ArticuloUsuarioDTO {
	private Long id;
	private UsuarioDTO usuario;
	private ArticuloDTO articulo;
	@DateTimeFormat(iso=ISO.DATE)
	private Date fecha;
	
	
	//Conversiones
	public static ArticuloUsuarioDTO convertToDTO(ArticuloUsuario au) {
		ArticuloUsuarioDTO auDTO = new ArticuloUsuarioDTO();
		auDTO.setId(au.getId());
		auDTO.setArticulo( ArticuloDTO.convertToDTO(au.getArticulo()));
		auDTO.setUsuario(UsuarioDTO.convertToDTO(au.getUsuario()));
		
		auDTO.setFecha(au.getFecha());
		
		return auDTO;
	}
	
	public static ArticuloUsuario convertToEntity(ArticuloUsuarioDTO auDTO) {
		ArticuloUsuario au = new ArticuloUsuario();
		au.setId(auDTO.getId());
		au.setArticulo( ArticuloDTO.convertToEntity(auDTO.getArticulo()));
		au.setUsuario(UsuarioDTO.convertToEntity(auDTO.getUsuario()));
		
		au.setFecha(auDTO.getFecha());
		
		return au;
	}
	
	
	//HASH y EQUASL
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloUsuarioDTO other = (ArticuloUsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	


}
