package com.example.demo.model.dto;

import java.util.Objects;

import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Usuario;

import lombok.Data;

@Data
public class ArticuloDTO {
	//Atributos
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
	private String tipoAlmacenamiento;
	private String estampado;
	
	//Relaciones
	//private UsuarioDTO usuario;
	
	//Hash y equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloDTO other = (ArticuloDTO) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	//Conversiones
	public static ArticuloDTO convertToDTO(Articulo articulo) {
		ArticuloDTO articuloDTO = new ArticuloDTO();
		articuloDTO.setId(articulo.getId());
		articuloDTO.setColor(articulo.getColor());
		articuloDTO.setMarca(articulo.getMarca());
		articuloDTO.setMaterial(articulo.getMaterial());
		articuloDTO.setTemporada(articulo.getTemporada());
		articuloDTO.setImagen(articulo.getImagen());
		articuloDTO.setEstado(articulo.getEstado());
		articuloDTO.setPublicado(articulo.isPublicado());
		articuloDTO.setDescripcion(articulo.getDescripcion());
		articuloDTO.setTipo(articulo.getTipo());
		articuloDTO.setGenero(articulo.getGenero());
		articuloDTO.setActivo(articulo.isActivo());
		articuloDTO.setTalla(articulo.getTalla());
		articuloDTO.setLargo(articulo.getLargo());
		articuloDTO.setGrosor(articulo.getGrosor());
		articuloDTO.setCapacidad(articulo.getCapacidad());
		articuloDTO.setTipoAlmacenamiento(articulo.getTipoAlmacenamiento());
		articuloDTO.setEstampado(articulo.getEstampado());
		
		return articuloDTO;
	}
	
	public static Articulo convertToEntity(ArticuloDTO articuloDTO) {
		Articulo articulo = new Articulo();
		articulo.setId(articuloDTO.getId());
		articulo.setColor(articuloDTO.getColor());
		articulo.setMarca(articuloDTO.getMarca());
		articulo.setMaterial(articuloDTO.getMaterial());
		articulo.setTemporada(articuloDTO.getTemporada());
		articulo.setImagen(articuloDTO.getImagen());
		articulo.setEstado(articuloDTO.getEstado());
		articulo.setPublicado(articuloDTO.isPublicado());
		articulo.setDescripcion(articuloDTO.getDescripcion());
		articulo.setTipo(articuloDTO.getTipo());
		articulo.setGenero(articuloDTO.getGenero());
		articulo.setActivo(articuloDTO.isActivo());
		articulo.setTalla(articuloDTO.getTalla());
		articulo.setLargo(articuloDTO.getLargo());
		articulo.setGrosor(articuloDTO.getGrosor());
		articulo.setCapacidad(articuloDTO.getCapacidad());
		articulo.setTipoAlmacenamiento(articuloDTO.getTipoAlmacenamiento());
		articulo.setEstampado(articuloDTO.getEstampado());
		
		return articulo;
	}
}
