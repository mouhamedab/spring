package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.service.IClientService;
@RestController
//@Api(tags = "Gestion des examens")
@RequestMapping("/examen")
public class ClientRestController {
	@Autowired
	IClientService clientService ;
    //http://localhost:8087/SpringMVC/swagger-ui/index.html
	
	@PostMapping("/add-Client") //ajout
	@ResponseBody
	public void ajouterEtAffecterClientBoutiques(@RequestBody Client client,@RequestParam(value="idBoutiques") List<Long> idBoutiques) {

	
clientService.ajouterEtAffecterClientBoutiques(client, idBoutiques);

	}
}
