package com.example.demo.service;

import java.util.List;


import com.example.demo.model.dto.TransaccionDTO;

public interface TransaccionService {

    List<TransaccionDTO> findAll();

}
