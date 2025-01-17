package com.example.demo.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Compra;
import com.example.demo.repository.entity.Usuario;
import com.example.demo.repository.entity.UsuarioDireccion;
import com.example.demo.repository.entity.Venta;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Data
public class UsuarioDTO implements Serializable{
	
	// Atributos
	private static final long serialVersionUID = 1L;
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
	
	// Relaciones
  	private Set<Articulo> listaArticulos;
	private Set<UsuarioDireccion> listaUsuarioDireccion;
	private Set<Venta> listaVentas;
	private Set<Compra> listaCompras;

	
	// HashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	// Conversiones
	public static UsuarioDTO convertToDTO(Usuario usuario) {
		
		// Creamos el clienteDTO y asignamos los valores
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellidos(usuario.getApellidos());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
		usuarioDTO.setPassword(usuario.getPassword());
		usuarioDTO.setTelefono(usuario.getTelefono());
		usuarioDTO.setImagen(usuario.getImagen());
		usuarioDTO.setActivo(usuario.isActivo());
		usuarioDTO.setPlan(usuario.getPlan());
		usuarioDTO.setRol(usuario.getRol());
		
		// Retornamos el DTO
		return usuarioDTO;
	}
	
	public static Usuario convertToEntity(UsuarioDTO usuarioDTO) {
		
		// Creamos la entidad usuario y le asignamos los valores
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellidos(usuarioDTO.getApellidos());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
		usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
		usuario.setPassword(usuarioDTO.getPassword());
		usuario.setTelefono(usuarioDTO.getTelefono());
		usuario.setImagen(usuarioDTO.getImagen());
		usuario.setActivo(usuarioDTO.isActivo());
		usuario.setPlan(usuarioDTO.getPlan());
		usuario.setRol(usuarioDTO.getRol());
		
		//Retornamos la entidad
		return usuario;
	}
	
}
