package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.model.dto.ArticuloTransaccionDTO;
import com.example.demo.model.dto.TransaccionDTO;
import com.example.demo.repository.dao.ArticuloTransaccionRepository;
import com.example.demo.repository.dao.TransaccionRepository;
import com.example.demo.repository.entity.ArticuloTransaccion;
import com.example.demo.repository.entity.Transaccion;
import com.example.demo.service.mapper.PagoMapper;
import com.example.demo.service.mapper.TransaccionMapper;
import com.example.demo.web.controller.ArticuloController;

@Service
public class TransaccionServiceImpl implements TransaccionService {
    private static final Logger log = LoggerFactory.getLogger(ArticuloController.class);

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private ArticuloTransaccionRepository articuloTransaccionRepository;

    @Override
    public List<TransaccionDTO> findAll() {
        log.info(TransaccionRepository.class.getSimpleName() + "  -- Cambio a dto");

        List<Transaccion> listaTransaccion = transaccionRepository.findAll();
        List<TransaccionDTO> listaTransaccionDTO = new ArrayList<TransaccionDTO>();
        for (Transaccion a : listaTransaccion) {
        	//listaTransaccionDTO.add(TransaccionMapper.INSTACE.toDTO(a));
            listaTransaccionDTO.add(TransaccionDTO.convertToDTO(a));
        }

        return listaTransaccionDTO;
    }

    @Override
    public List<ArticuloTransaccionDTO> findByArticulo(ArticuloDTO articuloDTO) {
        log.info(ArticuloTransaccionRepository.class.getSimpleName() + "  -- Cambio a dto");

        List<ArticuloTransaccion> listaArticuloTransaccion = articuloTransaccionRepository.findByArticulo(articuloDTO.getId());
        List<ArticuloTransaccionDTO> listaArticuloTransaccionDTO = new ArrayList<ArticuloTransaccionDTO>();
        for (ArticuloTransaccion a : listaArticuloTransaccion) {
            listaArticuloTransaccionDTO.add(ArticuloTransaccionDTO.convertToDTO(a));
        }   

        
        

        return listaArticuloTransaccionDTO;
        
    }

    

}
