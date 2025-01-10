package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.TransaccionDTO;

public interface TransaccionService {

    List<TransaccionDTO> findAll();

}
