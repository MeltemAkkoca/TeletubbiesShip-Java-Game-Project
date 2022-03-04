package teletubbies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener, ActionListener {

	Timer timer = new Timer(5, this);

	private int counter = 0;
	private int score = 0;
	private int heart = 3;
	
	public Ship spaceShip = new Ship();
	private ArrayList<Shot> shots = new ArrayList<Shot>();
	private ArrayList<Meteor> meteors = new ArrayList<Meteor>();
	private ArrayList<Meteor> fuels = new ArrayList<Meteor>();

	
	public Game() {
		timer.start();
		setBackground(Color.black);
		spaceShip.picturizeShip(getGraphics());
	}

	
	
	
	public Meteor isCrushMShot() {

		for (Shot changedShot : shots) {
			for (Meteor changedMeteor : meteors) {
				if (new Rectangle(changedShot.getX(), changedShot.getY(), 10, 20)
						.intersects(new Rectangle(changedMeteor.getmeteorX(), changedMeteor.getmeteorY(), changedMeteor.getSizeX(), 
								changedMeteor.getSizeY()))) 
					return changedMeteor;	
				}
		}
		return null;
	}

	
	
	public Meteor isCrushFShot() {

		for (Shot changedShot : shots) {
			for (Meteor changedFuel : fuels) {
				if (new Rectangle(changedShot.getX(), changedShot.getY(), 10, 20)
						.intersects(new Rectangle(changedFuel.getmeteorX(), changedFuel.getmeteorY(), 40, 40))) 
					return changedFuel;			
				}
		}
		return null;
	}

	
	
	public Meteor isCrushMShip() {
		
		for (Meteor changedMeteor : meteors) {
			if (new Rectangle(changedMeteor.getmeteorX(), changedMeteor.getmeteorY(), changedMeteor.getSizeX(), changedMeteor.getSizeY())
					.intersects(new Rectangle(spaceShip.getShipX(), 470, spaceShip.getShipImage().getWidth() / 12,
							spaceShip.getShipImage().getHeight() / 12))) 
				return changedMeteor;
		}
		return null;
	}
	
	
	
	public Meteor isCrushFShip() {
		for (Meteor changedFuel : fuels) {
			if (new Rectangle(changedFuel.getmeteorX(), changedFuel.getmeteorY(), 40, 40)
					.intersects(new Rectangle(spaceShip.getShipX(), 470, spaceShip.getShipImage().getWidth() / 12,
							spaceShip.getShipImage().getHeight() / 12))) 
				return changedFuel;
		}
		return null;
	}

	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Font font = new Font("Times New Roman", Font.PLAIN, 20);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Heart: " + heart, 20, 30);
		g.drawString("Score: " + score, 20, 50);

		
		for (Shot changedShot : shots) {
			if (changedShot.getY() < 0)
				shots.remove(changedShot);
		}
		
		
		for (Meteor changedMeteor : meteors) {
			if (changedMeteor.getmeteorY() > 500)
				meteors.remove(changedMeteor);
		}
		

		g.drawImage(spaceShip.getShipImage(), spaceShip.getShipX(), 470, spaceShip.getShipImage().getWidth() / 12,
				spaceShip.getShipImage().getHeight() / 12, this);
		
		
		
		g.setColor(Color.ORANGE);
		for (Shot changedShot : shots)
			g.fillRect(changedShot.getX(), changedShot.getY(), 10, 20);

		
		g.setColor(Color.GRAY);
		for (Meteor changedMeteor : meteors)
			g.fillOval(changedMeteor.getmeteorX(), changedMeteor.getmeteorY(), changedMeteor.getSizeX(), changedMeteor.getSizeY());
		

		g.setColor(Color.BLUE);
		for (Meteor changedFuel : fuels) 
			g.fillRect(changedFuel.getmeteorX(), changedFuel.getmeteorY(), 40, 40);
		

		
		
		Meteor returnedMeteor = isCrushMShot();

		if (returnedMeteor != null) {
			score += 10;
			for (Meteor changedMeteor : meteors) {
				if (returnedMeteor == changedMeteor) 
					meteors.remove(changedMeteor);				
			}
		}

		
		
		Meteor returnedFuel = isCrushFShot();
		
		if (returnedFuel != null) {
			if (heart == 3) 
				heart = 3;
		    else
				heart++;
			
			for (Meteor changedFuel : fuels) {
				if (returnedFuel == changedFuel)
					fuels.remove(changedFuel);
			}			
		}

		
		
		Meteor crushedMeteor = isCrushMShip();
		
		if (crushedMeteor != null) {
			heart--;

			for (Meteor changedMeteor : meteors) {
				if (crushedMeteor == changedMeteor) {
					meteors.remove(changedMeteor);
					break;
				}
			}
			
			if (heart <= 0) {
				timer.stop();
				String message = "GAME OVER" + "\nScore:" + score;
				JOptionPane.showMessageDialog(this, message);
				System.exit(0);
			}
		}		
		
		
		
		Meteor crushedFuel = isCrushFShip();
		
		if(crushedFuel != null) {
			if (heart == 3) 
				heart = 3;
		    else
				heart++;
			
			for (Meteor changedFuel : fuels) {
				if (crushedFuel == changedFuel) 
					fuels.remove(changedFuel);
			}
		}
		
		
	}

	@Override
	public void repaint() {
		super.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}
	

	@Override
	public void keyPressed(KeyEvent e) {

		int c = e.getKeyCode();

		if (c == KeyEvent.VK_LEFT) {
			
			if (spaceShip.getShipX() <= 0) 
				spaceShip.setShipX(0);
			else 
				spaceShip.shiftLeft();
		} 
		
		
		else if (c == KeyEvent.VK_RIGHT) {
			
			if (spaceShip.getShipX() >= 650) 
				spaceShip.setShipX(650);
		    else 
				spaceShip.shiftRight();
		}
		

		else if (c == KeyEvent.VK_SPACE) {
			shots.add(new Shot(spaceShip.getShipX() + 63, 490));
		}

		
		else if (c == KeyEvent.VK_P) {

			if (timer.getDelay() == 5) 
				timer.setDelay(999999999);
			 else {
				timer = new Timer(5, this);
				timer.start();
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	
	public void meteorRandom() {
		if (counter % 80 == 0) 
			meteors.add(new Meteor());
	}

	public void fuelRandom() {
		if (counter % 500 == 0) 
			fuels.add(new Meteor());
	}

	
	
	
	public void actionPerformed(ActionEvent e) {

		for (Shot changedShot : shots) 
			changedShot.setY(changedShot.getY() - 5); 
		

		for (Meteor changedMeteor : meteors) {
			changedMeteor.setmeteorY(changedMeteor.getmeteorY() + 1); 
		}

		for (Meteor changedFuel : fuels) {
			changedFuel.setmeteorY(changedFuel.getmeteorY() + 1); 
		}
		
		meteorRandom();
		fuelRandom();
		counter++;

		repaint();
	}

}