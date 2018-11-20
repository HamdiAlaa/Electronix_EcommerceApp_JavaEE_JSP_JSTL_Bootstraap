package app.entities;

import app.entities.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T14:19:55")
@StaticMetamodel(Modifications.class)
public class Modifications_ { 

    public static volatile SingularAttribute<Modifications, String> typeOperation;
    public static volatile SingularAttribute<Modifications, Integer> id;
    public static volatile SingularAttribute<Modifications, String> dateModif;
    public static volatile SingularAttribute<Modifications, Produit> produitFk;

}