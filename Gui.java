import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui implements ActionListener {

	Map map;
	Gui(String title, Map mapClass){


		JFrame frame = new JFrame(title);

		frame.setBounds(100,100,800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton UP = new JButton("↑");
		UP.addActionListener(this);
		UP.setActionCommand("UP");

		JButton DOWN = new JButton("↓");
		DOWN.addActionListener(this);
		DOWN.setActionCommand("DOWN");
		
		JButton LEFT = new JButton("←");
		LEFT.addActionListener(this);
		LEFT.setActionCommand("LEFT");
		
		JButton RIGHT = new JButton("→");
		RIGHT.addActionListener(this);
		RIGHT.setActionCommand("RIGHT");

		JPanel OPRATION = new JPanel();

		OPRATION.add(UP);
		OPRATION.add(DOWN);
		OPRATION.add(LEFT);
		OPRATION.add(RIGHT);
		

		frame.getContentPane().add(OPRATION);
		frame.setVisible(true);
		this.map = mapClass;
		
		this.map.display(this.map.y,this.map.x);
		System.out.println();
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if(cmd.equals("UP")){
			this.map.upMove();
		}else if(cmd.equals("DOWN")){
			this.map.downMove();
		}else if(cmd.equals("LEFT")){
			this.map.leftMove();
		}else if(cmd.equals("RIGHT")){
			this.map.rightMove();
		}
	}

}
