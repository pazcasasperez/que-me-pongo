package com.example.demo.model.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import com.example.demo.repository.entity.Direccion;
import com.example.demo.repository.entity.Transaccion;
import com.example.demo.repository.entity.UsuarioDireccion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Data
public class DireccionDTO implements Serializable{

	// Atributos
	private static final long serialVersionUID = 1L;
	private Long id;
	private String via;
	private String nombre;
	private String numero;
	private String puerta;
	@Column(name = "cp")
	private String codigoPostal;
	private String provincia;
	private boolean activo;
	private String ciudad;
	@Column(name = "nombre_pto_recogida")
	private String nombrePuntoRecogida;
	@Column(name = "telefono_pto_Recogida")
	private String telefonoPuntoRecogida;
	@Column(name = "horario_pto_recogida")
	private String horariosPuntorecogida;
	@Column(name = "persona_contacto_pto_recogida")
	private String personaContactoPuntoRecogida;

	// Relaciones
	private Set<UsuarioDireccionDTO> listaUsuarioDireccion;
	//Direccion ---> Transaccion
	private Set<TransaccionDTO> listaTransaccionesEnvios;
	 
	//Direccion ---> Transaccion
	private Set<TransaccionDTO> listaTransaccionesVendedores;

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
		DireccionDTO other = (DireccionDTO) obj;
		return Objects.equals(id, other.id);
	}

	// Conversiones
	public static DireccionDTO convertToDTO(Direccion direccion) {

		DireccionDTO direccionDTO = new DireccionDTO();
		direccionDTO.setId(direccion.getId());
		direccionDTO.setVia(direccion.getVia());
		direccionDTO.setNombre(direccion.getNombre());
		direccionDTO.setNumero(direccion.getNumero());
		direccionDTO.setPuerta(direccion.getPuerta());
		direccionDTO.setCodigoPostal(direccion.getCodigoPostal());
		direccionDTO.setProvincia(direccion.getProvincia());
		direccionDTO.setActivo(direccion.isActivo());
		direccionDTO.setCiudad(direccion.getCiudad());
		direccionDTO.setNombrePuntoRecogida(direccion.getNombrePuntoRecogida());
		direccionDTO.setTelefonoPuntoRecogida(direccion.getTelefonoPuntoRecogida());
		direccionDTO.setHorariosPuntorecogida(direccion.getHorariosPuntorecogida());
		direccionDTO.setPersonaContactoPuntoRecogida(direccion.getPersonaContactoPuntoRecogida());

		return direccionDTO;
	}

	public static Direccion convertToEntity(DireccionDTO direccionDTO) {

		Direccion direccion = new Direccion();
		direccion.setId(direccionDTO.getId());
		direccion.setVia(direccionDTO.getVia());
		direccion.setNombre(direccionDTO.getNombre());
		direccion.setNumero(direccionDTO.getNumero());
		direccion.setPuerta(direccionDTO.getPuerta());
		direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
		direccion.setProvincia(direccionDTO.getProvincia());
		direccion.setActivo(direccionDTO.isActivo());
		direccion.setCiudad(direccionDTO.getCiudad());
		direccion.setNombrePuntoRecogida(direccionDTO.getNombrePuntoRecogida());
		direccion.setTelefonoPuntoRecogida(direccionDTO.getTelefonoPuntoRecogida());
		direccion.setHorariosPuntorecogida(direccionDTO.getHorariosPuntorecogida());
		direccion.setPersonaContactoPuntoRecogida(direccionDTO.getPersonaContactoPuntoRecogida());

		return direccion;
	}
}
