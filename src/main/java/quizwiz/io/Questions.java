/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizwiz.io;

import java.io.*;
import java.util.*;

/**
 *
 * @author zolic
 */
public class Questions{

	private ArrayList<ArrayList<String>> originalList;
	private ArrayList<SingleQuestion> objectList;
	private IO io;
	
	
	/**
	 * Constructor creates a new IOClient and asks for an array to be converted into SingleQuestions'.
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 * @throws IOException 
	 */
	public Questions() throws UnsupportedEncodingException, FileNotFoundException
	{
	    io = new IO();												
	    objectList = new ArrayList<SingleQuestion>();				

	}
	
	
	public ArrayList<SingleQuestion> getQuestions(int y) throws Throwable {
		originalList = io.getArray();								//Copies the original list from the IO class to a local list
		originalList.trimToSize();
		shuffle(originalList);
		for(int i = 0; i < y; i++){								//Loops through the list to create a new list of Objects instead of ArrayList<String> which is returned from the IO class
			objectList.add(new SingleQuestion(originalList.get(i)));	
		}
		return objectList;
	}
	
	/**
	 * Shuffles Array List as parameter with system time as seed.
	 */
	private void shuffle(ArrayList<?> list)
	{
		long seed = System.nanoTime();				//New seed for randomizer.
		Collections.shuffle(list, new Random(seed));	
	}
}