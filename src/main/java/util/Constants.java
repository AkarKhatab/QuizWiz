/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author zolic
 */
public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    public static final String DATABASE_URL = "jdbc:derby://localhost:1527/quizwiz";
    public static final String DATABASE_USER_ID = "quizwiz";
    public static final String DATABASE_USER_PASSWORD = "quizwiz";
    public static final String DATABASE_TABLE_HIGHSCORE = "HIGHSCORE";
    public static final String DATABASE_TABLE_QUESTIONS = "QUESTIONS";
    public static final String SQL_GET_ALL_HIGHSCORES = "SELECT * FROM " + DATABASE_TABLE_HIGHSCORE;
    public static final String SQL_GET_ALL_QUESTIONS = "SELECT * FROM " + DATABASE_TABLE_QUESTIONS;
    public static final String SQL_GET_TOP_HIGHSCORES = 
            "SELECT * FROM " + DATABASE_TABLE_HIGHSCORE + " ORDER BY SCORE DESC FETCH FIRST 5 ROWS ONLY";

    public static String SQL_INSERT_HIGHSCORE(int id, String name, int score) {
        return "INSERT INTO " + DATABASE_TABLE_HIGHSCORE + " VALUES ("
                + id
                + ", '" + name + "', "
                + score
                + ")";
    }
    
    public static String SQL_INSERT_QUESTION(int id, String question, 
            String correntAnswer, String answer2, String answer3, String answer4) {
        return "INSERT INTO " + DATABASE_TABLE_QUESTIONS + " VALUES ("
                + id
                + ", '" + question + "'"
                + ", '" + correntAnswer + "'"
                + ", '" + answer2 + "'"
                + ", '" + answer3 + "'"
                + ", '" + answer4 + "'"
                + ")";
    }
}
