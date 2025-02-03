package com.example.demo.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Articulo;
import com.example.demo.repository.entity.ArticuloTransaccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ArticuloRepository extends JpaRepository <Articulo, Long> {
	 @Query(value = "select * from articulos where tipo='Camisa' or tipo='chaqueta' or tipo = tipo='pantalon' or tipo = ' baño' or tipo='falda' or tipo='jersey' or tipo ='sudadera' or tipo='vestido';", nativeQuery = true)
	 public  List<Articulo> findAllByRopa();
	 @Query(value = "select * from articulos where tipo='bolso' or tipo='bufanda' or tipo = tipo='cinturon' or tipo = 'corbata' or tipo='gorra' or tipo='guantes';", nativeQuery = true)
	 public  List<Articulo> findAllByComplementos();
	 @Query(value = "select * from articulos where tipo='zapatos';", nativeQuery = true)
	 public  List<Articulo> findAllByZapatos();
	 
	 @Query(value = "select * from articulos where tipo=:tipoR;", nativeQuery = true)
	 public  List<Articulo> findAllByTipo(@Param("tipoR") String tipoR);

}
