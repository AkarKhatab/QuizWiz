/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zolic
 */
public class DBRepository {

    public static DBRepository instance = null;

    public static DBRepository getInstance() {
        if (instance == null) {
            instance = new DBRepository();
        }
        return instance;
    }

    private Connection connection;
    private HighscoreDao highscoreDao;
    
    private List<Highscore> highscoreList = new ArrayList<>();

    String url = "jdbc:derby://localhost:1527/app";
    String userid = "app";
    String password = "app";
    
    private HighscoreDao getHighscoreDao(){
        if(highscoreDao == null){
            highscoreDao = new HighscoreDao(getConnection());
        }
        return highscoreDao;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                System.out.println("Create new connection...");
                connection = DriverManager.getConnection(url, userid, password);

            }
        } catch (SQLException ex) {
            System.out.println("DBDATA ERROR: " + ex);
        }

        return connection;
    }
    
    public List<Highscore> getHighscores() {
        highscoreList.clear();
        highscoreList.addAll(getHighscoreDao().getAll());
        return highscoreList;
    }

    public void addHighscore(Highscore highscore) {
        highscore.setId(highscoreList.size());
        if(getHighscoreDao().insert(highscore)){
            highscoreList.add(highscore);
        }
    }
}
