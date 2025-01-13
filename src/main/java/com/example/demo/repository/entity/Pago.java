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
@Table(name="pagos")
public class Pago {
	//Atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	@Column(name="t_numero")
	private String numeroTarjeta;
	@Column(name="t_caducidad")
	private String fechaCaducidadTarjeta;
	@Column(name="t_nombre")
	private String nombreTarjeta;
	@Column(name="t_cvc")
	private String cvcTarjeta;
	private String correo;
	@Column(name="n_telefono")
	private String numeroTelefono;
	
	
	//Hash y equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pago other = (Pago) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
