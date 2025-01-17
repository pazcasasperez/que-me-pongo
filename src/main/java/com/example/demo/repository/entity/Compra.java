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
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="compras")
public class Compra {
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
	
	
	//HASH y EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	

}
