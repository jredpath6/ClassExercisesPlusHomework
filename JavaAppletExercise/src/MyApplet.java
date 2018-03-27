import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MyApplet extends JApplet implements ActionListener, TextListener{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
	JButton add, sub, mul, div, equal, point;
	JTextField t1;
	String s,s1,s2,s3,s4;
	double a,b,c;
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
		buttons.add(b7 = new JButton("7"), c);
		// add 8 button
		c.gridx = 1; // Second column
		buttons.add(b8 = new JButton("8"), c);
		// add 9 button
		c.gridx = 2; // Third column
		buttons.add(b9 = new JButton("9"), c);
		// add / button
		c.gridx = 3; // Fourth column
		buttons.add(div = new JButton("/"), c);

		// SECOND ROW
		c = new GridBagConstraints(); // new set of row/col constraints
		c.ipady = 15; // Set universal button size
		c.ipadx = 5;
		c.gridy = 1; // Second row
		// add 4 button
		c.gridx = 0; // First column
		buttons.add(b4 = new JButton("4"), c);
		// add 5 button
		c.gridx = 1; // Second column
		buttons.add(b5 = new JButton("5"), c);
		// add 6 button
		c.gridx = 2; // Third column
		buttons.add(b6 = new JButton("6"), c);
		// add * button
		c.gridx = 3; // Fourth column
		buttons.add(mul = new JButton("*"), c);

		// THIRD ROW
		c = new GridBagConstraints();
		c.ipady = 15; // Set universal button size
		c.ipadx = 5;
		c.gridy = 2; // Third row
		// add 1 button
		c.gridx = 0; // First column
		buttons.add(b1 = new JButton("1"), c);
		// add 2 button
		c.gridx = 1; // Second column
		buttons.add(b2 = new JButton("2"), c);
		// add 3 button
		c.gridx = 2; // Third column
		buttons.add(b3 = new JButton("3"), c);
		// add - button
		c.gridx = 3; // Fourth column
		buttons.add(sub = new JButton("-"), c);

		// FOURTH ROW
		c = new GridBagConstraints();
		c.ipady = 15; // Set universal button size
		c.ipadx = 5;
		c.gridy = 3; // Fourth row
		// add 0 button
		c.gridx = 0; // First column
		buttons.add(b0 = new JButton("0"), c);
		// add . button
		c.gridx = 1; // Second column
		buttons.add(point = new JButton("."), c);
		// add = button
		c.gridx = 2; // Third column
		buttons.add(equal = new JButton("="), c);
		// add + button
		c.gridx = 3; // Fourth column
		buttons.add(add = new JButton("+"), c);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		point.addActionListener(this);
		equal.addActionListener(this);

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

		upperTextPanel.add(t1 = new JTextField("", 25));
		upperTextPanel.setBorder(new LineBorder(Color.black));

		buttonPanel.setLayout(new GridLayout(1, 1));
		buttonPanel.add(createButtons());
		this.add(upperTextPanel, BorderLayout.PAGE_START);
		this.add(buttonPanel, BorderLayout.CENTER);
		this.setSize(325, 225);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s = e.getActionCommand();
		System.out.print(s);
		 if(s.equals("0")||s.equals("1")||s.equals("2")||
				 s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8")||
				 s.equals("9")||s.equals("0") || s.equals(".")) {
				    s1=t1.getText()+s;
				    t1.setText(s1);
		 }
				   if(s.equals("+")) {
				      s2=t1.getText();
				      t1.setText("");
				      s3="+";
				   }
				   if(s.equals("-")) {
				      s2=t1.getText();
				      t1.setText("");
				      s3="-";
				   }
				   if(s.equals("*")) {
				      s2=t1.getText();
				      //t1.setText("");
				      s3="*";
				   }
				   if(s.equals("/")) {
					      s2=t1.getText();
					      t1.setText("");
					      s3="/";
					   }
				   if(s.equals("*")) {
				      s2=t1.getText();
				      t1.setText("");
				      s3="*";
				   }
				   if(s.equals("=")) {
					   if(t1.getText() == "" | t1.getText() == null) {
						   System.out.print("Error");
					   }
				    s4=t1.getText();
				    a=Double.parseDouble(s2);
				    b=Double.parseDouble(s4);
				    if(s3.equals("+")) {
				    		c=a+b;
				    		System.out.print(c+"\n");
				    }
				    if(s3.equals("-")) {
				    		c=a-b;
				    		System.out.print(c+"\n");
				    }
				    if(s3.equals("*")) {
					    c=a*b;
				    		System.out.print(c+"\n");
				    }
				    if(s3.equals("/")) {
					    c=a/b;
				    		System.out.print(c+"\n");
				    }
				    
				    t1.setText(String.valueOf(c));
				   }
				   
				   if(s.equals("Clear"))
				   {
				    t1.setText("");
				   }
	}

	@Override
	public void textValueChanged(TextEvent arg0) {
		// Empty.
	}
		
}

