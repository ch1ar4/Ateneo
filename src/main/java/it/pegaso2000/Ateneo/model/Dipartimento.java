package it.pegaso2000.Ateneo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dipartimento")
public class Dipartimento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int numeroCorsi;
	
	@ManyToOne()
	@JoinColumn(name="universita_id")
	private Universita universita;
	
	@OneToMany(mappedBy = "dipartimento")
	private List<Studente> studenti;
	
	
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
	public int getNumeroCorsi() {
		return numeroCorsi;
	}
	public void setNumeroCorsi(int numeroCorsi) {
		this.numeroCorsi = numeroCorsi;
	}
	public Universita getUniversita() {
		return universita;
	}
	public void setUniversita(Universita universita) {
		this.universita = universita;
	}
	public List<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	
	

}

