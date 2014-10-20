/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizwiz.io;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author khatab
 */
@Entity
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "player_name", nullable = false, updatable = false)
    private String name;
    private int highScore;
    
    public Users(){
        
    }
    
    public Users(String name, int score){
        this.name = name;
        this.highScore = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.highScore = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return highScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", score=" + highScore + '}';
    }
    
}
