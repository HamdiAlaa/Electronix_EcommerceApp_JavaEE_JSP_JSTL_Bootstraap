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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "propositions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propositions.findAll", query = "SELECT p FROM Propositions p")
    , @NamedQuery(name = "Propositions.findById", query = "SELECT p FROM Propositions p WHERE p.id = :id")
    , @NamedQuery(name = "Propositions.findByNomPrenom", query = "SELECT p FROM Propositions p WHERE p.nomPrenom = :nomPrenom")
    , @NamedQuery(name = "Propositions.findByEmail", query = "SELECT p FROM Propositions p WHERE p.email = :email")
    , @NamedQuery(name = "Propositions.findByPropositions", query = "SELECT p FROM Propositions p WHERE p.propositions = :propositions")
    , @NamedQuery(name = "Propositions.findByMotivation", query = "SELECT p FROM Propositions p WHERE p.motivation = :motivation")})
public class Propositions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomPrenom")
    private String nomPrenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "propositions")
    private String propositions;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "motivation")
    private String motivation;

    public Propositions() {
    }

    public Propositions(Integer id) {
        this.id = id;
    }

    public Propositions(Integer id, String nomPrenom, String email, String propositions, String motivation) {
        this.id = id;
        this.nomPrenom = nomPrenom;
        this.email = email;
        this.propositions = propositions;
        this.motivation = motivation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPropositions() {
        return propositions;
    }

    public void setPropositions(String propositions) {
        this.propositions = propositions;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
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
        if (!(object instanceof Propositions)) {
            return false;
        }
        Propositions other = (Propositions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entities.Propositions[ id=" + id + " ]";
    }
    
}
