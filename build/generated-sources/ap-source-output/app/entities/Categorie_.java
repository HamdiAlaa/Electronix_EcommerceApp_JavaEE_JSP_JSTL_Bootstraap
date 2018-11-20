package app.entities;

import app.entities.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T14:19:55")
@StaticMetamodel(Categorie.class)
public class Categorie_ { 

    public static volatile CollectionAttribute<Categorie, Produit> produitCollection;
    public static volatile SingularAttribute<Categorie, Integer> quantiteRemise;
    public static volatile SingularAttribute<Categorie, Integer> id;
    public static volatile SingularAttribute<Categorie, String> nom;
    public static volatile SingularAttribute<Categorie, Integer> porcentage;

}