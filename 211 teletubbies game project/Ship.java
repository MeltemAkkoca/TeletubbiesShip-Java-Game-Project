package teletubbies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ship {

	private int shipX=300;
	private BufferedImage shipImage;
	
	
	public void picturizeShip(Graphics g) {
		 
		try {
			shipImage=ImageIO.read(new File("ship.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	
	public void shiftLeft() {
		this.shipX-=20;
	}
	public void shiftRight() {
		this.shipX+=20;
	}
	
	public int getShipX(){
		return shipX;
	}
	
	public void setShipX(int x) {
		shipX=x;
	}
	
	public BufferedImage getShipImage() {   // private resmi bu classtan alabilmek için get kurduk
		return shipImage;
	}

}