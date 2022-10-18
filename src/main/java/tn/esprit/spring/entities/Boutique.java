package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Boutique  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue( strategy =GenerationType.IDENTITY)
private Long id ;
private String nom ;
@Enumerated(EnumType.STRING)
@JsonIgnore
private Categorie categorie  ;
@ManyToOne
@JsonIgnore //afficchage 
private CentreCommercial centreCommercial ;
@ManyToMany
private Set<Client> Clients ;


}
