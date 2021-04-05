/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import model.Highscore;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Constants;

/**
 *
 * @author zolic
 */
public class HighscoreDao implements Dao<Highscore> {

    Connection connection;

    public HighscoreDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Highscore> getAll() {
        List<Highscore> list = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(Constants.SQL_GET_ALL_HIGHSCORES);

            while (rs.next()) {

                list.add(new Highscore(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getInt("SCORE")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("DBDATA ERROR: " + ex);
        }

        return list;
    }

    @Override
    public Boolean insert(Highscore item) {
        try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(Constants.SQL_INSERT_HIGHSCORE(item.getId(), item.getName(), item.getScore()));
                return true;
            } catch (SQLException ex) {
                System.out.println("addHighscore error: " + ex);
                return false;
            }
    }
    
    public List<Highscore> getTopScorers() {
        List<Highscore> list = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(Constants.SQL_GET_TOP_HIGHSCORES);

            while (rs.next()) {

                list.add(new Highscore(
                        rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getInt("SCORE")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("DBDATA ERROR: " + ex);
        }
        
        return list;
    }
}
