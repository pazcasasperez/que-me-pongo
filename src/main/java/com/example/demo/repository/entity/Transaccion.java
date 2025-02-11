package com.example.demo.repository.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "transacciones")
public class Transaccion {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String estado;
	@Column(name = "gastos_envio")
	private double gastosEnvio;
	private LocalDate fecha;
	@ManyToOne
	@JoinColumn(name = "id_pago_compra")
	private Pago pagoCompra;
	@ManyToOne
	@JoinColumn(name = "id_pago_venta")
	private Pago pagoVenta;
	@ManyToOne
	@JoinColumn(name = "id_dir_envio")
	private Direccion envio;
	 @ManyToOne
	@JoinColumn(name = "id_dir_vendedor")
	private Direccion direccionVendedor;

	// private List<Usuario> listaUsuariosVendedores;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transaccion")
	@ToString.Exclude
	private Set<ArticuloTransaccion> articulosTransacciones;
	
	// Relacion tiene - Articulo ---> Vender
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transaccion")
	@ToString.Exclude
	private Set<Venta> listaVentas;
	
	// Relacion tiene - Articulo ---> Vender
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transaccion")
	@ToString.Exclude
	private Set<Compra> listaCompras;

	public Transaccion() {
		super();

		this.articulosTransacciones = new HashSet<ArticuloTransaccion>();
	}

	// Equals y hashCode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
