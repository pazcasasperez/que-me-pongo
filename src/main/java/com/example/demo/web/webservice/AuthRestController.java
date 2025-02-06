package com.example.demo.web.webservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.AuthorizeRequestsDsl;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.LoginDTO;
import com.example.demo.model.dto.TokenDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.service.AuthService;
import com.example.demo.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ArticuloRestController.class);
	
	@Autowired
	private AuthService authService;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	// LoginDTO input
	public ResponseEntity<?> login(@RequestBody LoginDTO request) {
		log.info("       Controlador rebido" + request.getNombreUsuario());
		UsuarioDTO uDTO = authService.login(request);
		String jwtToken = jwtService.generateToken(uDTO);
		TokenDTO tokenDTO = new TokenDTO(jwtToken, jwtService.getExpirationTime());
		log.info(" " + tokenDTO.getToken());
		return ResponseEntity.ok(tokenDTO);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(err -> {
			String name = err.getObjectName();
			String msg = err.getDefaultMessage();
			errors.put(name, msg);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
