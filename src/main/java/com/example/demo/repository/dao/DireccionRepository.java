package com.example.demo.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Direccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
