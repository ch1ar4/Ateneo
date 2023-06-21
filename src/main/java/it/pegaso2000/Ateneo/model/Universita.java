package it.pegaso2000.Ateneo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="universita")
public class Universita {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nomeUniversita;
	private String nomeCitta;
	private boolean is_privata;
	
	@OneToMany(mappedBy="universita")
	private List<Dipartimento> dipartimenti;
	
	
	
	public String getNomeUniversita() {
		return nomeUniversita;
	}
	public void setNomeUniversita(String nomeUniversita) {
		this.nomeUniversita = nomeUniversita;
	}
	public List<Dipartimento> getDipartimenti() {
		return dipartimenti;
	}
	public void setDipartimenti(List<Dipartimento> dipartimenti) {
		this.dipartimenti = dipartimenti;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeCittà() {
		return nomeCitta;
	}
	public void setNomeCittà(String nomeCittà) {
		this.nomeCitta = nomeCittà;
	}
	public boolean isIs_privata() {
		return is_privata;
	}
	public void setIs_privata(boolean is_privata) {
		this.is_privata = is_privata;
	}
	public String getNomeCitta() {
		return nomeCitta;
	}
	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}
	public List<Dipartimento> getDipartimento() {
		return dipartimenti;
	}
	public void setDipartimento(List<Dipartimento> dipartimento) {
		this.dipartimenti = dipartimento;
	}
	

}
