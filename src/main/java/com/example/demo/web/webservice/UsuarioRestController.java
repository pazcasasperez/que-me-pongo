package com.example.demo.web.webservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repository.entity.Usuario;
import com.example.demo.service.UsuarioService;
import com.example.demo.web.controller.UsuarioController;

@RestController
@RequestMapping("/api/usuarios") // Aqui es donde va a empezar a escuchar el mapping
public class UsuarioRestController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioRestController.class);

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("")
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		log.info(UsuarioRestController.class.getSimpleName() + " -- listamos todos los usuarios");

		List<UsuarioDTO> listaUsuariosDTO = usuarioService.findAll();

		return new ResponseEntity<>(listaUsuariosDTO, HttpStatus.OK);
	}

	/*
	 * //Obtenemos los usuarios por get
	 * 
	 * @GetMapping public List<UsuarioDTO> findAll() {
	 * log.info(UsuarioRestController.class.getSimpleName() +
	 * " - listamos todos los usuarios");
	 * 
	 * ModelAndView mv = new ModelAndView("usuarios"); List<UsuarioDTO>
	 * listaUsuarioDTO = usuarioService.findAll();
	 * 
	 * return listaUsuarioDTO; }
	 */

	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable("idUsuario") Long idUsuario) {

		log.info(UsuarioRestController.class.getSimpleName() + " -- listamos los usuarios con el id " + idUsuario);

		// Obtenemos el usuario y se lo pasamos al modelo
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(idUsuario);
		usuarioDTO = usuarioService.findById(usuarioDTO);

		// Nos aseguramos de que no sea null el usuario
		if (usuarioDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Integer> login(@RequestBody UsuarioDTO usuarioDTO) {

		log.info(UsuarioRestController.class.getSimpleName() + " - login ");

		log.info(usuarioDTO.toString());

		int idUsuario = usuarioService.login(usuarioDTO);
		if (idUsuario < 0) {
			log.info("ha fallado");
			return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
		} else {
			log.info("ha triunfado");
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@GetMapping("/search/{nombreUsuario}")
	public ResponseEntity<UsuarioDTO> findByNombreUsuario(@PathVariable("nombreUsuario") String nomUsuario) {
		log.info(UsuarioRestController.class.getSimpleName() + " - Buscamos si existe el cliente: " + nomUsuario);
		// Obtenemos el usuario y se lo pasamos al modelo
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNombreUsuario(nomUsuario);
		usuarioDTO = usuarioService.findByNombreUsuario(usuarioDTO);

		log.info(usuarioDTO.toString());

		if (usuarioDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
		}
	}

	@PutMapping("")
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioDTO){
		
		log.info(UsuarioRestController.class.getSimpleName() + "-- Actualizamos el usuario: " + usuarioDTO.getNombreUsuario());
		
		// Buscamos el usuario, por medio del servicio para ver que existe realmente
		UsuarioDTO usuarioBDTO = new UsuarioDTO();
		usuarioBDTO.setId(usuarioDTO.getId());
		usuarioBDTO = usuarioService.findById(usuarioBDTO);
		
		// En el caso de que el usuario no existe, mandamos un not_found
		if (usuarioBDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		usuarioDTO = usuarioService.save(usuarioDTO);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<UsuarioDTO> add(@RequestBody UsuarioDTO usuarioDTO) {
		log.info(ArticuloRestController.class.getSimpleName() + " -- Añadir un¡ usuario ");

		usuarioDTO = usuarioService.save(usuarioDTO);

		if (usuarioDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		// Si lo hemos insertadp. Le devolvemos que se ha insertado
		// y le mandamos el articulo
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}

	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<String> delete(@PathVariable("idUsuario") Long idUsuario) {

		log.info(UsuarioRestController.class.getSimpleName() + " - borramos los datos del usuario");

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(idUsuario);
		usuarioService.delete(usuarioDTO);

		return new ResponseEntity<>("Usuario " + usuarioDTO + (" borrado satisfactoriamente"), HttpStatus.OK);
	}
}