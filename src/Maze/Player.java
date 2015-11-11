/**
 * Daniil Borisov
 * 
 * Loads player icon and controls player position.
 * 
 * Based on tutorial: https://www.youtube.com/playlist?list=PLA38BD857DC0EE786
 */

package Maze;

import java.awt.*;

import javax.swing.ImageIcon;

public class Player {
	
	private int tileX, tileY;
	
	private Image player;
	
	public Player(){
		
		ImageIcon img = new ImageIcon("./player32.png");
		setPlayer(img.getImage());
		
		setTileX(1);
		setTileY(1);
	}
	
	public void move(int dx, int dy){
		
		setTileX(getTileX() + dx);
		setTileY(getTileY() + dy);
		
	}

	public Image getPlayer() {
		return player;
	}

	public void setPlayer(Image player) {
		this.player = player;
	}

	public int getTileX() {
		return tileX;
	}

	public void setTileX(int tileX) {
		this.tileX = tileX;
	}

	public int getTileY() {
		return tileY;
	}

	public void setTileY(int tileY) {
		this.tileY = tileY;
	}

}
