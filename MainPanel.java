import javax.swing.JPanel;

import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

/**
 * 
 * @author Yalchin Aliyev
 * @version 0.01 15.03.2016
 *
 */

public class MainPanel extends JPanel implements ActionListener{

	// properties
	private ArrayList<JButton> buttons;
	private int attempts;
	private JLabel label;
	private int prize;
	private boolean isGameOver;
	
	public MainPanel( int x, int y) {
		
		isGameOver = false;
		prize = (int)(Math.random() * x*y);
		attempts = 0;
		JPanel subPanel = new JPanel();
		buttons = new ArrayList<JButton>();
		
		// adding buttons to subPanel
		for (int i = 0; i < x*y; i++) {
			
			buttons.add( new JButton( "Box " + (i + 1)));
			buttons.get(i).addActionListener( this);
			subPanel.add( buttons.get(i));
		}
		subPanel.setLayout( new GridLayout( x, y, 5, 5));
		
		setLayout( new BorderLayout( 0, 5));
		label = new JLabel( "     Attempts: " + attempts);
		label.setFont(new Font("Tahoma", Font.BOLD, 19));
		add( label, BorderLayout.PAGE_START);
		add(subPanel, BorderLayout.CENTER);
		System.out.println(prize +1);
	}

	// action performs when each button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton) e.getSource();
		
		if ( buttons.indexOf(button) == prize && !isGameOver) {
			
			label.setText( "     You got it in " + ++attempts + " attempts!");
			button.setBackground( Color.GREEN);
			isGameOver = true;
		}
		else if ( !button.getBackground().equals( Color.RED) && !isGameOver) {
			
			attempts++;
			label.setText( "     Attempts: " + attempts);
			button.setBackground( Color.RED);
		}
		
	}

}
