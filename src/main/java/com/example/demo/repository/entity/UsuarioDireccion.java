package com.example.demo.repository.entity;

import java.util.Objects;

import jakarta.persistence.Column;
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
@Entity
@Table(name="usuariosdirecciones")
public class UsuarioDireccion {

	//Atributos y primera parte de la relación
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	@ToString.Exclude
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_direccion")
	@ToString.Exclude
	private Direccion direccion;

	// HashCode y equals
	// Añadimos el getId porque no interesa comparar los ids !!!!
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDireccion other = (UsuarioDireccion) obj;
		return Objects.equals(direccion.getId(), other.direccion.getId())
				&& Objects.equals(usuario.getId(), other.usuario.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion.getId(), usuario.getId());
	}	
}
