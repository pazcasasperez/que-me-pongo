package com.example.demo.repository.entity;

import java.time.LocalDate;
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
@Table(name="usuarios")
public class Usuario {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	private String password;
	private String telefono;
	private String imagen;
	private boolean activo;
	private String plan;
	private String rol;
	
	
	// Mapeamos con la entidad UsuarioDireccion
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
	@ToString.Exclude
	private Set<UsuarioDireccion> listaUsuarioDireccion;
	
	// Hash y equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
