package org.sid.service_compte.services;

import java.util.List;

import org.sid.service_compte.dao.AbonneRepository;
import org.sid.service_compte.entities.Abonne;
import org.sid.service_compte.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbonneeService {

	@Autowired
	AbonneRepository abonneRepository;
	
	public List<Abonne> findAllAbonnee()
	{
		//Récupération de l'Abonné
        List<Abonne> abonne=abonneRepository.findAll();
        //Recupération des Comptes de Abonnée
        return abonne;
    }
	
}
