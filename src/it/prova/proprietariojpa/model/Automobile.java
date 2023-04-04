package it.prova.proprietariojpa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Automobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "targa")
	private String targa;
	@Column(name = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;
	
	
	
	
	public Automobile(String marca, String modello, String targa) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
	}
	public Automobile(String marca, String modello, String targa, Proprietario proprietario) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.proprietario = proprietario;
	}
	public Automobile() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	
}
