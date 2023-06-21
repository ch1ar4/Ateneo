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

import it.pegaso2000.Ateneo.dto.StudenteDto;
import it.pegaso2000.Ateneo.service.StudenteService;

@RestController
@RequestMapping("/api/studente")
public class StudenteController {
	private StudenteService service;

	@Autowired
	public StudenteController(StudenteService service) {
		super();
		this.service = service;
	}

//findAll
	@GetMapping("all")
	public List<StudenteDto> findAll() {
		return service.findAll();
	}

	// findById
	@GetMapping("getById/{id}")
	public StudenteDto findById(@PathVariable long id) {
		return service.findById(id);
	}

	// save
	@PostMapping("save")
	public StudenteDto save(@RequestBody StudenteDto stu) {
		return service.save(stu);
	}

	// delete
	@DeleteMapping("delete/{id}")
	public boolean delete(@PathVariable long id) {
		return service.delete(id);
	}

	// update
	@PutMapping("update/{id}")
	public StudenteDto update(@PathVariable long id, @RequestBody StudenteDto updated) {
		StudenteDto dto = service.findById(id); // new UniversitaDto();
//		dto=service.findById(id);
//		updated=service.findById(id);
		if (dto != null) {
			updated.setId(id);
			service.save(updated);
			return updated;

		}
		return null;
	}

}
