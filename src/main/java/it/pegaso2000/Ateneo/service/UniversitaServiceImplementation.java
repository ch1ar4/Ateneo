package it.pegaso2000.Ateneo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pegaso2000.Ateneo.dto.UniversitaDto;
import it.pegaso2000.Ateneo.model.Dipartimento;
import it.pegaso2000.Ateneo.model.Universita;
import it.pegaso2000.Ateneo.repo.DipartimentoRepo;
import it.pegaso2000.Ateneo.repo.UniversitaRepo;

@Service
public class UniversitaServiceImplementation implements UniversitaService {

	private UniversitaRepo urepo;
	private DipartimentoRepo drepo;

	@Autowired
	public UniversitaServiceImplementation(UniversitaRepo urepo, DipartimentoRepo drepo) {
		super();
		this.urepo = urepo;
		this.drepo = drepo;
	}

	@Override
	public List<UniversitaDto> findAll() {
		List<Universita> entity = urepo.findAll();
		List<UniversitaDto> dto = new ArrayList<UniversitaDto>();
		for (Universita universita : entity)
			dto.add(entityToDto(universita));
		return dto;

	}

	@Override
	public UniversitaDto findById(long id) {
		UniversitaDto dto = new UniversitaDto();
		Optional<Universita> uni = urepo.findById(id);
		if (uni.isPresent()) {
			return entityToDto(uni.get());
		}
		return dto;

	}

	@Override
	public UniversitaDto save(UniversitaDto dto) {
		Universita entity = dtoToEntity(dto);
		return entityToDto(urepo.save(entity));

	}

	@Override
	public boolean delete(long id) {
		Optional<Universita> entity = urepo.findById(id);
		if (entity.isPresent()) {
			urepo.deleteById(id);
			return true;
		}
		return false;
	}

	// metodo entity to Dto
	private UniversitaDto entityToDto(Universita uni) {
		UniversitaDto dto = new UniversitaDto();
		dto.setId(uni.getId());
		dto.setNomeCitta(uni.getNomeCitta());
		dto.setIs_privata(uni.isIs_privata());

		if (uni.getDipartimento() != null) {
			for (Dipartimento dip : uni.getDipartimento()) {
				dto.getDipartimenti().add(dip.getId());
			}
			
		}
		return dto;
	}

	// dtoToEntity
	private Universita dtoToEntity(UniversitaDto dto) {
		Universita uni = new Universita();
		uni.setId(dto.getId());
		uni.setNomeCitta(dto.getNomeCitta());
		uni.setIs_privata(dto.isIs_privata());

		if (dto.getDipartimenti() != null) {
			for (long id : dto.getDipartimenti()) {
				Dipartimento entity = drepo.findById(id).get();
				uni.getDipartimento().add(entity);
			}
		}
		return uni;
	}

}
