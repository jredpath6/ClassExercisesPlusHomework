import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MyApplet extends JApplet {
	public void init() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(2, 1));
		JPanel holdPanel = new JPanel();
		JPanel upperTextPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel lowerTextPanel = new JPanel();
		
		upperTextPanel.add(new JTextField("", 20), );
		upperTextPanel.setBorder(new LineBorder(Color.black));
		
		buttonPanel.setLayout(new GridLayout(1,1));
		buttonPanel.add(createButtons());
		this.add(upperTextPanel);
		this.add(buttonPanel);
		
	}
	
	public JPanel createButtons() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		//FIRST ROW
		GridBagConstraints c;
		//add 7 button: top row, first column
		c = new GridBagConstraints();
		c.gridx = 0; //First column
		c.gridy = 0; //First row
		buttons.add(new JButton("7"), c);
		//add 8 button: top row, second column
		c = new GridBagConstraints();
		c.gridx = 1; //Second column
		c.gridy = 0; //First row
		buttons.add(new JButton("8"), c);
		//add 9 button: top row, third column
		c = new GridBagConstraints();
		c.gridx = 2; //Third column
		c.gridy = 0; //First row
		buttons.add(new JButton("9"), c);
		//add 9 button: top row, fourth column
		c = new GridBagConstraints();
		c.gridx = 3; //Fourth column
		c.gridy = 0; //First row
		buttons.add(new JButton("/"), c);
		//SECOND ROW
		//add 7 button: second row, first column
		c = new GridBagConstraints();
		c.gridx = 0; //First column
		c.gridy = 1; //Second row
		buttons.add(new JButton("4"), c);
		//add 8 button: second row, second column
		c = new GridBagConstraints();
		c.gridx = 1; //Second column
		c.gridy = 1; //Second row
		buttons.add(new JButton("5"), c);
		//add 9 button: second row, third column
		c = new GridBagConstraints();
		c.gridx = 2; //Third column
		c.gridy = 1; //Second row
		buttons.add(new JButton("6"), c);
		//add 9 button: second row, fourth column
		c = new GridBagConstraints();
		c.gridx = 3; //Fourth column
		c.gridy = 1; //Second row
		buttons.add(new JButton("*"), c);
		
		buttons.setVisible(true);
		return buttons;
	}
}
