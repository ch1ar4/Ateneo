package it.pegaso2000.Ateneo.dto;

public class StudenteDto {
	private long id;
	private String nome;
	private String cognome;
	private int numeroMatricola;
	
	private long dipartimento;

	
	public StudenteDto(long id, String nome, String cognome, int numeroMatricola, long dipartimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroMatricola = numeroMatricola;
		this.dipartimento = dipartimento;
	}
	public long getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(long dipartimento) {
		this.dipartimento = dipartimento;
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
	

}
