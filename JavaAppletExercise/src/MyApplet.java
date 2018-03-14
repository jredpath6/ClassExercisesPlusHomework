import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MyApplet extends JApplet {
	public JPanel createButtons() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		// FIRST ROW
		GridBagConstraints c = new GridBagConstraints();
		c.ipady = 15; // Set universal button size
		c.ipadx = 5;
		c.gridy = 0; // First row
		// add 7 button
		c.gridx = 0; // First column
		buttons.add(new JButton("7"), c);
		// add 8 button
		c.gridx = 1; // Second column
		buttons.add(new JButton("8"), c);
		// add 9 button
		c.gridx = 2; // Third column
		buttons.add(new JButton("9"), c);
		// add / button
		c.gridx = 3; // Fourth column
		buttons.add(new JButton("/"), c);

		// SECOND ROW
		c = new GridBagConstraints(); // new set of row/col constraints
		c.ipady = 15; // Set universal button size
		c.ipadx = 5;
		c.gridy = 1; // Second row
		// add 4 button
		c.gridx = 0; // First column
		buttons.add(new JButton("4"), c);
		// add 5 button
		c.gridx = 1; // Second column
		buttons.add(new JButton("5"), c);
		// add 6 button
		c.gridx = 2; // Third column
		buttons.add(new JButton("6"), c);
		// add * button
		c.gridx = 3; // Fourth column
		buttons.add(new JButton("*"), c);

		// THIRD ROW
		c = new GridBagConstraints();
		c.ipady = 15; // Set universal button size
		c.ipadx = 5;
		c.gridy = 2; // Third row
		// add 1 button
		c.gridx = 0; // First column
		buttons.add(new JButton("1"), c);
		// add 5 button
		c.gridx = 1; // Second column
		buttons.add(new JButton("5"), c);
		// add 3 button
		c.gridx = 2; // Third column
		buttons.add(new JButton("3"), c);
		// add - button
		c.gridx = 3; // Fourth column
		buttons.add(new JButton("-"), c);

		// FOURTH ROW
		c = new GridBagConstraints();
		c.ipady = 15; // Set universal button size
		c.ipadx = 5;
		c.gridy = 3; // Fourth row
		// add 0 button
		c.gridx = 0; // First column
		buttons.add(new JButton("0"), c);
		// add . button
		c.gridx = 1; // Second column
		buttons.add(new JButton("."), c);
		// add = button
		c.gridx = 2; // Third column
		buttons.add(new JButton("="), c);
		// add + button
		c.gridx = 3; // Fourth column
		buttons.add(new JButton("+"), c);

		buttons.setVisible(true);
		return buttons;
	}

	@Override
	public void init() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		JPanel holdPanel = new JPanel();
		JPanel upperTextPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel lowerTextPanel = new JPanel();

		upperTextPanel.add(new JTextField("", 25));
		upperTextPanel.setBorder(new LineBorder(Color.black));

		buttonPanel.setLayout(new GridLayout(1, 1));
		buttonPanel.add(createButtons());
		this.add(upperTextPanel, BorderLayout.PAGE_START);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.setSize(325, 225);

	}
}
