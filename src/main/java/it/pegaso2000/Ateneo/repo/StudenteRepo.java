package it.pegaso2000.Ateneo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pegaso2000.Ateneo.model.Studente;

public interface StudenteRepo extends JpaRepository<Studente, Long>{

}
