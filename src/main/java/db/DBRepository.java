/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import model.Highscore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Question;
import util.Constants;

/**
 *
 * @author zolic
 */
public class DBRepository {

    public static DBRepository instance = null;

    public static DBRepository getInstance() {
        if (instance == null) {
            instance = new DBRepository();
            instance.getHighscoreDao();
            instance.getQuestionsDao();
            instance.getHighscores();
            instance.getQuestions();
        }
        return instance;
    }

    private Connection connection;
    private HighscoreDao highscoreDao;
    private QuestionsDao questionsDao;

    private List<Highscore> highscoreList = new ArrayList<>();
    private List<Question> questionsList = new ArrayList<>();
    private List<Highscore> topScorersList = new ArrayList<>();

    private QuestionsDao getQuestionsDao() {
        if (questionsDao == null) {
            questionsDao = new QuestionsDao(getConnection());
        }
        return questionsDao;
    }

    private HighscoreDao getHighscoreDao() {
        if (highscoreDao == null) {
            highscoreDao = new HighscoreDao(getConnection());
        }
        return highscoreDao;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                System.out.println("Create new connection...");
                connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.DATABASE_USER_ID, Constants.DATABASE_USER_PASSWORD);

            }
        } catch (SQLException ex) {
            System.out.println("DBDATA ERROR: " + ex);
        }

        return connection;
    }

    public List<Question> getQuestions() {
        questionsList.clear();
        questionsList.addAll(questionsDao.getAll());
        Collections.sort(questionsList, new Comparator<Question>() {
            @Override
            public int compare(Question u1, Question u2) {
                return u1.getId().compareTo(u2.getId());
            }
        });
        return questionsList;
    }

    public void addQuestion(Question question) {
        if (questionsList.isEmpty()) {
            question.setId(0);
        } else {
            question.setId(questionsList.get(questionsList.size() - 1).getId() + 1);
        }
        if (questionsDao.insert(question)) {
            questionsList.add(question);
        }
    }

    public List<Highscore> getHighscores() {
        highscoreList.clear();
        highscoreList.addAll(highscoreDao.getAll());
        Collections.sort(highscoreList, new Comparator<Highscore>() {
            @Override
            public int compare(Highscore u1, Highscore u2) {
                return u1.getId().compareTo(u2.getId());
            }
        });
        return highscoreList;
    }

    public void addHighscore(Highscore highscore) {
        if (highscoreList.isEmpty()) {
            highscore.setId(0);
        } else {
            highscore.setId(highscoreList.get(highscoreList.size() - 1).getId() + 1);
        }

        if (highscoreDao.insert(highscore)) {
            highscoreList.add(highscore);
        }
    }
    
    public List<Highscore> getTopScorers() {
        return highscoreDao.getTopScorers();
    }
    
}
