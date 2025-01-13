package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.PagoDTO;
import com.example.demo.repository.dao.PagoRepository;
import com.example.demo.repository.entity.Pago;

@Service
public class PagoServiceImpl implements PagoService {
	@Autowired
	private PagoRepository pagoRepository;
	private static final Logger log = LoggerFactory.getLogger(PagoServiceImpl.class);


	@Override
	public List<PagoDTO> findAll() {
		log.info(PagoServiceImpl.class.getSimpleName() + " -- Solicitamos la lista de articulos al servicio");
		
		List<Pago> listaPagos = pagoRepository.findAll();
		List<PagoDTO> listaPagosDTO = new ArrayList<PagoDTO>();
		log.info("             cantidad pagos " + listaPagos.size());
		for(Pago p : listaPagos) {
			listaPagosDTO.add(PagoDTO.convertToDTO(p));
		}
		
		return listaPagosDTO;
	}

}
