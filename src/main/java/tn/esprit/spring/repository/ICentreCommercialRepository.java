package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CentreCommercial;
@Repository
public interface ICentreCommercialRepository extends JpaRepository<CentreCommercial, Long> {

}
