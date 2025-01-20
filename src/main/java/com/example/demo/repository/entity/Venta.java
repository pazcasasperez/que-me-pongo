package com.example.demo.repository.entity;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name="id_usuario")
	@ToString.Exclude
	private Usuario usuario;
	
	@ManyToOne 
	@JoinColumn(name="id_articulo")
	@ToString.Exclude
	private Articulo articulo;
	
	@ManyToOne 
	@JoinColumn(name="id_transaccion")
	@ToString.Exclude
	private Transaccion transaccion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	//EQUALS y HASH
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	

}
