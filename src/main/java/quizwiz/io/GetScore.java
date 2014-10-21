/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizwiz.io;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author zolic
 */
@Named
@SessionScoped
public class GetScore implements Serializable{
    private int score = 0;
    private static Logger LOG = Logger.getLogger(GetScore.class.getName());
    public GetScore() {
        
    }
    
    public void incScore() {
        this.score++;
        LOG.log(Level.INFO, "Score: " + score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
}
