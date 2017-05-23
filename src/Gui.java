import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui implements ActionListener {

	Map map;
	JFrame frame;

	JButton UP;
	JButton DOWN;
	JButton LEFT;
	JButton RIGHT;

	JLabel display;
	JLabel appearKondo;

	JPanel board;
	JPanel pal;
	JPanel panel;

	Gui(String title, Map mapClass){


		this.frame = new JFrame(title);

		this.frame.setSize(600,420);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.UP = new JButton("↑");
		this.DOWN = new JButton("↓");
		this.LEFT = new JButton("←");
		this.RIGHT = new JButton("→");

		this.UP.setActionCommand("UP");
		this.DOWN.setActionCommand("DOWN");
		this.LEFT.setActionCommand("LEFT");
		this.RIGHT.setActionCommand("RIGHT");

		this.appearKondo = new JLabel();

		this.board = new JPanel();
		this.display = new JLabel();

		this.board.add(display,BorderLayout.NORTH);
		this.board.add(appearKondo,BorderLayout.SOUTH);



		this.UP.addActionListener(this);
		this.DOWN.addActionListener(this);
		this.LEFT.addActionListener(this);
		this.RIGHT.addActionListener(this);

		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(3,3));;

		this.panel.add(new JPanel());
		this.panel.add(UP);
		this.panel.add(new JPanel());
		this.panel.add(LEFT);
		this.panel.add(new JPanel());
		this.panel.add(RIGHT);
		this.panel.add(new JPanel());
		this.panel.add(DOWN);
		this.panel.add(new JPanel());

		this.pal = new JPanel();
		this.pal.setLayout(new GridLayout(0,2));;

		this.pal.add(this.board);
		this.pal.add(this.panel);

		this.frame.getContentPane().add(this.pal);

		this.frame.setVisible(true);
		this.map = mapClass;

		this.map.display(this.map.y,this.map.x);
		System.out.println();
	}
	void guiDisplay(){
		this.display.setText(this.map.str);
		this.appearKondo.setText(this.map.kondoAlart);
		this.display.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if(cmd.equals("UP")){
			this.map.upMove();
			this.guiDisplay();
		}else if(cmd.equals("DOWN")){
			this.map.downMove();
			this.guiDisplay();
		}else if(cmd.equals("LEFT")){
			this.map.leftMove();
			this.guiDisplay();
		}else if(cmd.equals("RIGHT")){
			this.map.rightMove();
			this.guiDisplay();
		}
	}
}

