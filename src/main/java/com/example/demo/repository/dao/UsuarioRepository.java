package com.example.demo.repository.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Usuario;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = " select u.* from usuarios u where nombre_usuario=:usuario and password=:pass", nativeQuery = true)
	Set<Usuario> login(@Param("usuario") String usuario, @Param("pass") String pass);
}
