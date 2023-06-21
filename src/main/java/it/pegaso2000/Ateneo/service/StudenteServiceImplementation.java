package it.pegaso2000.Ateneo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import it.pegaso2000.Ateneo.dto.StudenteDto;

import it.pegaso2000.Ateneo.model.Studente;
import it.pegaso2000.Ateneo.repo.DipartimentoRepo;
import it.pegaso2000.Ateneo.repo.StudenteRepo;
@Service
public class StudenteServiceImplementation implements StudenteService {
	
	private StudenteRepo srepo;
	private DipartimentoRepo diprepo;

	@Override
	public List<StudenteDto> findAll() {
		List<StudenteDto> result= new ArrayList<StudenteDto>();//lista stagioni convertite in DTO 
		List<Studente> list = srepo.findAll();//lista delle stagioni nel DATABASE
		
		for (Studente s : list) {
			result.add(entityToDto(s));
		}
		return result;
	}

	@Override
	public StudenteDto findById(long id) {
		Optional<Studente> d = srepo.findById(id);
		if(d.isPresent()) {
			return entityToDto(d.get());
		}
		return null;
	}

	@Override
	public StudenteDto save(StudenteDto dto) {
		Studente entity=dtoToEntity(dto);
		return entityToDto(entity);
	}

	@Override
	public boolean delete(long id) {
		Optional<Studente> entity=srepo.findById(id);
		if(entity.isPresent())
			srepo.deleteById(id);
		return false;
	}

	public StudenteDto entityToDto(Studente stu) {
		StudenteDto dto = new StudenteDto(stu.getId(), stu.getNome(),stu.getCognome(), stu.getNumeroMatricola(),stu.getDipartimento().getId() );
		return dto;
		
	}
	
	//dtoToEntity
	public Studente dtoToEntity(StudenteDto dto) {
		Studente entity= new Studente();
		entity.setId(dto.getId());
		entity.setNome(dto.getNome());
		entity.setCognome(dto.getCognome());
		entity.setNumeroMatricola(dto.getNumeroMatricola());
		
		entity.setDipartimento(diprepo.findById(dto.getDipartimento()).get());
		
		return entity;
		
		
	}
	
	
}
