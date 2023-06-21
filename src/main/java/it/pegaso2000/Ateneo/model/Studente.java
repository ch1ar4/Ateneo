package it.pegaso2000.Ateneo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="studente")
public class Studente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cognome;
	private int numeroMatricola;
	
	@ManyToOne()
	@JoinColumn(name="dipartimento_id")
	private Dipartimento dipartimento;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getNumeroMatricola() {
		return numeroMatricola;
	}
	public void setNumeroMatricola(int numeroMatricola) {
		this.numeroMatricola = numeroMatricola;
	}
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	
}
