package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.ArticuloTransaccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ArticuloTransaccionRepository extends JpaRepository<ArticuloTransaccion, Long> {

    @Query(value = "select * from articulostransacciones where id_articulo = :idarticulo", nativeQuery = true)
   public  List<ArticuloTransaccion> findByArticulo(@Param("idarticulo") Long idArticulo);

}
