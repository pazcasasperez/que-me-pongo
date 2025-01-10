package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.PagoDTO;

public interface PagoService {

	List<PagoDTO> findAll();

}
