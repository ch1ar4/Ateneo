 package it.pegaso2000.Ateneo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pegaso2000.Ateneo.dto.UniversitaDto;
import it.pegaso2000.Ateneo.model.Universita;
import it.pegaso2000.Ateneo.service.UniversitaService;

@RestController
@RequestMapping("api/universita")
public class UniversitaController {
	
	private UniversitaService service;

	@Autowired
	public UniversitaController(UniversitaService service) {
		super();
		this.service = service;
	}
	
	
	//findAll
	@GetMapping("all")
	public List<UniversitaDto> findAll(){
		return service.findAll();
	}
	
	//findById
	@GetMapping("getById/{id}")
	public UniversitaDto findById(@PathVariable long id) {
		return service.findById(id);
	}
	
	//save
	@PostMapping("save")
	public UniversitaDto save(@RequestBody UniversitaDto uni) {
		return service.save(uni);
	}
	
	//delete
	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable long id) {
		return service.delete(id);
	}
	
	
	//update
	@PutMapping("update/{id}")
	public UniversitaDto update(@PathVariable long id,@RequestBody UniversitaDto updated) {
		UniversitaDto dto =service.findById(id); //new UniversitaDto();
//		dto=service.findById(id);
//		updated=service.findById(id);
		if(dto!=null) {
			updated.setId(id);
			service.save(updated);
			return updated;

		}
		return null;
	}
	
}
