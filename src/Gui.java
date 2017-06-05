import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui{

	private Trainer player;

	private int[][] playerPlace;

	private JFrame frame;

	private JPanel boardPanel;

	private JPanel display;
	private JLabel[][] placePanel = new JLabel[Map.HEIGHT][Map.WIDTH];

	static JPanel textPanel;
	static JLabel set[] = new JLabel[16];
	static String setTextStr[] = new String[16];

	static JPanel battleTextPanel;
	static JLabel battleSet[] = new JLabel[8];
	static String battleSetTextStr[] = new String[8];

	private JPanel battleSkillsPanel;
	private JButton battleSkillsButton[] = new JButton[4];

	private JPanel battlePanel;

	static CardLayout Layout;
	static JPanel changePanel;


	Gui(String title,final Trainer PLAYER){
		this.player = PLAYER;

		this.frame = new JFrame(title);
		this.frame.setSize(650,460);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//マップのパネル
		this.display = new JPanel();
		this.display.setPreferredSize(new Dimension(400,400));
		this.display.setLayout(new GridLayout(Map.HEIGHT,Map.WIDTH));

		//マップを構成してるパネルの初期設定
		for(int i = 0;i < Map.HEIGHT;i++){
			for(int j = 0;j < Map.WIDTH;j++){
				this.placePanel[i][j] = new JLabel();
				this.placePanel[i][j].setOpaque(true);
				this.placePanel[i][j].setPreferredSize(new Dimension(400/this.placePanel.length,400/this.placePanel[i].length));
				this.display.add(this.placePanel[i][j]);
			}
		}

		//テキスト表示のパネル
		Gui.textPanel = new JPanel();
		Gui.textPanel.setPreferredSize(new Dimension(200,400));

		for(int i = 0;i < Gui.set.length;i++){
			Gui.set[i] = new JLabel();
			Gui.set[i].setLayout(new BoxLayout(Gui.set[i],BoxLayout.Y_AXIS));
			Gui.set[i].setPreferredSize(new Dimension(200,400/20));
			Gui.set[i].setFont(new Font("",Font.PLAIN, 18));
			Gui.textPanel.add(Gui.set[i]);
		}



		//マップ移動画面
		this.boardPanel = new JPanel();
		this.boardPanel.setLayout(new FlowLayout(FlowLayout.LEFT));;
		this.boardPanel.add(this.display);
		this.boardPanel.add(Gui.textPanel);

		//battlePanelのテキストパネル
		Gui.battleTextPanel = new JPanel();
		Gui.battleTextPanel.setPreferredSize(new Dimension(650,200));
		for(int i = 0;i < Gui.battleSet.length;i++){
			Gui.battleSet[i] = new JLabel();
			Gui.battleSet[i].setLayout(new BoxLayout(Gui.battleSet[i],BoxLayout.Y_AXIS));
			Gui.battleSet[i].setPreferredSize(new Dimension(600,20));
			Gui.battleSet[i].setFont(new Font("",Font.PLAIN, 18));
			Gui.battleTextPanel.add(Gui.battleSet[i]);
		}


		//battlePanelのスキルボタン
		this.battleSkillsPanel = new JPanel(new GridLayout(2,2));
		this.battleSkillsPanel.setOpaque(true);
		for(int i = 0;i < battleSkillsButton.length;i++){
			this.battleSkillsButton[i] = new JButton(this.player.getHasMonsters(0).skills.skills[i].NAME);
			this.battleSkillsButton[i].setActionCommand(i + "(skill)");
			this.battleSkillsPanel.add(this.battleSkillsButton[i]);
			this.battleSkillsButton[i].setOpaque(false);
			this.battleSkillsButton[i].addActionListener(new Battle());
			this.battleSkillsButton[i].addKeyListener(new KeyEvent(player,this));
		}


		//バトルパネル配置
		this.battlePanel = new JPanel(new GridLayout(0,1));
		this.battlePanel.add(battleTextPanel);
		this.battlePanel.add(battleSkillsPanel);

		//画面の切り替え
		Gui.Layout = new CardLayout();

		Gui.changePanel = new JPanel();
		Gui.changePanel.add(this.battlePanel);
		Gui.changePanel.add(this.boardPanel);
		Gui.changePanel.setLayout(Layout);
		Gui.changePanel.addKeyListener(new KeyEvent(player,this));
		this.frame.getContentPane().add(changePanel);
		this.frame.setVisible(true);

		Gui.Layout.next(Gui.changePanel);

		this.frame.addKeyListener(new KeyEvent(player,this));

		this.guiDisplay();

	}
	void frameFocus(){
		this.frame.requestFocusInWindow();
	}
	static void battleTextPanelReset(){
		for(int i = 0;i < Gui.battleSet.length;i++){
			Gui.battleSet[i].setText("");
			Gui.battleSetTextStr[i] = "";
		}
	}
	//マップの再読み込み
	void guiDisplay(){
		playerPlace = Map.screen(this.player.getCurrentPlace()[0],this.player.getCurrentPlace()[1]);
		for(int i = 0;i < Map.HEIGHT;i++){
			for(int j = 0;j < Map.WIDTH;j++){
				switch(playerPlace[i][j]){
					case 0:
						placePanel[i][j].setBackground(Color.BLACK);
						placePanel[i][j].setText("");
						this.placePanel[i][j].repaint();
						break;
					case 1:
						placePanel[i][j].setBackground(Color.GREEN);
						placePanel[i][j].setText("");
						this.placePanel[i][j].repaint();
						break;
					case 2:
						placePanel[i][j].setBackground(Color.BLUE);
						placePanel[i][j].setText("");
						this.placePanel[i][j].repaint();
						break;
					case 5:
						placePanel[i][j].setBackground(Color.RED);
						placePanel[i][j].setText(this.player.getFace());
						placePanel[i][j].setFont(new Font("",Font.PLAIN, 18));
						this.placePanel[i][j].repaint();
						break;
				}
			}
		}
	}
	//マップ移動画面のテキストを設定
	static void battleSetTextPanel(String textadd){
		for(int i = 0;i < Gui.battleSet.length-1;i++){
			Gui.battleSet[i+1].setText(Gui.battleSetTextStr[i]);
		}
		Gui.battleSet[0].setText(textadd);

		Gui.battleSetTextStr[6] = Gui.battleSetTextStr[5];
		Gui.battleSetTextStr[5] = Gui.battleSetTextStr[4];
		Gui.battleSetTextStr[4] = Gui.battleSetTextStr[3];
		Gui.battleSetTextStr[3] = Gui.battleSetTextStr[2];
		Gui.battleSetTextStr[2] = Gui.battleSetTextStr[1];
		Gui.battleSetTextStr[1] = Gui.battleSetTextStr[0];

		Gui.battleSetTextStr[0] = textadd;

		Gui.battleTextPanel.repaint();
	}
	static void mapSetTextPanel(String textadd){
		for(int i = 0;i < Gui.set.length-1;i++){
			Gui.set[i+1].setText(Gui.setTextStr[i]);
		}
		Gui.set[0].setText(textadd);

		for(int i = Gui.setTextStr.length-1;i > 0;i--){
			Gui.setTextStr[i] = Gui.setTextStr[i-1];
		}
		Gui.setTextStr[0] = textadd;
		Gui.textPanel.repaint();
	}
}

