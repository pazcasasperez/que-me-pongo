package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.service.ArticuloService;

@RestController
@RequestMapping("/api/articulos") // Prefijo común para las rutas de este controlador
public class ArticuloRestController {

    private static final Logger log = LoggerFactory.getLogger(ArticuloRestController.class);

    @Autowired
    private ArticuloService articuloService;

    // Obtener todos los artículos (GET)
    @GetMapping
    public List<ArticuloDTO> findAll() {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Listando los artículos");
        return articuloService.findAll();
    }

   
}
