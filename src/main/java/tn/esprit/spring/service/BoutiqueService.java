package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.repository.IBoutiqueRepository;
import tn.esprit.spring.repository.ICentreCommercialRepository;


@Service
public class BoutiqueService implements IBoutiqueService{

	@Autowired
	IBoutiqueRepository boutiqueRepository ;
	@Autowired
	ICentreCommercialRepository centreRepository ;

	@Override
	public void ajouterEtaffecterListeboutique(List<Boutique> lb, Long idCentre) {
		
		boutiqueRepository.saveAll(lb) ;//saveall leliste 
	CentreCommercial centre =centreRepository.findById(idCentre).orElse(null);	//recuperer centre commercial by id 
	for(Boutique boutique : lb){
	boutique.setCentreCommercial(centre);	//affecter chaque boutique dans un centre
	}
	boutiqueRepository.saveAll(lb) ; // enregister la liste des boutique dans la bd
	}

	@Override
	public List<Boutique> listedeBoutiques(Long idCentre) {
	CentreCommercial centre =centreRepository.findById(idCentre).orElse(null);	// recuperer centre selon id 
		
			return boutiqueRepository.findByCentreCommercial(centre) ; //appelmethode lelrepository
	}

}
