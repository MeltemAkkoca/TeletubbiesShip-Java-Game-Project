package teletubbies;

import java.util.Random;

public class Meteor{

	private int meteorX;
	private int meteorY;
	private int sizeX,sizeY;
	
	

	public Meteor() {
		
		Random meteorDirec=new Random();
		Random size=new Random();
		meteorX= meteorDirec.nextInt(700);
		meteorY=0;
		sizeX=size.nextInt(31)+40;
		sizeY=size.nextInt(31)+40;
	}
	

	public int getSizeX() {
		return sizeX;
	}


	public int getSizeY() {
		return sizeY;
	}


	public int getmeteorX() {
		return meteorX;
	}


	public void setmeteorX(int xMeteor) {
		this.meteorX = xMeteor;
	}


	public int getmeteorY() {
		return meteorY;
	}


	public void setmeteorY(int yMeteor) {
		this.meteorY = yMeteor;
	}
	
	
}