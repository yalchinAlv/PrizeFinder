import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * @author Yalchin Aliyev
 * @version 0.01 15.03.2016
 *
 */

public class MainFrame extends JFrame {

	private JPanel contentPane;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new MainPanel( 5, 5);
		setContentPane(contentPane);
		setVisible(true);
	}

}
