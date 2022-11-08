package com.prueba.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
	private Set<Reporte> reportes = new HashSet<>();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Reporte> getReportes() {
		return reportes;
	}

	public void setReportes(Set<Reporte> reportes) {
		this.reportes = reportes;
		
		for(Reporte reporte: reportes) {
			reporte.setUsuario(this);
		}
	}
}
