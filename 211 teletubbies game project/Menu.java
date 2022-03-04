package teletubbies;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class Menu extends JFrame {

	private JPanel contentPane;
	static Controller contr;
	
	
	public static void main(String[] args) {
	
		contr=new Controller("TeletubbieShip");
		contr.showMenu();
	
	}


	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton playButton = new JButton("Play Now!");
		playButton.setForeground(Color.BLACK);
		playButton.setBackground(new Color(153, 102, 204));
		playButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contr.showScreen();
				
			}
		});
		playButton.setBounds(272, 312, 260, 56);
		contentPane.add(playButton);
		
		JButton exitButton = new JButton("Exit ");
		exitButton.setForeground(Color.BLACK);
		exitButton.setBackground(new Color(153, 102, 204));
		exitButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(272, 438, 260, 56);
		contentPane.add(exitButton);
		
		JTextPane title = new JTextPane();
		title.setEditable(false);
		title.setFont(new Font("Times New Roman", Font.BOLD, 58));
		title.setForeground(new Color(153, 102, 204));
		title.setText("TELETUBBIESHIP");
		title.setBackground(Color.BLACK);
		title.setBounds(143, 117, 533, 89);
		contentPane.add(title);
		
	}

	
}