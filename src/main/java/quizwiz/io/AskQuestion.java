/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package quizwiz.io;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author zolic
 */
@Named
@ViewScoped
public class AskQuestion implements Serializable{
    
    private static Logger LOG = Logger.getLogger(AskQuestion.class.getName());
    private String question, ans1, ans2, ans3, ans4, correctAnswer;
    private IO io;
    private ArrayList<ArrayList<String>> allQuestions;
    private ArrayList<String> nextQuestion;
    private int questNr = -1;
    private int score = 0;
    public AskQuestion() throws UnsupportedEncodingException, FileNotFoundException, Throwable{
        io = new IO();
        getArray();
    }

    
    public void getArray() throws Throwable{
        allQuestions = io.getArray();
        getNewQuestion();
    }
    
    public void getNewQuestion(){
        this.questNr++;
        LOG.log(Level.INFO, "Nummer: " + questNr);
        this.nextQuestion = this.allQuestions.get(questNr);
        this.question = this.nextQuestion.get(0);
        this.correctAnswer = this.nextQuestion.get(1);
        shuffleArray(this.nextQuestion);
        
    }
    
    public void shuffleArray(ArrayList<String> list){
        ArrayList<String> shuffled = new ArrayList<>();
        for(int i = 1; i<=4; i++){
            shuffled.add(list.get(i));
        }
        Collections.shuffle(shuffled);
        this.ans1 = shuffled.get(0);
        this.ans2 = shuffled.get(1);
        this.ans3 = shuffled.get(2);
        this.ans4 = shuffled.get(3);
        LOG.log(Level.INFO, "CorrectAnswer{0}", correctAnswer);
    }
    
    public void checkIfCorrectAnswer(){
        Map<String,String> params = 
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	String answer = params.get("answer");
        
        LOG.log(Level.INFO, ""+ answer);
        getNewQuestion();
    }
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String getAns1() {
        return ans1;
    }
    
    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }
    
    public String getAns2() {
        return ans2;
    }
    
    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }
    
    public String getAns3() {
        return ans3;
    }
    
    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }
    
    public String getAns4() {
        return ans4;
    }
    
    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

}
