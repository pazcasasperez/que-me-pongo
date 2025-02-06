package com.example.demo.service;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.security.JwtUtil;
import com.example.demo.model.dto.LoginDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.repository.dao.UsuarioRepository;
import com.example.demo.repository.entity.Usuario;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);


	public UsuarioDTO login(LoginDTO input) {
		log.info("                         Servicio: "+input.getNombreUsuario());
		UsuarioDTO usuario = this.usuarioRepository.login(input.getNombreUsuario()).map(UsuarioDTO::convertToDTO)
				.orElseThrow(() -> new IllegalArgumentException("Email no encontrado: " + input.getNombreUsuario()));
		if (!passwordEncoder.matches(input.getPassword(), usuario.getPassword())) {
			throw new IllegalArgumentException("Contraseña incorrecta para el email: " + input.getNombreUsuario());
		}
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(input.getNombreUsuario(), input.getPassword()));
		return usuario;
	}

}