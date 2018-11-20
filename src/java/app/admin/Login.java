/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.admin;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alaa
 */
@ManagedBean
@SessionScoped
public class Login {

     private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void login() throws IOException{
        System.out.print("before IF");
        if (this.userName.equals("alaa") && this.password.equals("123")){
            System.out.print("in the IF");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + "/faces/JSFPages/adminPages/indexManager.xhtml");
        }
    }
    public Login() {
    }
    
}
