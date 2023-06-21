package it.pegaso2000.Ateneo.service;

import java.util.List;

import it.pegaso2000.Ateneo.dto.StudenteDto;



public interface StudenteService {
	List<StudenteDto> findAll();
	StudenteDto findById(long id);
	StudenteDto save(StudenteDto dto);
	boolean delete(long id);
}
