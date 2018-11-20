/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alaa
 */
@Entity
@Table(name = "modifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modifications.findAll", query = "SELECT m FROM Modifications m")
    , @NamedQuery(name = "Modifications.findById", query = "SELECT m FROM Modifications m WHERE m.id = :id")
    , @NamedQuery(name = "Modifications.findByDateModif", query = "SELECT m FROM Modifications m WHERE m.dateModif = :dateModif")
    , @NamedQuery(name = "Modifications.findByTypeOperation", query = "SELECT m FROM Modifications m WHERE m.typeOperation = :typeOperation")})
public class Modifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "date_modif")
    private String dateModif;
    @Size(max = 255)
    @Column(name = "type_operation")
    private String typeOperation;
    @JoinColumn(name = "produit_fk", referencedColumnName = "id")
    @ManyToOne
    private Produit produitFk;

    public Modifications() {
    }

    public Modifications(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateModif() {
        return dateModif;
    }

    public void setDateModif(String dateModif) {
        this.dateModif = dateModif;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public Produit getProduitFk() {
        return produitFk;
    }

    public void setProduitFk(Produit produitFk) {
        this.produitFk = produitFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modifications)) {
            return false;
        }
        Modifications other = (Modifications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.Modifications[ id=" + id + " ]";
    }
    
}
