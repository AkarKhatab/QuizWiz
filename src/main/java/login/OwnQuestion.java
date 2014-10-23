/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package login;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author zolic
 */
@Named
@RequestScoped
public class OwnQuestion implements Serializable{
    private static String STANDARDFRAGOR = "fragor.txt";
    private String question, rightAnswer, ans2, ans3, ans4;
    private BufferedWriter bw;
    private ArrayList<String> ownQ;
    
    @PostConstruct
    public void init() {
        ownQ = new ArrayList<String>();
        ownQ.add("Hej");
    }
    
    @PreDestroy
    public void pre() {
    }
    public void writeToFile(ArrayList<String> list) throws IOException{
        String file = (System.getProperty("user.home") + "/Desktop/" + STANDARDFRAGOR);
        bw = new BufferedWriter(new FileWriter(file,true));
        Iterator<String> it = list.iterator();
        
        while (it.hasNext()) {
            bw.write(it.next() + "\n");
        }
        bw.write("\n");
        bw.close();
    }
    
    public void addOwnQ() throws IOException{
        if(ownQ != null)
            ownQ.clear();
        ownQ.add(question);
        ownQ.add(rightAnswer);
        ownQ.add(ans2);
        ownQ.add(ans3);
        ownQ.add(ans4);
        writeToFile(ownQ);
    }
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        if(question.charAt(question.length()-1) != '?')
            this.question = question + "?";
        else
            this.question = question;
    }
    
    public String getRightAnswer() {
        return rightAnswer;
    }
    
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
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
