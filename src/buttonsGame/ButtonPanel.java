package buttonsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel implements ActionListener {
	private JTextField text;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton nextButton;
	
	public ButtonPanel() {
		super();
		defineStructure();
		//setLayout(new FlowLayout(FlowLayout.CENTER));
		//setLayout(new GridLayout(2,2,10,8));
	}
	
	private void defineStructure() {
		setLayout(new BorderLayout());
		//add(new JTextField("north"), BorderLayout.NORTH);
		text = new JTextField("bla");
		text.setHorizontalAlignment(JTextField.CENTER);
		add(text, BorderLayout.NORTH);
		
		JPanel jp = new JPanel();
		add(jp);
		jp.setLayout(new GridLayout(2,2,22,22));
		button1 = defineButton("1", jp);
		button2 = defineButton("2", jp);
		button3 = defineButton("3", jp);
		button4 = defineButton("4", jp);
		nextInstructionToUser();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			text.setText("button 1 is pushed");
			reactToPushedButton(button1);
		} else if (e.getSource() == button2) {
			text.setText("button 2 is pushed");
			reactToPushedButton(button2);
		} else if (e.getSource() == button3) {
			text.setText("button 3 is pushed");
			reactToPushedButton(button3);
		} else if (e.getSource() == button4) {
			text.setText("button 4 is pushed");
			reactToPushedButton(button4);
		}
		
	}
	
	private void nextInstructionToUser() {
		int i = RandomNumber.between(1, 4);
		text.setText("Push Button " + i);
		switch (i) {
			case 1: nextButton = button1; break;
			case 2: nextButton = button2; break;
			case 3: nextButton = button3; break;
			case 4: nextButton = button4; break;
		}
	}
	
	private void reactToPushedButton(JButton b) {
		if (nextButton == b) {
			nextInstructionToUser();
		} else {
			text.setText("GAME OVER");
		}
	}
	
	private JButton defineButton(String text, JPanel jp) {
		JButton button = new JButton(text);
		button.addActionListener(this);
		jp.add(button, BorderLayout.CENTER);
		return button;
	}
}
