package org.sid.service_compte.services;

import java.util.List;
import java.util.Optional;

import org.sid.service_compte.dao.AbonneRepository;
import org.sid.service_compte.dao.CarteBancaireRepository;
import org.sid.service_compte.dao.CompteRepository;
import org.sid.service_compte.dao.OperationRepository;
import org.sid.service_compte.entities.Abonne;
import org.sid.service_compte.entities.CarteBancaire;
import org.sid.service_compte.entities.Compte;
import org.sid.service_compte.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CompteService {
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	AbonneRepository abonneRepository;
	
	@Autowired
	CarteBancaireRepository carteBancaireRepository;
	public List<Compte> findAllAccounts(Long id)
	{
        Abonne abonne=abonneRepository.getOne(id);
       return (List<Compte>) abonne.getComptes();
    }
	public List<Operation> findAllOperations(Long idCompte)
	{
		Compte compte =compteRepository.getOne(idCompte);
		return compte.getOperations();
	}
	public CarteBancaire findAllCarteBancaire(Long idCompte)
	{
		Compte compte =compteRepository.getOne(idCompte);
		return  compte.getCarteBancaire();
	}
	public void DesactiveEtatCarte(String idCarte)
	{
		CarteBancaire carte = carteBancaireRepository.getOne(idCarte);
		
		 carte.setEtat("desactiver");
		
		 carteBancaireRepository.save(carte);
			
			
	}
	public void ActiveEtatCarte(String idCarte)
	{
		CarteBancaire carte = carteBancaireRepository.getOne(idCarte);
		
		 carte.setEtat("active");
		
		 carteBancaireRepository.save(carte);
			
			
	}


}
