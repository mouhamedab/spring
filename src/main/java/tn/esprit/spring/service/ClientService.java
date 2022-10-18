package tn.esprit.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Genre;
import tn.esprit.spring.repository.IBoutiqueRepository;
import tn.esprit.spring.repository.IClientRepository;
@Service
public class ClientService implements IClientService {
@Autowired
	IClientRepository clientRepository ;
@Autowired
    IBoutiqueRepository boutiqueRepository ;
	@Override
	public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) { //save loula o tparcoury thenya	
		// TODO Auto-generated method stub
		clientRepository.save(client) ; //ajouter client
		List<Boutique> boutiques =boutiqueRepository.findAll();//recuperer list boutique
	for(Long id : idBoutiques){ 
		Boutique b =boutiqueRepository.findById(id).orElse(null) ;// id mawjoud wle
		b.getClients().add(client); //affecter idclent en liste boutique
		clientRepository.save(client);	
	}
	}
	@Override
	public List<Client> listedeClients(Long idBoutique) {

		return clientRepository.findByBoutiquesId(idBoutique);
	}
	@Override
	public List<Client> listeDeClientsParCategorie(Categorie categorie) {
		
		return clientRepository.findByBoutiquesCategorie(categorie);
	}
	
	//service shedulee
	
@Scheduled(cron ="*/30 * * * * *")
	@Override
	public void nbreClientParGenre() {
	int nbrF=clientRepository.getClientByGenre(Genre.FEMININ);
	int nbrm=clientRepository.getClientByGenre(Genre.MASCULIN);
		System.out.println("masculin "+ nbrm);
		System.out.println("feemme "+ nbrF);
	}


}
