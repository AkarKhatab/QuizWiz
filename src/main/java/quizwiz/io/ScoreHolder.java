/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizwiz.io;

import db.DBRepository;
import db.Highscore;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author zolic
 */
@Named
@SessionScoped
@NoArgsConstructor@Getter@Setter
public class ScoreHolder implements Serializable{
    private int score;
    private String name;
    private static Logger LOG = Logger.getLogger(ScoreHolder.class.getName());
    
    public void incScore() {
        score++;
        LOG.log(Level.INFO, "Score: " + getScore());
    }
    
    public void resetScore(){
        score = 0;
    }
    
    public void save(){
        System.out.println("SAVEHIGHSCORE " + name + " - " + score);
        DBRepository.getInstance().addHighscore(new Highscore(name, score));
    }
}
