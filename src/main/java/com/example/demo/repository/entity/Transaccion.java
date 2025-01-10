package com.example.demo.repository.entity;

import java.time.LocalDate;
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
	@Column(name = "id_pago_compra")
	private Pago pagoCompra;
	@Column(name = "id_dir_envio")
	private Direccion envio;
	@Column(name = "id_dir_vendedor")
	private Direccion direccionVendedor;
	@Column(name = "id_usuario_compra")
	private Usuario usuarioCompra;
	private List<Usuario> listaUsuariosVendedores;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transaccion")
	@ToString.Exclude
	private Set<ArticulosTransaccion> listaArticulosTransaccion;


	
	public Transaccion() {
		super();

		this.listaArticulosTransaccion = new HashSet<ArticulosTransaccion>();
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
