package org.sid.service_compte.web;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.sid.service_compte.entities.Abonne;
import org.sid.service_compte.entities.CarteBancaire;
import org.sid.service_compte.entities.Compte;
import org.sid.service_compte.entities.Operation;
import org.sid.service_compte.services.AbonneeService;
import org.sid.service_compte.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/compte")
@CrossOrigin
public class CompteController {

	@Autowired
	CompteService compteService;
	@Autowired
	AbonneeService abonneeService;

   @RequestMapping(value="/AccountAbonne/{id}", method=RequestMethod.GET)
    public List<Compte> getAllAccounts(@PathVariable long id)
    {
        return compteService.findAllAccounts(id);
    }
    
    @GetMapping("/Abonne")
    List<Abonne> getAbonnee()
    {
    	List<Abonne> a = abonneeService.findAllAbonnee();
        return a;
    }
    @RequestMapping(value="/AccountOperation/{idCompte}", method=RequestMethod.GET)
    List<Operation> getOperation(@PathVariable long idCompte)
    {
    	return compteService.findAllOperations(idCompte);
    }
    @RequestMapping(value="/AccountCarteBancaire/{idCompte}", method=RequestMethod.GET)
    CarteBancaire getCarteBancaire(@PathVariable long idCompte)
    {
    	return compteService.findAllCarteBancaire(idCompte);
    }
    @RequestMapping(value="/DesactiverEtatCarteBancaire/{idCarteBancaire}", method=RequestMethod.POST)
    public void DesactiverEtatCarte (@PathVariable String idCarteBancaire)
    {
    	
    	 compteService.DesactiveEtatCarte(idCarteBancaire);
    }
    @RequestMapping(value="/ActiverEtatCarteBancaire/{idCarteBancaire}", method=RequestMethod.POST)
    public void ActiverEtatCarte (@PathVariable String idCarteBancaire)
    {
    	
    	 compteService.ActiveEtatCarte(idCarteBancaire);
    }
}
