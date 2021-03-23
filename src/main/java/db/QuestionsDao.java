/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Question;
import util.Constants;

/**
 *
 * @author zolic
 */
public class QuestionsDao implements Dao<Question> {

    Connection connection;

    public QuestionsDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Question> getAll() {
        List<Question> list = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(Constants.SQL_GET_ALL_QUESTIONS);

            while (rs.next()) {

                list.add(new Question(
                        rs.getInt("ID"),
                        rs.getString("QUESTION"),
                        rs.getString("CORRECT_ANSWER"),
                        rs.getString("ANSWER2"),
                        rs.getString("ANSWER3"),
                        rs.getString("ANSWER4")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("DBDATA ERROR: " + ex);
        }

        return list;
    }

    @Override
    public Boolean insert(Question item) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(Constants.SQL_INSERT_QUESTION(
                    item.getId(), item.getQuestion(),
                    item.getCorrectAnswer(), item.getAnswer2(), item.getAnswer3(), item.getAnswer4()));
            return true;
        } catch (SQLException ex) {
            System.out.println("addHighscore error: " + ex);
            return false;
        }
    }

}
