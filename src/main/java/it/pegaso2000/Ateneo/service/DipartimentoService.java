package it.pegaso2000.Ateneo.service;

import java.util.List;

import it.pegaso2000.Ateneo.dto.DipartimentoDto;



public interface DipartimentoService {

	List<DipartimentoDto> findAll();
	DipartimentoDto findById(long id);
	DipartimentoDto save(DipartimentoDto dto);
	boolean delete(long id);
}
