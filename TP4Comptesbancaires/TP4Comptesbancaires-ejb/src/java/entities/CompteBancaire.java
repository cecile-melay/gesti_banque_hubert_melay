/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author mbuffa
 */
@Entity
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomProprietaire;
    private double solde;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OrderBy("dateoperation ASC")
    private List<OperationBancaire> listeOperations = new ArrayList();
    String description;
    
    public CompteBancaire() {

    }

    public CompteBancaire(String nom, double solde) {
        this.nomProprietaire = nom;
        this.solde = solde;
        
        // Operation = création
        addOperation("Création du compte", solde);
    }

    public void addOperation(String description, double montant) {
        OperationBancaire op = new OperationBancaire(description, montant);
        listeOperations.add(op);
    }
    
    /**
     * Get the value of solde
     *
     * @return the value of solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Set the value of solde
     *
     * @param solde new value of solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nomProprietaire;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nomProprietaire = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public List<OperationBancaire> getListeOperations() {
        return listeOperations;
    }

    public void crediter(double montant) {
        solde += montant;
        addOperation("Crédit de " + montant, montant);
    }

    public void debiter(double montant) {
        if (solde < montant) {
            throw new EJBException();
        } else {
            solde -= montant;
            addOperation("Débit de " + montant, montant);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompteBancaire[ id=" + id + " ]";
    }

}
