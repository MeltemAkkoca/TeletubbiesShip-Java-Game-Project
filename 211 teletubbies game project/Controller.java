package teletubbies;

import java.awt.HeadlessException;
import javax.swing.JFrame;


public class Controller extends JFrame {

	 Controller screen;
	 Menu menu= new Menu();
	 Game game;
	
	 
	 public Controller (String title) throws HeadlessException{
			super(title);
	}
	 
	 
	 public void setScreen() {
		screen=new Controller("TeletubbieShip"); 
		screen.setResizable(false);
		screen.setFocusable(false);
		screen.setSize(800, 600);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 
	 
	 
	 public void setGame() {
		game=new Game();
		game.requestFocus();
		game.addKeyListener(game);
		game.setFocusable(true);
		game.setFocusTraversalKeysEnabled(false);
	 }
	 
	 
	 public void showScreen() {
		
		setScreen();
		setGame();
		menu.setVisible(false);
		screen.add(game);
		screen.setVisible(true);	
	}
	
	public void showMenu() {
		
		setScreen();
		screen.setVisible(false);
		menu.setVisible(true);
		
	}
	
	
}
