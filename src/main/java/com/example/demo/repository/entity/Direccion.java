package com.example.demo.repository.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="direcciones")
public class Direccion {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String via;
	private String nombre;
	private String numero;
	private String puerta;
	// @Column(name="cp")
	// private String codigoPostal;
	// private String provincia;
	// @Column(name = "activo")
	// private Boolean activo;
	// 	private String ciudad;
	// @Column(name="nombre_pto_recogida")
	// private String nombrePuntoRecogida;
	// @Column(name="telefono_pto_recogida")
	// private String telefonoPuntoRecogida;
	// @Column(name="horario_pto_recogida")
	// private String horariosPuntorecogida;
	// @Column(name="persona_contacto_pto_recogida")
	// private String personaContactoPuntoRecogida;
	
	
	// hash y equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

}
