package it.pegaso2000.Ateneo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pegaso2000.Ateneo.dto.DipartimentoDto;
import it.pegaso2000.Ateneo.model.Dipartimento;
import it.pegaso2000.Ateneo.model.Studente;
import it.pegaso2000.Ateneo.repo.DipartimentoRepo;
import it.pegaso2000.Ateneo.repo.StudenteRepo;
import it.pegaso2000.Ateneo.repo.UniversitaRepo;

@Service
public class DipartimentoServiceImplementation implements DipartimentoService {

	private DipartimentoRepo diprepo;
	private UniversitaRepo urepo;
	private StudenteRepo sturepo;

	public DipartimentoServiceImplementation(DipartimentoRepo diprepo, UniversitaRepo urepo, StudenteRepo sturepo) {
		super();
		this.diprepo = diprepo;
		this.urepo = urepo;
		this.sturepo = sturepo;
	}

	@Override
	public List<DipartimentoDto> findAll() {
		List<DipartimentoDto> result = new ArrayList<DipartimentoDto>();// lista stagioni convertite in DTO
		List<Dipartimento> list = diprepo.findAll();// lista delle stagioni nel DATABASE

		for (Dipartimento d : list) {
			result.add(entityToDto(d));
		}
		return result;
	}

	@Override
	public DipartimentoDto findById(long id) {
		Optional<Dipartimento> d = diprepo.findById(id);
		if (d.isPresent()) {
			return entityToDto(d.get());
		}
		return null;
	}

	@Override
	public DipartimentoDto save(DipartimentoDto dto) {
		Dipartimento entity = dtoToEntity(dto);

		return entityToDto(entity);
	}

	@Override
	public boolean delete(long id) {
		Optional<Dipartimento> entity = diprepo.findById(id);
		if (entity.isPresent())
			diprepo.deleteById(id);
		return false;
	}

	// entityToDto
	public DipartimentoDto entityToDto(Dipartimento dip) {
		DipartimentoDto dto = new DipartimentoDto();
		dto.setId(dip.getId());
		dto.setNome(dip.getNome());
		dto.setNumeroCorsi(dip.getNumeroCorsi());

		dto.setUniversita(dip.getUniversita().getId());

		if (dip.getStudenti() != null) {
			for (Studente stud : dip.getStudenti()) {
				dto.getStudenti().add(stud.getId());
			}
		}
		return dto;
	}

	public Dipartimento dtoToEntity(DipartimentoDto dto) {
		Dipartimento dip = new Dipartimento();

		dip.setId(dto.getId());
		dip.setNome(dto.getNome());
		dip.setNumeroCorsi(dto.getNumeroCorsi());

		dip.setUniversita(urepo.findById(dto.getUniversita()).get());

		if (dto.getStudenti() != null) {
			for (long id : dto.getStudenti()) {
				Studente entity = sturepo.findById(id).get();
				dip.getStudenti().add(entity);
			}
		}
		return dip;

	}

}
