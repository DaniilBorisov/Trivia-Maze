/**
 * Daniil Borisov
 * 
 * Prompts Player with random question
 */

package Maze;

import javax.swing.*;

import Maze.QandA.Question;

public class Trivia extends JOptionPane{
	JLabel label;
	int n;
	private boolean answer = false;
	
	public Trivia(JOptionPane frame, QandA qa){
		Question question = qa.getQuestion();
		Object[] options = { question.list.get(1), question.list.get(2), question.list.get(3), question.list.get(4) };
		n = JOptionPane.showOptionDialog(frame, question.list.get(0),
				"Answer this and you shall pass", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[3]);
		if(n == Integer.parseInt(question.list.get(5)) - 1){
			answer = true;
		}
	}

	public boolean getAnswer() {
		
		
		return answer;
	}
	
}
