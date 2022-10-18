package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;

public interface IClientService {
	void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) ;
	List<Client> listedeClients(Long idBoutique) ;
	List<Client> listeDeClientsParCategorie(Categorie categorie);
	void nbreClientParGenre() ;
}
