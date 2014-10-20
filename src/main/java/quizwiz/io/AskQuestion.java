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
import javax.faces.bean.*;

/**
 *
 * @author zolic
 */
@ManagedBean
@ViewScoped
public class AskQuestion implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(AskQuestion.class.getName());
    private String question, ans1, ans2, ans3, ans4;
    private IO io;
    private ArrayList<ArrayList<String>> allQuestions;
    private ArrayList<String> nextQuestion;
    private int questNr = -1;
    public AskQuestion() throws UnsupportedEncodingException, FileNotFoundException, Throwable{
        io = new IO();
        getArray();
    }
    
    public void getArray() throws Throwable{
        allQuestions = io.getArray();
        getNewQuestion();
    }
    
    public void getNewQuestion(){
        questNr++;
        nextQuestion = allQuestions.get(questNr);
        LOG.log(Level.INFO, "All: {0}", nextQuestion);
        this.question = nextQuestion.get(0);
        this.ans1 = nextQuestion.get(1);
        this.ans2 = nextQuestion.get(2);
        this.ans3 = nextQuestion.get(3);
        this.ans4 = nextQuestion.get(4);
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
