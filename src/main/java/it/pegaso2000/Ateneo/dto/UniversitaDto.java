package it.pegaso2000.Ateneo.dto;

import java.util.ArrayList;
import java.util.List;

public class UniversitaDto {
	
	private long id;
	private String nomeCitta;
	private boolean is_privata;
	private String nomeUniversita;
	
	private List<Long> dipartimenti;
	
	public UniversitaDto() {
		dipartimenti= new ArrayList<Long>();
	}
	
	
	public UniversitaDto(long id, String nomeCitta, boolean is_privata, List<Long> dipartimenti) {
		super();
		this.id = id;
		this.nomeCitta = nomeCitta;
		this.is_privata = is_privata;
		this.dipartimenti = dipartimenti;
	}




	public String getNomeUniversita() {
		return nomeUniversita;
	}


	public void setNomeUniversita(String nomeUniversita) {
		this.nomeUniversita = nomeUniversita;
	}


	public List<Long> getDipartimenti() {
		return dipartimenti;
	}
	public void setDipartimenti(List<Long> dipartimenti) {
		this.dipartimenti = dipartimenti;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeCitta() {
		return nomeCitta;
	}
	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}
	public boolean isIs_privata() {
		return is_privata;
	}
	public void setIs_privata(boolean is_privata) {
		this.is_privata = is_privata;
	}
	
}
