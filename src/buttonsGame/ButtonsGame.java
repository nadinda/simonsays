package buttonsGame;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonsGame extends JFrame {
	private ButtonPanel buttonPanel;

	public ButtonsGame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		buttonPanel = new ButtonPanel();
		add(buttonPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new ButtonsGame("Buttons Game");
	}

}
