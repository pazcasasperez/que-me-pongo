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
@Table(name = "articulos")
public class Articulo {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String color;
	private String marca;
	private String material;
	private String temporada;
	private String imagen;
	private String estado;
	private boolean publicado;
	private String descripcion;
	private String tipo;
	private String genero;
	private boolean activo;
	private String talla;
	private String largo;
	private String grosor;
	private String capacidad;
	@Column(name = "tipo_almacenamiento")
	private String tipoAlmacenamiento;
	private String estampado;

	// Relaciones
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="id_usuario")
	 * 
	 * @ToString.Exclude
	 * private Usuario usuario;
	 */

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "articulo")
	@ToString.Exclude
	private Set<ArticuloTransaccion> listaArticulosTransaccion;

	// Equals y hash
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Articulo() {
		super();

		this.listaArticulosTransaccion = new HashSet<ArticuloTransaccion>();
	}
}
