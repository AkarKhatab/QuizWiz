/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package quizwiz.io;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author zolic
 */
@ManagedBean
@RequestScoped
public class AskQuestion{
    private ArrayList<String> answers;
    private SingleQuestion quest;
    private static final Logger LOG = Logger.getLogger(AskQuestion.class.getName());
    private String question="hej";
    
    public AskQuestion(){
        
    }
    
    public String getQuestion() {
    return question;
}
    
    
}
