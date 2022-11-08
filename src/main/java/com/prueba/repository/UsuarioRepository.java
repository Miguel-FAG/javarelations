package com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	/*@Query("select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1")
	List<Document> findDocumentsForListing(String filterValue);*/
}
