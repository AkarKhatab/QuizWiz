/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package login;

import db.DBRepository;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Question;

/**
 *
 * @author zolic
 */
@Named
@RequestScoped
@NoArgsConstructor
@Getter
@Setter
public class OwnQuestion implements Serializable {

    private String question, rightAnswer, ans2, ans3, ans4;

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void pre() {
    }

    public void addOwnQ() throws IOException {
        setQuestion(question);
        DBRepository.getInstance().addQuestion(new Question(
                question,
                rightAnswer,
                ans2,
                ans3,
                ans4
        ));
    }

    public void setQuestion(String question) {
        if (question.charAt(question.length() - 1) != '?') {
            this.question = question + "?";
        } else {
            this.question = question;
        }
    }

}
