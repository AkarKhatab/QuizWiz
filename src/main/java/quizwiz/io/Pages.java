/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizwiz.io;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author AkarKhatab
 */
@Named(value="pages")
@RequestScoped
public  class Pages implements Serializable {

    public Pages() {
    }
    
    public void redirectToGamePage() throws IOException {
        System.out.println("Redirecting to game page.");
        FacesContext.getCurrentInstance().getExternalContext().redirect("game.xhtml");
    }
    
    public static void redirectToEndGamePage() throws IOException {
        System.out.println("Redirecting to end game page.");
        FacesContext.getCurrentInstance().getExternalContext().redirect("endGamePage.xhtml");
    }
    
    public static void redirectToStartPage(int highscore) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
}
