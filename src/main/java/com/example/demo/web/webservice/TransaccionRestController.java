package com.example.demo.web.webservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.service.ArticuloService;
import com.example.demo.service.TransaccionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transaccion") 
public class TransaccionRestController {
	
	private static final Logger log = LoggerFactory.getLogger(TransaccionRestController.class);
	
	@Autowired
    private TransaccionService transaccionService;
	
	@GetMapping("/cesta_usuario")
    public ResponseEntity<Map<String, Object>> findByIdEstadoInicial(@PathVariable("nombreUsuario") String nombreUsuario) {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Buscamos una transaccion en estado inicial del cliente " + nombreUsuario);
        TransaccionDTO transaccionDTO = transaccionService.findByNombreUsuarioEstadoInicial(nombreUsuario);
        if (transaccionDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Si lo hemos encontrado. Le devolvemos que se ha encontrado
        // y le mandamos el articulo
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("transaccion", transaccionDTO);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

}
