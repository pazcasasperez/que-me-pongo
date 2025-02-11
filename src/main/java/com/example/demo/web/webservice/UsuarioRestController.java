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

	@GetMapping
	public List<UsuarioDTO> findAll() {
		log.info(UsuarioRestController.class.getSimpleName() + " - listamos todos los usuarios");

		ModelAndView mv = new ModelAndView("usuarios");
		List<UsuarioDTO> listaUsuarioDTO = usuarioService.findAll();

		return listaUsuarioDTO;
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable("idUsurario") Long idUsuario) {

		// Obtenemos el usuario y se lo pasamos al modelo
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(idUsuario);
		usuarioDTO = usuarioService.findById(usuarioDTO);

		if (usuarioDTO == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
		}
	}


	//  @PathVariable("nombreusuario") String nombreusuario,
	// @PathVariable("password") String password
	
	@PostMapping("/login")
	public ResponseEntity<Integer> login(@RequestBody UsuarioDTO usuarioDTO) {

		log.info(UsuarioRestController.class.getSimpleName() + " - login ");

		log.info(usuarioDTO.toString());

		int idUsuario = usuarioService.login(usuarioDTO);
		if (idUsuario < 0) {
			log.info("ha fallado");
			return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

	/*
	 * IMPLEMENTAR EL SAVE EN EL SERVICE ADD
	 * 
	 * @PostMapping () public ResponseEntity add (@RequestBody UsuarioDTO
	 * usuarioDTO){
	 * 
	 * log.info(UsuarioRestController.class.getSimpleName() +
	 * " - creamos los datos del usuario");
	 * 
	 * int resultado = usuarioService.save(usuarioDTO);
	 * 
	 * if (resultado == 1) { return new ResponseEntity<>(HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.BAD_REQUEST); } }
	 */

	/*
	 * COMO ARRIBA, FALTA IMPLEMENTAR EL SAVE // Actualizar el usuario UPDATE
	 * 
	 * @PutMapping () El put actualiza todos los datos del usuario (ES EL QUE SE
	 * USA, EL PATCH POCAS VECES) // @PatchMapping ("/update") // En cambio, el
	 * patch solo actualiza el dato que se cambia public ResponseEntity update
	 * (@RequestBody UsuarioDTO usuarioDTO){
	 * 
	 * log.info(UsuarioRestController.class.getSimpleName() +
	 * " - actualizamos los datos del usuario");
	 * 
	 * int resultado = usuarioService.save(usuarioDTO);
	 * 
	 * if (resultado == 1) { return new ResponseEntity<>(HttpStatus.OK); } else {
	 * return new ResponseEntity<>(HttpStatus.BAD_REQUEST); } }
	 */

	/*
	 * HAY QUE IMPLEMENTAR EL DELETE EN EL SERVICE

	}*/
	
	/* COMO ARRIBA, FALTA IMPLEMENTAR EL SAVE
	// Actualizar el usuario
	 * UPDATE
	@PutMapping () El put actualiza todos los datos del usuario (ES EL QUE SE USA, EL PATCH POCAS VECES)
	// @PatchMapping ("/update") // En cambio, el patch solo actualiza el dato que se cambia
	public ResponseEntity update (@RequestBody UsuarioDTO usuarioDTO){
		
		log.info(UsuarioRestController.class.getSimpleName() + " - actualizamos los datos del usuario");
		
		int resultado = usuarioService.save(usuarioDTO);
		
		if (resultado == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	/* HAY QUE IMPLEMENTAR EL DELETE EN EL SERVICE 

	 * 
	 * 		FOTO DEL DIA 30/01/2025
	 * 
	 * DELETE
	@DeleteMapping ()
	public ResponseEntity<String> delete (@PathVariable("idUsuario") Long idUsuario){
		
		log.info(UsuarioRestController.class.getSimpleName() + " - borramos los datos del usuario");
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(idUsuario);
		usuarioService.delete(usuarioDTO);
		
		return new ResponseEntity<>("Cliente " + usuarioDTO + (" borrado satisfactoriamente"), HttpStatus.OK);
	}*/
}
