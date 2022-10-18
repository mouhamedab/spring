package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CentreCommercial implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy =GenerationType.IDENTITY)
	private Long id ;
	private String Adresse ;
	private String Login ;
	private String Password ;
	@OneToMany(mappedBy ="CentreCommercial")
	private Set <Boutique> Boutiques ;

}
