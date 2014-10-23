/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizwiz.io;

import java.io.Serializable;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    private int highscore;

    protected Highscore() {
    }
    
    public Highscore(int score) {
        this.highscore = score;
    }
    
    public int getHighscore(){
        
        return this.highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
    
    
}
