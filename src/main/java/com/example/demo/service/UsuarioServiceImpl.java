package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repository.dao.UsuarioRepository;
import com.example.demo.repository.entity.Usuario;
import com.example.demo.service.mapper.ArticuloMapper;
import com.example.demo.service.mapper.UsuarioMapper;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDTO> findAll() {

		log.info(UsuarioServiceImpl.class.getName() + " - Listamos todos los usuarios");

		List<UsuarioDTO> listarUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> listarUsuario = usuarioRepository.findAll();
		for (Usuario a : listarUsuario) {
			listarUsuarioDTO.add(UsuarioMapper.INSTACE.toDTO(a));
			// listarUsuarioDTO.add(UsuarioDTO.convertToDTO(a));
		}

		return listarUsuarioDTO;
	}

	@Override
	public UsuarioDTO findById(UsuarioDTO usuarioDTO) {

		log.info(UsuarioServiceImpl.class.getName() + " - Buscamos el cliente por el id");

		Usuario u = usuarioRepository.findById(usuarioDTO.getId()).get();
		usuarioDTO = UsuarioDTO.convertToDTO(u);

		return usuarioDTO;

		/*
		 * Optional<Usuario> usuario = usuarioRepository.findById(usuarioDTO.getId());
		 * if (usuario.isPresent()) { usuarioDTO =
		 * UsuarioDTO.convertToDTO(usuario.get()); return usuarioDTO; } return null;
		 */
	}
	/*
	 * 
	 * @Override public void save(UsuarioDTO usuarioDTO) {
	 * 
	 * log.info(UsuarioServiceImpl.class.getName()+ " - Guardamos el usuario");
	 * 
	 * Usuario usuario = UsuarioDTO.convertToEntity(usuarioDTO);
	 * usuarioRepository.save(usuario); }
	 */

	@Override
	public int login(UsuarioDTO usuarioDTO) {

		log.info(UsuarioServiceImpl.class.getName() + " - Login");

		// Nos devuelve una lista de usuarios
		Optional<Usuario> usuario = usuarioRepository.login(usuarioDTO.getNombreUsuario()); 																						

		if (usuario.isEmpty()) {
			return -1; 
			// Devolvemos -1 porque no hay ningun id negativo, por lo tanto, si nos devuelve -1
			// sabremos que el usuario esta vacío
		} else {
			return Math.toIntExact(usuario.stream().findFirst().get().getId());
		}

	}

	@Override
	public UsuarioDTO findByNombreUsuario(UsuarioDTO usuarioDTO) {
		log.info(UsuarioServiceImpl.class.getName() + " - Buscamos el cliente por el nombreUsuario "
				+ usuarioDTO.getNombreUsuario());
		Optional<Usuario> usuario = usuarioRepository.login(usuarioDTO.getNombreUsuario());
		usuarioDTO = UsuarioMapper.INSTACE.toDTO(usuario.get());
		log.info(UsuarioServiceImpl.class.getName() + " - Vueelta del repositorio: el cliente por el nombreUsuario "
				+ usuarioDTO.toString());
		return usuarioDTO;
	}

	@Override
	public void delete(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public void save(UsuarioDTO usuarioDTO) {
	 * 
	 * log.info(UsuarioServiceImpl.class.getName()+ " - Guardamos el usuario");
	 * 
	 * Usuario usuario = UsuarioDTO.convertToEntity(usuarioDTO);
	 * usuarioRepository.save(usuario); }
	 */

}
