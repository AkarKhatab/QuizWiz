/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package quizwiz.io;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author zolic
 */
public class SingleQuestion{


	private String question;
	private String correctAnswer;
	private String answer2;
	private String answer3;
	private String answer4;


	/**
	 * SingleQuestion takes an array and puts each element in each respective field.
	 * @param questionArray containing one question with 4 answers.
	 */
	public SingleQuestion(ArrayList<String> questionArray){
		this.question = questionArray.get(0);
		this.correctAnswer = questionArray.get(1);
		this.answer2 = questionArray.get(2);
		this.answer3 = questionArray.get(3);
		this.answer4 = questionArray.get(4);
	}


	public String getQuestion()
	{
		return question;
	}

	public String getCorrectAnswer()
	{
		return correctAnswer;
	}

	public String getAnswer2()
	{
		return answer2;
	}

	public String getAnswer3()
	{
		return answer3;
	}

	public String getAnswer4()
	{
		return answer4;
	}

	public boolean isEmpty() {
		if(question.equals(null)||correctAnswer.equals(null)||answer2.equals(null)||answer3.equals(null)||answer4.equals(null)) {return true;}
		else {return false;}

	}
}