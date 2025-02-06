package com.example.demo.model.dto;

import lombok.Data;

@Data
public class TokenDTO {

	private String token;
	private Long tiempoExpiracion;

	public TokenDTO(String token, Long tiempoExpiracion) {
		this.token = token;
		this.tiempoExpiracion = tiempoExpiracion;
	}
}

