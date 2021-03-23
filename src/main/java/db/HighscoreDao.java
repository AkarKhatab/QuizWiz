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
        String sql = "SELECT * FROM HIGHSCORE";
        List<Highscore> list = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                list.add(new Highscore(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("score")
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
                statement.executeUpdate("INSERT INTO HIGHSCORE " + "VALUES ("+item.getId() + ", '" + item.getName() + "', " + item.getScore() + ")");

                System.out.println("addHighscore " + item.getName() + " - " + item.getScore());
                return true;
            } catch (SQLException ex) {
                System.out.println("addHighscore error: " + ex);
                return false;
            }
    }
}
