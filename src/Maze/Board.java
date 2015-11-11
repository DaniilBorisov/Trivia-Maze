/**
 * Daniil Borisov
 * 
 * Runs all the game logic, movement, prompts,...etc.
 * 
 * Based on tutorial: https://www.youtube.com/playlist?list=PLA38BD857DC0EE786
 */

package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {

	private Timer timer;

	private Map m;
	private Player p;
	private Trivia t;

	private JOptionPane frame;
	private QandA qa = new QandA();

	private boolean win = false;

	private String[] message = {"THANK YOU MARIO!", "BUT OUR PRINCESS IS IN", "ANOTHER CASTLE!"};

	private Font font = new Font("Serif", Font.BOLD, 24);

	public Board() {

		m = new Map();
		p = new Player();

		addKeyListener(new Al());
		setFocusable(true);

		timer = new Timer(25, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (m.getMap(p.getTileX(), p.getTileY()).equalsIgnoreCase("f")) {
			
			win = true;
		}
		repaint();

	}

	public void paint(Graphics g) {
		super.paint(g);
		if (!win) {
			for (int y = 0; y < 14; y++) {
				for (int x = 0; x < 14; x++) {
					if (m.getMap(x, y).equals("d")) {
						g.drawImage(m.getDoor(), x * 32, y * 32, null);
					}

					if (m.getMap(x, y).equals("f")) {
						g.drawImage(m.getFinish(), x * 32, y * 32, null);
					}
					if (m.getMap(x, y).equals("p")) {
						g.drawImage(m.getPath(), x * 32, y * 32, null);
					}
					if (m.getMap(x, y).equals("w")) {
						g.drawImage(m.getWall(), x * 32, y * 32, null);
					}
				}
			}
			g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32,
					null);
		}

		if (win) {
			g.setColor(Color.BLUE);
			g.setFont(font);
			g.drawString(message[0], 90, 120);
			g.drawString(message[1], 90, 170);
			g.drawString(message[2], 90, 200);
		}
	}

	public class Al extends KeyAdapter {

		public void keyPressed(KeyEvent e){
			int keycode = e.getKeyCode();
			
			if (keycode == KeyEvent.VK_UP){
				if(	m.getMap(p.getTileX(), p.getTileY() - 1).equals("d")){
					t = new Trivia(frame, qa);
					if(t.getAnswer()){
						p.move(0, -1);
					}
				}else
				if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("w")){
					p.move(0, -1);
				}
			}
			if (keycode == KeyEvent.VK_DOWN){
				if(m.getMap(p.getTileX(), p.getTileY() + 1).equals("d")){
					t = new Trivia(frame, qa);
					if(t.getAnswer()){
						p.move(0, 1);
					}
				}else
				if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w")){
					p.move(0, 1);
				}
			}
			if (keycode == KeyEvent.VK_LEFT){
				if(	m.getMap(p.getTileX()-1, p.getTileY()).equals("d")){
					t = new Trivia(frame, qa);
					if(t.getAnswer()){
						p.move(-1, 0);
					}
				}else
				if (!m.getMap(p.getTileX()-1, p.getTileY()).equals("w")){
					p.move(-1, 0);
				}
			}
			if (keycode == KeyEvent.VK_RIGHT){
				if(	m.getMap(p.getTileX()+1, p.getTileY()).equals("d")){
					t = new Trivia(frame, qa);
					if(t.getAnswer()){
						p.move(1, 0);
					}
				}else
				if (!m.getMap(p.getTileX()+1, p.getTileY()).equals("w")){
					p.move(1, 0);
				}
			}
			
		}

		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {

		}

	}

}
