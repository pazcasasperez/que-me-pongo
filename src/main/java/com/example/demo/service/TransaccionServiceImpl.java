package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.repository.dao.TransaccionRepository;
import com.example.demo.repository.entity.Transaccion;
import com.example.demo.web.controller.ArticuloController;

@Service
public class TransaccionServiceImpl implements TransaccionService {
    private static final Logger log = LoggerFactory.getLogger(ArticuloController.class);

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public List<TransaccionDTO> findAll() {
        log.info(TransaccionRepository.class.getSimpleName() + "  -- Cambio a dto");

        List<Transaccion> listaTransaccion = transaccionRepository.findAll();
        List<TransaccionDTO> listaTransaccionDTO = new ArrayList<TransaccionDTO>();
        for (Transaccion a : listaTransaccion) {
            listaTransaccionDTO.add(TransaccionDTO.convertToDTO(a));
        }

        return listaTransaccionDTO;
    }

}
