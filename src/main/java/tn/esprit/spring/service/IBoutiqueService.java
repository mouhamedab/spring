package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Boutique;

public interface IBoutiqueService {
	
	
	void ajouterEtaffecterListeboutique (List<Boutique> lb, Long idCentre);
	List<Boutique> listedeBoutiques(Long idCentre) ;
}
