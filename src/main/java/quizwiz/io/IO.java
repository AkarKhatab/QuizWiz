/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package quizwiz.io;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author zolic
 */

public class IO{
    private static final String STANDARDFRAGOR = "fragor.txt";
    private ArrayList<String> questions;
    private ArrayList<ArrayList<String>> allQuestions;
    private BufferedReader br;
    private static final Logger LOG = Logger.getLogger(IO.class.getName());
    private File file = new File("fragor.txt");
    
    public IO() throws UnsupportedEncodingException, FileNotFoundException {
        String file = (System.getProperty("user.home") + "/Desktop/" + STANDARDFRAGOR);
        br = new BufferedReader(new InputStreamReader(new FileInputStream(file))); 
//KOMMENTERA AV FILE DÄR UPPE IFALL DU INTE ANVÄNDER MAC OCH ERSÄTT "STANDARDFRAGOR" I "br" TILL "file"
        //System.out.println("****************" + file.getPath());
    }
    
    private void readFile() throws Exception {
        questions = new ArrayList<String>();
        allQuestions = new ArrayList<ArrayList<String>>();
        
        /**
         * reads line by line and add them to an ArrayList of strings, if
         * new row without signs the ArrayList will be added to a bigger
         * ArrrayList
         */
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("")) {
                ArrayList<String> tempQuest = ((ArrayList<String>) questions.clone());
                allQuestions.add(tempQuest);
                questions.clear();
            } else {
                questions.add(line);
            }
        }
        br.close();
        
    }
    
    public ArrayList<ArrayList<String>> getArray() throws Throwable {
        readFile();
        return allQuestions;
    }
    
}
