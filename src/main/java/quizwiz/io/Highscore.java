/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizwiz.io;

import java.io.IOException;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import quizwiz.io.Pages;

/**
 *
 * @author behrozkeyvannia
 */
@Entity
@Named
@NoArgsConstructor@Getter@Setter
public class Highscore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "player_name")
    private String name;
    @Column(name = "highscore")
    private int highscore;
    
    Pages pages = new Pages();
    
    public void saveHighscoreAndRedirectToGamePage(int highscore) throws IOException {
        System.out.println("Highscoooooore: " + highscore);
        this.setHighscore(highscore);
        pages.redirectToEndGamePage();
    }
}
