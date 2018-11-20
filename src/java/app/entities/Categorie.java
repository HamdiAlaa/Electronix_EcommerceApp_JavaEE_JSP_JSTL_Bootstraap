/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alaa
 */
@Entity
@Table(name = "categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c")
    , @NamedQuery(name = "Categorie.findById", query = "SELECT c FROM Categorie c WHERE c.id = :id")
    , @NamedQuery(name = "Categorie.findByNom", query = "SELECT c FROM Categorie c WHERE c.nom = :nom")
    , @NamedQuery(name = "Categorie.findByPorcentage", query = "SELECT c FROM Categorie c WHERE c.porcentage = :porcentage")
    , @NamedQuery(name = "Categorie.findByQuantiteRemise", query = "SELECT c FROM Categorie c WHERE c.quantiteRemise = :quantiteRemise")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @Column(name = "porcentage")
    private Integer porcentage;
    @Column(name = "quantite_remise")
    private Integer quantiteRemise;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieFk")
    private Collection<Produit> produitCollection;

    public Categorie() {
    }

    public Categorie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPorcentage() {
        return porcentage;
    }

    public void setPorcentage(Integer porcentage) {
        this.porcentage = porcentage;
    }

    public Integer getQuantiteRemise() {
        return quantiteRemise;
    }

    public void setQuantiteRemise(Integer quantiteRemise) {
        this.quantiteRemise = quantiteRemise;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
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
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.Categorie[ id=" + id + " ]";
    }
    
}
