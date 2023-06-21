package it.pegaso2000.Ateneo.dto;

import java.util.ArrayList;
import java.util.List;

public class DipartimentoDto {
	private long id;
	private String nome;
	private int numeroCorsi;
	
	private long universita;
	
    private List<Long> studenti;
	
    public DipartimentoDto() {
		studenti= new ArrayList<>();
	}
	
	public DipartimentoDto(long id, String nome, int numeroCorsi, long universita) {
		super();
		this.id = id;
		this.nome = nome;
		this.numeroCorsi = numeroCorsi;
		this.universita = universita;
		
	}
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
	public long getUniversita() {
		return universita;
	}
	public void setUniversita(long universita) {
		this.universita = universita;
	}
	public List<Long> getStudenti() {
		return studenti;
	}
	public void setStudenti(List<Long> studenti) {
		this.studenti = studenti;
	}
	
	
	
}
