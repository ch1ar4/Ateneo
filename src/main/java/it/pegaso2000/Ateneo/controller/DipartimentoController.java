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

import it.pegaso2000.Ateneo.dto.DipartimentoDto;
import it.pegaso2000.Ateneo.service.DipartimentoService;

@RestController
@RequestMapping("api/dipartimento")
public class DipartimentoController {
	private DipartimentoService service;
	@Autowired
	public DipartimentoController(DipartimentoService service) {
		super();
		this.service = service;
	}

	@GetMapping("all")
	public List<DipartimentoDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping("getById")
	public DipartimentoDto findById(@PathVariable long id) {
		return service.findById(id);
	}
	
	@PostMapping("save")
	public DipartimentoDto  save(@RequestBody DipartimentoDto dip) {
		return service.save(dip);
	}
	
	//delete
	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable long id) {
		return service.delete(id);
	}
	
	
	//update
	@PutMapping("update/{id}")
	public DipartimentoDto  update(@PathVariable long id,@RequestBody DipartimentoDto  updated) {
		DipartimentoDto  dto =service.findById(id); //new UniversitaDto();
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
