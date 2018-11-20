package app.Controllers;

import app.entities.Produit;
import app.Controllers.util.JsfUtil;
import app.Controllers.util.PaginationHelper;
import app.ejbs.ProduitFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named("produitController")
@SessionScoped
public class ProduitController implements Serializable {

    private Produit current;
    private DataModel items = null;
    @EJB
    private app.ejbs.ProduitFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    public ProduitController() {
    }
    public List<Produit> getAll(){
        return getFacade().findAll();
    }
    public void trierParNom(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("valide", "parPrix");
        
    }
    public void trierParPrix(){

    }
    
    /*robotiquePage*/
    public List<Produit> getAllRobotiquesList(){
        List <Produit> all = new ArrayList<>();
        for(int i=0;i<this.getAll().size();i++){
            System.out.println("categorie est "+this.getAll().get(i).getId());
            if(this.getAll().get(i).getCategorieFk().getId() == 1 ){
                all.add(this.getAll().get(i));
        }    
    }
    return all;
    }
    
    /*Materiel Page*/
     public List<Produit> getAllMaterielList(){
        List <Produit> all = new ArrayList<>();
        for(int i=0;i<this.getAll().size();i++){
            if(getFacade().findAll().get(i).getCategorieFk().getId() == 2 ){
                all.add(getFacade().findAll().get(i));
        }    
    }
    return all;}
     
    /*eletronique Page*/
     public List<Produit> getAllElectriqueMaterielList(){
        List <Produit> all = new ArrayList<>();
        for(int i=0;i<this.getAll().size();i++){
            if(getFacade().findAll().get(i).getCategorieFk().getId() == 3 ){
                all.add(getFacade().findAll().get(i));
        }    
    }
    return all;}
     
    /*Accessoire Page*/
     public List<Produit> getAllAccesoireList(){
        List <Produit> all = new ArrayList<>();
        for(int i=0;i<this.getAll().size();i++){
            if(getFacade().findAll().get(i).getCategorieFk().getId() == 4 ){
                all.add(getFacade().findAll().get(i));
        }    
    }
    return all;}
    /**********tri Accessoire **********************/ 
    public List<Produit> getAllAccessoireListWithPrice(){
        List <Produit> all = this.getAllAccesoireList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getPrix().compareTo(p2.getPrix());
                }                
            });}
        return all;
    }
    
    public List<Produit> getAllAccessoireListWithName(){
        List <Produit> all = this.getAllAccesoireList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getNom().compareTo(p2.getNom());
                }                
            });}
        return all;
    }
        /**********tri Robotique **********************/ 
    public List<Produit> getAllRobotiqueListWithPrice(){
        List <Produit> all = this.getAllRobotiquesList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getPrix().compareTo(p2.getPrix());
                }                
            });}
        return all;
    }
    
    public List<Produit> getAllRobotiqueListWithName(){
        List <Produit> all = this.getAllRobotiquesList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getNom().compareTo(p2.getNom());
                }                
            });}
        return all;
    }
    
    /**********tri materiels **********************/ 
    public List<Produit> getAllElectroniqueListWithPrice(){
        List <Produit> all = this.getAllElectriqueMaterielList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getPrix().compareTo(p2.getPrix());
                }                
            });}
        return all;
    }
    
    public List<Produit> getAllElectroniqueListWithName(){
        List <Produit> all = this.getAllElectriqueMaterielList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getNom().compareTo(p2.getNom());
                }                
            });}
        return all;
    }
    
    /**********tri materiels **********************/ 
    public List<Produit> getAllMaterielListWithPrice(){
        List <Produit> all = this.getAllMaterielList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getPrix().compareTo(p2.getPrix());
                }                
            });}
        return all;
    }
    
    public List<Produit> getAllMaterielListWithName(){
        List <Produit> all = this.getAllMaterielList();
        for(int i = 0 ; i<all.size();i++){
            Produit p = all.get(i);
            Collections.sort(all, new Comparator<Produit>(){
                @Override
                public int compare(Produit p1, Produit p2){
                    return p1.getNom().compareTo(p2.getNom());
                }                
            });}
        return all;
    }
    public Produit getSelected() {
        if (current == null) {
            current = new Produit();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProduitFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Produit) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Produit();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProduitCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Produit) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProduitUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Produit) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProduitDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Produit getProduit(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Produit.class)
    public static class ProduitControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProduitController controller = (ProduitController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "produitController");
            return controller.getProduit(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Produit) {
                Produit o = (Produit) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Produit.class.getName());
            }
        }

    }

}
