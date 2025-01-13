package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.Pago;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PagoRepository extends JpaRepository <Pago, Long>{

}
