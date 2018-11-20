package app.entities;

import app.entities.Categorie;
import app.entities.Modifications;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T14:19:55")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile CollectionAttribute<Produit, Modifications> modificationsCollection;
    public static volatile SingularAttribute<Produit, Float> prix;
    public static volatile SingularAttribute<Produit, String> imageUrl;
    public static volatile SingularAttribute<Produit, String> description;
    public static volatile SingularAttribute<Produit, Integer> id;
    public static volatile SingularAttribute<Produit, String> nom;
    public static volatile SingularAttribute<Produit, Categorie> categorieFk;
    public static volatile SingularAttribute<Produit, Integer> quantite;

}