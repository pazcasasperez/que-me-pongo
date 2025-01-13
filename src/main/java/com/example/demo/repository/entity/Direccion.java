package com.example.demo.repository.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

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
	@Column(name="cp")
	private String codigoPostal;
	private String provincia;
	private boolean activo;
	private String ciudad;
	@Column(name="nombre_pto_recogida")
	private String nombrePuntoRecogida;
	@Column(name="telefono_pto_recogida")
	private String telefonoPuntoRecogida;
	@Column(name="horario_pto_recogida")
	private String horariosPuntorecogida;
	@Column(name="persona_contacto_pto_recogida")
	private String personaContactoPuntoRecogida;
	
	// Mapeamos con la entidad UsuarioDireccion
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "direccion")
	@ToString.Exclude
	private Set<UsuarioDireccion> listaUsuarioDireccion;
	
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
	
	public Direccion() {
		super();
		this.listaUsuarioDireccion = new HashSet<UsuarioDireccion>();
	}
}
