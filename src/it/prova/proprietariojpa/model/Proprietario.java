package it.prova.proprietariojpa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "cf")
	private String cf;
	@Column(name = "dataDiNascita")
	private LocalDate dataDiNascita;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietario")
	private Set<Automobile> automobili = new HashSet<>();
	
	

	public Proprietario() {
		super();
	}
	
	

	public Proprietario(String nome, String cognome, String cf, LocalDate dataDiNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.dataDiNascita = dataDiNascita;
	}

	


	public Proprietario(String nome, String cognome, String cf, LocalDate dataDiNascita, Set<Automobile> automobile) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.dataDiNascita = dataDiNascita;
		this.automobili = automobile;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Set<Automobile> getAutomobile() {
		return automobili;
	}

	public void setAutomobile(Set<Automobile> automobile) {
		this.automobili = automobile;
	}
	public void setAutomobile(Automobile automobile) {
		this.automobili.add(automobile);
	}

}
