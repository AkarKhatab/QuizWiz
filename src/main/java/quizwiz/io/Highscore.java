/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizwiz.io;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author behrozkeyvannia
 */
@Entity
@Named
public class Highscore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "player_name")
    private String name;
    @Column(name = "highscore")
    private int highscore;

    protected Highscore() {
    }
    
    public int getHighscore(){
        
        return this.highscore;
    }

    public void setHighscore() {
        this.highscore = highscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
