/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.OperationBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.GestionnaireDeComptebancaires;

/**
 *
 * @author mbuffa
 */
@Named(value = "operationsBancairesMBean")
@ViewScoped
public class OperationsBancairesMBean implements Serializable {

    @EJB
    private GestionnaireDeComptebancaires gc;

    private int idCompte;

    /**
     * Get the value of idCompte
     *
     * @return the value of idCompte
     */
    public int getIdCompte() {
        System.out.println("GET ID COMPTE : " + idCompte);
        return idCompte;
    }

    /**
     * Set the value of idCompte
     *
     * @param idCompte new value of idCompte
     */
    public void setIdCompte(int idCompte) {
        System.out.println("SET ID COMPTE : " + idCompte);

        this.idCompte = idCompte;
    }

    /**
     * Creates a new instance of OperationsBancairesMBean
     */
    public OperationsBancairesMBean() {
        System.out.println("NEW OperationsBancairesMBean");
}

// COMMAND ACTION METHOD
public List<OperationBancaire> getOperationsBancaires() {
        return gc.getOperationsBancaires(idCompte);
    }
    
}
