package com.prueba.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.modelo.Reporte;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Reporte, Integer>{

	@Query("SELECT r, u "
			+ "FROM Reporte r "
			+ "INNER JOIN r.usuario u WHERE u.id = :idus")
	List<Reporte> findReporteByUsuario(@Param("idus") int idus);	
}
