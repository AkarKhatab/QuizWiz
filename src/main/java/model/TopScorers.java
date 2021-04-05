/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import db.DBRepository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author akar
 */
@Getter
@Setter
@Named
public class TopScorers implements Serializable {
    private String firstName, secondName, thirdName, fourthName, fifthName;
    private int firstScore, secondScore, thirdScore, fourthScore, fifthScore;
    DBRepository repo = DBRepository.getInstance();
    
    public TopScorers() {
        updateTopScorers();
    }
    
    public void updateTopScorers() {
        List<Highscore> topScorersList = repo.getTopScorers();
        
        if (topScorersList.size() > 0) {
            this.firstName = topScorersList.get(0).getName();
            this.firstScore = topScorersList.get(0).getScore();
        } else {
            this.firstName = "N/A";
            this.firstScore = 0;
        }
        
        if (topScorersList.size() > 1) {
            this.secondName = topScorersList.get(1).getName();
            this.secondScore = topScorersList.get(1).getScore();
        } else {
            this.secondName = "N/A";
            this.secondScore = 0;
        }
        
        if (topScorersList.size() > 2) {
            this.thirdName = topScorersList.get(2).getName();
            this.thirdScore = topScorersList.get(2).getScore();
        } else {
            this.thirdName = "N/A";
            this.thirdScore = 0;
        }
        
        if (topScorersList.size() > 3) {
            this.fourthName = topScorersList.get(3).getName();
            this.fourthScore = topScorersList.get(3).getScore();
        } else {
            this.fourthName = "N/A";
            this.fourthScore = 0;
        }
        
        if (topScorersList.size() > 4) {
            this.fifthName = topScorersList.get(4).getName();
            this.fifthScore = topScorersList.get(4).getScore();
        } else {
            this.fifthName = "N/A";
            this.fifthScore = 0;
        }
    }
}
