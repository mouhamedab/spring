package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Genre;


@Repository
public interface IClientRepository extends JpaRepository<Client,Long>{
	//boutiques : liste boutique fl client 
	List<Client> findByBoutiquesId (Long idBoutique);//afficher liste boutique dima majuscule carac loula
	
	
//	List<Client> listeDeClientsParCategorie(Categorie categorie)
	List<Client>findByBoutiquesCategorie(Categorie categorie) ;
int getClientByGenre(@Param("genre") Genre genre ) ;


}
