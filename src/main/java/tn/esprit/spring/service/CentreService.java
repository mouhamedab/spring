package tn.esprit.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.CentreCommercial;
import tn.esprit.spring.repository.IBoutiqueRepository;
import tn.esprit.spring.repository.ICentreCommercialRepository;

public class CentreService implements ICentreService  {
	@Autowired
	IBoutiqueRepository boutiqueRepository ;
	@Autowired
	ICentreCommercialRepository centreRepository ;
	

	@Override
	public void ajouCentre(CentreCommercial centre) {
		Boutique boutique =saveboutique (centre) ;//nouveau boutique de type Boutique = une methode depend de centre
		boutique.setCentreCommercial(centre);//affecter((set)) le boutique ajouté au centre commerciale
		centreRepository.save(centre) ; //ajouter (save)centre avec la boutique dans la DB
	}


	private Boutique saveboutique(CentreCommercial centre) {
Set<Boutique>boutiques =(Set<Boutique>)centre.getBoutiques();//liste des boutique dans le centre
for (Boutique boutique : boutiques) {
return boutiqueRepository.save(boutique )	;	//ajouter boutique ((save))
}
		return null;
	}
	

}
