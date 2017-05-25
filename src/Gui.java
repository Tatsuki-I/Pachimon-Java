import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Gui implements ActionListener {

	Trainer player;

	int[][] playerPlace;

	JFrame frame;

	JPanel display;
	JPanel[][] placePanel = new JPanel[10][10];

	JPanel leftBoard;


	JButton UP;
	JButton DOWN;
	JButton LEFT;
	JButton RIGHT;
	JButton MENU;
	JPanel controlKey;

	JPanel textPanel;
	JLabel set[] = new JLabel[8];
	String setTextStr[] = new String[8];

	JPanel layoutPanel;

	JPanel rigthBoard;


	JPanel boardPanel;




	Gui(String title,final Trainer PLAYER){

		this.frame = new JFrame(title);

		this.frame.setSize(650,460);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.display = new JPanel();
		this.display.setPreferredSize(new Dimension(400,400));
		this.display.setLayout(new GridLayout(10,10));

		for(int i = 0;i < placePanel.length;i++){
			for(int j = 0;j < placePanel[i].length;j++){
				placePanel[i][j] = new JPanel();
				placePanel[i][j].setPreferredSize(new Dimension(20,20));
				this.display.add(this.placePanel[i][j]);
			}
		}

		this.leftBoard = new JPanel();
		this.leftBoard.setLayout(new FlowLayout());
		this.leftBoard.add(display);

		this.set[0] = new JLabel();
		this.set[1] = new JLabel();
		this.set[2] = new JLabel();
		this.set[3] = new JLabel();
		this.set[4] = new JLabel();
		this.set[5] = new JLabel();
		this.set[6] = new JLabel();
		this.set[7] = new JLabel();

		this.set[0].setLayout(new BoxLayout(this.set[0],BoxLayout.Y_AXIS));
		this.set[1].setLayout(new BoxLayout(this.set[1],BoxLayout.Y_AXIS));
		this.set[2].setLayout(new BoxLayout(this.set[2],BoxLayout.Y_AXIS));
		this.set[3].setLayout(new BoxLayout(this.set[3],BoxLayout.Y_AXIS));
		this.set[4].setLayout(new BoxLayout(this.set[4],BoxLayout.Y_AXIS));
		this.set[5].setLayout(new BoxLayout(this.set[5],BoxLayout.Y_AXIS));
		this.set[6].setLayout(new BoxLayout(this.set[6],BoxLayout.Y_AXIS));
		this.set[7].setLayout(new BoxLayout(this.set[7],BoxLayout.Y_AXIS));

		this.set[0].setPreferredSize(new Dimension(200,20));
		this.set[1].setPreferredSize(new Dimension(200,20));
		this.set[2].setPreferredSize(new Dimension(200,20));
		this.set[3].setPreferredSize(new Dimension(200,20));
		this.set[4].setPreferredSize(new Dimension(200,20));
		this.set[5].setPreferredSize(new Dimension(200,20));
		this.set[6].setPreferredSize(new Dimension(200,20));
		this.set[7].setPreferredSize(new Dimension(200,20));

		this.set[0].setFont(new Font("", Font.PLAIN, 18));
		this.set[1].setFont(new Font("", Font.PLAIN, 18));
		this.set[2].setFont(new Font("", Font.PLAIN, 18));
		this.set[3].setFont(new Font("", Font.PLAIN, 18));
		this.set[4].setFont(new Font("", Font.PLAIN, 18));
		this.set[5].setFont(new Font("", Font.PLAIN, 18));
		this.set[6].setFont(new Font("", Font.PLAIN, 18));
		this.set[7].setFont(new Font("", Font.PLAIN, 18));


		this.textPanel = new JPanel();
		this.textPanel.setPreferredSize(new Dimension(200,200));
		this.textPanel.add(set[0]);
		this.textPanel.add(set[1]);
		this.textPanel.add(set[2]);
		this.textPanel.add(set[3]);
		this.textPanel.add(set[4]);
		this.textPanel.add(set[5]);
		this.textPanel.add(set[6]);
		this.textPanel.add(set[7]);

		this.UP = new JButton("↑");
		this.DOWN = new JButton("↓");
		this.LEFT = new JButton("←");
		this.RIGHT = new JButton("→");
		this.MENU = new JButton("○");

		this.UP.setBorder(new LineBorder(Color.BLACK, 2));
		this.DOWN.setBorder(new LineBorder(Color.BLACK, 2));
		this.LEFT.setBorder(new LineBorder(Color.BLACK, 2));
		this.RIGHT.setBorder(new LineBorder(Color.BLACK, 2));
		this.MENU.setBorder(new LineBorder(Color.WHITE, 2));

		this.UP.setActionCommand("UP");
		this.DOWN.setActionCommand("DOWN");
		this.LEFT.setActionCommand("LEFT");
		this.RIGHT.setActionCommand("RIGHT");
		this.MENU.setActionCommand("MENU");

		this.UP.addActionListener(this);
		this.DOWN.addActionListener(this);
		this.LEFT.addActionListener(this);
		this.RIGHT.addActionListener(this);
		this.MENU.addActionListener(this);

		this.controlKey = new JPanel();
		this.controlKey.setPreferredSize(new Dimension(200,200));
		this.controlKey.setLayout(new GridLayout(3,3));

		this.controlKey.add(new JPanel());
		this.controlKey.add(UP);
		this.controlKey.add(new JPanel());
		this.controlKey.add(LEFT);
		this.controlKey.add(MENU);
		this.controlKey.add(RIGHT);
		this.controlKey.add(new JPanel());
		this.controlKey.add(DOWN);
		this.controlKey.add(new JPanel());

		this.rigthBoard = new JPanel();
		this.rigthBoard.setLayout(new BoxLayout(this.rigthBoard,BoxLayout.Y_AXIS));


		this.rigthBoard.add(textPanel);
		this.rigthBoard.add(controlKey);


		this.boardPanel = new JPanel();
		this.boardPanel.setLayout(new FlowLayout(FlowLayout.LEFT));;

		this.boardPanel.add(this.leftBoard);
		this.boardPanel.add(this.rigthBoard);

		this.frame.getContentPane().add(this.boardPanel);

		this.frame.setVisible(true);

		System.out.println();

		this.player = PLAYER;

		this.guiDisplay();
	}
	void guiDisplay(){
		playerPlace = Map.screen(this.player.currentY,this.player.currentX);
		for(int i = 0;i < playerPlace.length;i++){
			for(int j = 0;j < playerPlace[i].length;j++){
				switch(playerPlace[i][j]){
					case 0:
						placePanel[i][j].setBackground(Color.BLACK);
						this.placePanel[i][j].repaint();
						break;
					case 1:
						placePanel[i][j].setBackground(Color.GREEN);
						this.placePanel[i][j].repaint();
						break;
					case 2:
						placePanel[i][j].setBackground(Color.BLUE);
						this.placePanel[i][j].repaint();
						break;
					case 5:
						placePanel[i][j].setBackground(Color.RED);
						this.placePanel[i][j].repaint();
						break;
				}
			}
		}
	}
	void setTextPanel(String textadd){
		this.set[1].setText(setTextStr[0]);
		this.set[2].setText(setTextStr[1]);
		this.set[3].setText(setTextStr[2]);
		this.set[4].setText(setTextStr[3]);
		this.set[5].setText(setTextStr[4]);
		this.set[6].setText(setTextStr[5]);
		this.set[7].setText(setTextStr[6]);

		this.set[0].setText(textadd);
		this.setTextStr[6] = this.setTextStr[5];
		this.setTextStr[5] = this.setTextStr[4];
		this.setTextStr[4] = this.setTextStr[3];
		this.setTextStr[3] = this.setTextStr[2];
		this.setTextStr[2] = this.setTextStr[1];
		this.setTextStr[1] = this.setTextStr[0];
		this.setTextStr[0] = textadd;







		this.textPanel.repaint();
	}


	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if(cmd.equals("UP")){
			this.player.upMove();
			this.guiDisplay();
			setTextPanel("座標" + this.player.currentY + "." + this.player.currentX);
		}else if(cmd.equals("DOWN")){
			this.player.downMove();
			this.guiDisplay();
			setTextPanel("座標" + this.player.currentY + "." + this.player.currentX);
		}else if(cmd.equals("LEFT")){
			this.player.leftMove();
			this.guiDisplay();
			setTextPanel("座標" + this.player.currentY + "." + this.player.currentX);
		}else if(cmd.equals("RIGHT")){
			this.player.rightMove();
			this.guiDisplay();
			setTextPanel("座標" + this.player.currentY + "." + this.player.currentX);
		}else if(cmd.equals("MENU")){
			System.out.println("テスト");
			System.out.println();
		}
	}
}

