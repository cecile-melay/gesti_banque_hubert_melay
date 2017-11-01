/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author mbuffa
 */
@Entity
public class OperationBancaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateoperation;
    private String description;
    private double montant;

    public OperationBancaire() {
    }
    
    public OperationBancaire(String description, double montant) {
        dateoperation = new Date();
        this.description = description;
        this.montant = montant;
    }

    public Date getDateoperation() {
        return dateoperation;
    }

    public void setDateoperation(Date dateoperation) {
        this.dateoperation = dateoperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(object instanceof OperationBancaire)) {
            return false;
        }
        OperationBancaire other = (OperationBancaire) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OperationBancaire[ id=" + id + " ]";
    }
    
}
