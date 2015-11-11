/**
 * Daniil Borisov
 * 
 * Builds an array list of questions and possible answers
 */

package Maze;

import java.io.*;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class QandA {
	ArrayList<Question> questions = new ArrayList<>();

	public QandA() {
		
		
		try {
			Scanner scan = new Scanner(new File("./QandA.txt"));
			
			while(scan.hasNextLine()){
				String nextLine = scan.nextLine();
				if(StringUtils.isNotBlank(nextLine)){
					String[] split = StringUtils.split(nextLine, ":");
					if(split.length == 6){
						questions.add(new Question(split));
					}
				}
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Question getQuestion(){
		int size = questions.size();
		Random rand = new Random();
		int qIndex = 0;
		
		if( size > 0){
			qIndex = rand.nextInt(size);
			return questions.get(qIndex);
		}
		return null;
	}

	public class Question {
		ArrayList<String> list = new ArrayList<>();
		
		public Question(String[] split){
			for(String s:split){
				list.add(s);
			}
		}
	}
}




