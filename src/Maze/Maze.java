/**
 * Daniil Borisov
 * 
 * Initializes the game frame.
 * 
 * Based on tutorial: https://www.youtube.com/playlist?list=PLA38BD857DC0EE786
 */

package Maze;

import javax.swing.*;

public class Maze {
	public static void main(String[] args){
		new Maze();
	}
	
	public Maze(){
		JFrame f = new JFrame();
		f.setTitle("Trivia Maze");
		f.add(new Board());
		f.setSize(464, 485);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
