package com.example.demo.repository.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.ClienteRegalo;
import com.example.demo.repository.entity.Transaccion;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
	
	@Query(value = "select t.* from transacciones t join compras c on c.id_transaccion=t.id join usuarios u on c.id_usuario=u.id "
			+ "where t.estado ='inicial' and u.nombre_usuario :=nombreUsuario", nativeQuery = true) 
	Optional<Transaccion> findByNombreUsuarioEstadoInicial(@Param("nombreUsuario") String nombreUsuario);  
}
