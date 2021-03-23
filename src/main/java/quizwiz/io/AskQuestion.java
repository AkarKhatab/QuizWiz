/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package quizwiz.io;

import db.DBRepository;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Question;


/**
 *
 * @author zolic
 */
@Named
@ViewScoped
@NoArgsConstructor@Getter@Setter
public class AskQuestion implements Serializable {
    
    private static Logger LOG = Logger.getLogger(AskQuestion.class.getName());
    private String question, ans1, ans2, ans3, ans4;
    private transient IO io;
    private List<Question> allQuestions;
    private Question currentQuestion;
    private int questNr = -1;

    @Inject
    private ScoreHolder gs;

    @PostConstruct
    private void init() {
        try {
            io = new IO();
            getArray();
        } catch (Exception ex) {
            Logger.getLogger(AskQuestion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(AskQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getArray() throws Throwable{
        this.allQuestions = DBRepository.getInstance().getQuestions();
        Collections.shuffle(allQuestions);
        getNewQuestion();
    }
    
    public void getNewQuestion() throws IOException{
        this.questNr++;
        if(questNr == 0)
            gs.resetScore();
        if(questNr == 5){
            LOG.log(Level.INFO, "questNr är 4");
            endGame();
            return;
        }
        currentQuestion = allQuestions.get(questNr);
        this.question = currentQuestion.getQuestion();
        shuffleArray();
        
    }
    
    public void shuffleArray(){
        ArrayList<String> shuffled = new ArrayList<String>();
        shuffled.add(currentQuestion.getCorrectAnswer());
        shuffled.add(currentQuestion.getAnswer2());
        shuffled.add(currentQuestion.getAnswer3());
        shuffled.add(currentQuestion.getAnswer4());
        Collections.shuffle(shuffled);
        this.ans1 = shuffled.get(0);
        this.ans2 = shuffled.get(1);
        this.ans3 = shuffled.get(2);
        this.ans4 = shuffled.get(3);
        
    }
    
    public void checkIfCorrectAnswer() throws IOException{
        Map<String,String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	String answer = params.get("answer");
        if(currentQuestion.getCorrectAnswer().equals(answer)){
            LOG.log(Level.INFO, "Rätt");
            gs.incScore();
        }
        getNewQuestion();
    }
    
    public void endGame() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("highscorePopup.xhtml"); 
    }
}
