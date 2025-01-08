package com.example.demo.repository.entity;

import java.time.LocalDate;
import java.util.List;
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
@Table(name="tansacciones")
public class Transaccion {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String estado;
	@Column(name="gastos_envio")
	private double gastosEnvio;
	private LocalDate fecha;
	
	//Relaciones
	private Pago pagoCompra;
	private Pago pagoVenta;
	private Direccion envio;
	private Direccion direccionVendedor;
	private Usuario usuarioCompra;
	private List<Usuario> listaUsuariosVendedores;
	
	//Equals y hashCode
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
