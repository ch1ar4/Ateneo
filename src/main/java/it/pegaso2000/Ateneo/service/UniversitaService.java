package it.pegaso2000.Ateneo.service;

import java.util.List;

import it.pegaso2000.Ateneo.dto.UniversitaDto;


public interface UniversitaService {
	List<UniversitaDto> findAll();
	UniversitaDto findById(long id);
	UniversitaDto save(UniversitaDto dto);
	boolean delete(long id);

}
