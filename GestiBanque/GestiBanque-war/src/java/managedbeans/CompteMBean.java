/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entity.CompteBancaire;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import session.GestionnaireDeCompteBancaire;

/**
 *
 * @author Utilisateur
 */
@ManagedBean
@ViewScoped
public class CompteMBean {
    
    GestionnaireDeCompteBancaire gestionnaireDeCompteBancaire;

    /**
     * Creates a new instance of CompteMBean
     */
    public CompteMBean() {
    }
    
    /** 
     * Renvoie la liste des clients pour affichage dans une DataTable 
     * @return 
     */  
    public List<CompteBancaire>getCustomers() {  
        return gestionnaireDeCompteBancaire.getAllComptes();  
    }  
  
    /** 
     * Action handler - appelé lorsque l'utilisateur sélectionne une ligne dans 
     * la DataTable pour voir les détails 
     */  
    public String showDetails(int compteId) {  
        return "CompteDetails?idCustomer=" + compteId;    } 
    
}
