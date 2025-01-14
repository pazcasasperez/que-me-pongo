package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.ArticuloTransaccionDTO;
import com.example.demo.model.dto.TransaccionDTO;

public interface TransaccionService {

    List<TransaccionDTO> findAll();

    List<ArticuloTransaccionDTO> findByArticulo(ArticuloDTO articuloDTO
    );

}
