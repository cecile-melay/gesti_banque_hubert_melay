/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.CompteBancaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mbuffa
 */
@Stateless
@LocalBean
public class GestionnaireDeComptebancaires {
    
    @PersistenceContext
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public GestionnaireDeComptebancaires() {
        
    }

    // Fait un insert d'un compte bancaire (entité) dans la base
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }
    
    public void creerComptesDeTest() {
        creerCompte(new CompteBancaire("John Lennon", 150000));
        creerCompte(new CompteBancaire("Paul McCartney", 950000));
        creerCompte(new CompteBancaire("Ringo Starr", 20000));
        creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }
    
    public List<CompteBancaire> findAll() {
        Query q = em.createQuery("select c from CompteBancaire c");
        return q.getResultList();
    }
    
    public void crediterUnCompte(int id, double montant) {
        // On va chercher un compte dans la base, il est connecté
        CompteBancaire c = em.find(CompteBancaire.class, id);
        // On update juste en faisant solde+=montant
        c.crediter(montant);
    }
    
    public void debiterUnCompte(int id, double montant) {
        // On va chercher un compte dans la base, il est connecté
        CompteBancaire c = em.find(CompteBancaire.class, id);
        // On update juste en faisant solde-=montant
        c.debiter(montant);
    }
    
    public void transferer(int id1, int id2, double montant) {
        debiterUnCompte(id1, montant);
        crediterUnCompte(id2, montant);
    }
    
    public void persist(Object object) {
        em.persist(object);
    }
}
