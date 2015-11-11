/**
 * Daniil Borisov
 * 
 * Creates maze outline with paths, doors, and exit.
 * 
 * Based on tutorial: https://www.youtube.com/playlist?list=PLA38BD857DC0EE786
 */

package Maze;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Map {
	
	private Scanner m;
	private String Map[] = new String[14];
	private Image path, wall, finish, door;
	
	public Map(){
		
		ImageIcon img = new ImageIcon("./path.png");
		setPath(img.getImage());
		img = new ImageIcon("./wall.png");
		setWall(img.getImage());
		img = new ImageIcon("./exit.png");
		setFinish(img.getImage());
		img = new ImageIcon("./door.png");
		setDoor(img.getImage());
		
		openFile();
		readFile();
		closeFile();
	}
	
	public String getMap(int x, int y){
		String index = Map[y].substring(x, x+1);
		return index;
	}

	private void closeFile() {
		m.close();
	}

	private void readFile() {
		while(m.hasNext()){
			for(int i = 0; i < 14; i++){
				Map[i] = m.next();
			}
		}
	}

	private void openFile() {
		try {
			m = new Scanner(new File("./Map.txt"));
		} catch (Exception e) {
			System.out.println("Cant load map File");
		}
		
	}

	public Image getWall() {
		return wall;
	}

	public void setWall(Image wall) {
		this.wall = wall;
	}

	public Image getPath() {
		return path;
	}

	public void setPath(Image path) {
		this.path = path;
	}

	public Image getFinish() {
		return finish;
	}

	public void setFinish(Image finish) {
		this.finish = finish;
	}

	public Image getDoor() {
		return door;
	}

	public void setDoor(Image door) {
		this.door = door;
	}

}
