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
import javax.swing.border.LineBorder;

class Gui{

	private Trainer player;

	private final int FRAME_SIZE = 600;

	private JFrame frame;

	private JPanel boardPanel;

	private JPanel display;
	private JLabel[][] placePanel = new JLabel[Map.HEIGHT][Map.WIDTH];

	static JPanel textPanel;
	static JLabel set[] = new JLabel[16];
	static String setTextStr[] = new String[16];

	static JPanel battleTextPanel;
	static JLabel battleSet[] = new JLabel[10];
	static String battleSetTextStr[] = new String[10];

	private JPanel battleStatusPanel[] = new JPanel[2];
	static JLabel battleStatusLabel[] = new JLabel[6];

	private JPanel battleSkillsPanel;
	private JButton battleSkillsButton[] = new JButton[4];

	private JPanel battleStats;

	private JPanel battlePanel;



	static CardLayout Layout;
	static JPanel changePanel;


	Gui(String title,final Trainer PLAYER){
		this.player = PLAYER;

		this.frame = new JFrame(title);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//マップのパネル
		this.display = new JPanel();
		this.display.setPreferredSize(new Dimension(this.FRAME_SIZE*2/3,this.FRAME_SIZE*2/3));
		this.display.setLayout(new GridLayout(Map.HEIGHT,Map.WIDTH));
		this.display.setBorder(new LineBorder(Color.DARK_GRAY,2));
		this.display.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));

		//マップを構成してるパネルの初期設定
		for(int i = 0;i < Map.HEIGHT;i++){
			for(int j = 0;j < Map.WIDTH;j++){
				this.placePanel[i][j] = new JLabel();
				this.placePanel[i][j].setOpaque(true);

				this.display.add(this.placePanel[i][j]);
			}
		}

		//テキスト表示のパネル
		Gui.textPanel = new JPanel();
		Gui.textPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		Gui.textPanel.setPreferredSize(new Dimension(FRAME_SIZE*1/3,FRAME_SIZE*2/3));
		Gui.textPanel.setBorder(new LineBorder(Color.DARK_GRAY,2));
		Gui.textPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		for(int i = 0;i < Gui.set.length;i++){
			Gui.set[i] = new JLabel();
			Gui.set[i].setLayout(new BoxLayout(Gui.set[i],BoxLayout.Y_AXIS));
			Gui.set[i].setPreferredSize(new Dimension(this.FRAME_SIZE*1/3,this.FRAME_SIZE*2/3/Gui.set.length));
			Gui.set[i].setFont(new Font("",Font.PLAIN, 16));
			Gui.set[i].setBorder(new LineBorder(Color.BLACK,1));
			Gui.textPanel.add(Gui.set[i]);
		}

		//マップ移動画面
		this.boardPanel = new JPanel();
		this.boardPanel.add(this.display);
		this.boardPanel.add(Gui.textPanel);

		//battlePanelのテキストパネル
		Gui.battleTextPanel = new JPanel();
		Gui.battleTextPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		Gui.battleTextPanel.setPreferredSize(new Dimension(this.FRAME_SIZE*2/3,this.FRAME_SIZE*2/3));
		Gui.battleTextPanel.setBorder(new LineBorder(Color.BLACK));
		for(int i = 0;i < Gui.battleSet.length;i++){
			Gui.battleSet[i] = new JLabel();
			Gui.battleSet[i].setLayout(new BoxLayout(Gui.battleSet[i],BoxLayout.Y_AXIS));
			Gui.battleSet[i].setPreferredSize(new Dimension(this.FRAME_SIZE*2/3,this.FRAME_SIZE*2/3/Gui.battleSet.length));
			Gui.battleSet[i].setFont(new Font("",Font.PLAIN, 18));
			Gui.battleSet[i].setBorder(new LineBorder(Color.BLACK));
			Gui.battleTextPanel.add(Gui.battleSet[i]);
		}
		//パチモンのステータス表示パネル
		for(int i = 0;i < this.battleStatusPanel.length;i++){
			this.battleStatusPanel[i] = new JPanel();
			this.battleStatusPanel[i].setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
			this.battleStatusPanel[i].setPreferredSize(new Dimension(this.FRAME_SIZE*1/3,this.FRAME_SIZE*2/3*3/10));
			this.battleStatusPanel[i].setBorder(new LineBorder(Color.BLACK));
		}
		for(int i = 0;i < Gui.battleStatusLabel.length;i++){
			Gui.battleStatusLabel[i] = new JLabel();
			Gui.battleStatusLabel[i].setLayout(new BoxLayout(Gui.battleStatusLabel[i],BoxLayout.Y_AXIS));
			Gui.battleStatusLabel[i].setPreferredSize(new Dimension(this.FRAME_SIZE*1/3,this.FRAME_SIZE*2/5/Gui.battleStatusLabel.length));
			Gui.battleStatusLabel[i].setFont(new Font("",Font.PLAIN, 18));
			if(i < 3){
				this.battleStatusPanel[0].add(Gui.battleStatusLabel[i]);
			}else{
				this.battleStatusPanel[1].add(Gui.battleStatusLabel[i]);
			}
		}

		//battlePanelのスキルボタン
		this.battleSkillsPanel = new JPanel(new GridLayout(4,0));
		this.battleSkillsPanel.setPreferredSize(new Dimension(this.FRAME_SIZE*1/3,this.FRAME_SIZE*2/3*4/10));
		this.battleSkillsPanel.setBorder(new LineBorder(Color.BLACK));
		this.battleSkillsPanel.setOpaque(true);
		for(int i = 0;i < this.battleSkillsButton.length;i++){
			this.battleSkillsButton[i] = new JButton(this.player.getHasMonsters(0).skills.skills[i].NAME);
			this.battleSkillsButton[i].setActionCommand(i + "(skill)");
			this.battleSkillsPanel.add(this.battleSkillsButton[i]);
			this.battleSkillsButton[i].setOpaque(false);
			this.battleSkillsButton[i].addActionListener(new Battle());
			this.battleSkillsButton[i].addKeyListener(new KeyEvent(player,this));
		}
		this.battleStats = new JPanel();
		this.battleStats.setPreferredSize(new Dimension(this.FRAME_SIZE*1/3,this.FRAME_SIZE*2/3));
		this.battleStats.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		this.battleStats.add(this.battleStatusPanel[0]);
		this.battleStats.add(this.battleStatusPanel[1]);
		this.battleStats.add(this.battleSkillsPanel);
		//バトルパネル配置
		this.battlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		this.battlePanel.add(Gui.battleTextPanel);
		this.battlePanel.add(this.battleStats);
		this.battlePanel.addKeyListener(new KeyEvent(player,this));

		//画面の切り替え
		Gui.Layout = new CardLayout();

		Gui.changePanel = new JPanel();
		Gui.changePanel.add(this.battlePanel);
		Gui.changePanel.add(this.boardPanel);
		Gui.changePanel.setLayout(Gui.Layout);
		Gui.Layout.next(Gui.changePanel);
		//-----------------------------------------------------
		//Gui.Layout.next(Gui.changePanel);
		//-----------------------------------------------------
		this.frame.getContentPane().add(Gui.changePanel);
		this.frame.setVisible(true);

		this.frame.pack();

		this.frame.addKeyListener(new KeyEvent(player,this));
		this.frameFocus();
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
		for(int i = 0;i < Map.HEIGHT;i++){
			for(int j = 0;j < Map.WIDTH;j++){
				switch(Map.screen(this.player.getCurrentY(),this.player.getCurrentX())[i][j]){
					case 0:
						this.placePanel[i][j].setBackground(Color.BLACK);
						this.placePanel[i][j].setText("");
						this.placePanel[i][j].repaint();
						break;
					case 1:
						this.placePanel[i][j].setBackground(Color.GREEN);
						this.placePanel[i][j].setText("");
						this.placePanel[i][j].repaint();
						break;
					case 2:
						this.placePanel[i][j].setBackground(Color.BLUE);
						this.placePanel[i][j].setText("");
						this.placePanel[i][j].repaint();
						break;
					case 5:
						this.placePanel[i][j].setBackground(Color.RED);
						this.placePanel[i][j].setText(this.player.getFace());
						this.placePanel[i][j].setFont(new Font("",Font.PLAIN, 18));
						this.placePanel[i][j].repaint();
						break;
				}
			}
		}
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
	//マップ移動画面のテキストを設定
	static void battleSetTextPanel(String textadd){
		for(int i = 0;i < Gui.battleSet.length-1;i++){
			Gui.battleSet[i+1].setText(Gui.battleSetTextStr[i]);
		}
		Gui.battleSet[0].setText(textadd);
		for(int i = Gui.battleSetTextStr.length-1;i > 0;i--){
			Gui.battleSetTextStr[i] = Gui.battleSetTextStr[i-1];
		}

		Gui.battleSetTextStr[0] = textadd;

		Gui.battleTextPanel.repaint();
	}
	static void setBattleStatus(Monster my,Monster enemy){
		Gui.battleStatusLabel[0].setText(enemy.getNickname());
		Gui.battleStatusLabel[1].setText("Lv\t" + enemy.getCurrentLevel());
		Gui.battleStatusLabel[2].setText("HP\t" + enemy.getCurrentHp());
		Gui.battleStatusLabel[3].setText(my.getNickname());
		Gui.battleStatusLabel[4].setText("Lv\t" + my.getCurrentLevel());
		Gui.battleStatusLabel[5].setText("HP\t" + my.getCurrentHp());
		Gui.battleStatusLabel[0].repaint();
		Gui.battleStatusLabel[1].repaint();
		Gui.battleStatusLabel[2].repaint();
        Gui.battleStatusLabel[3].repaint();
        Gui.battleStatusLabel[4].repaint();
        Gui.battleStatusLabel[5].repaint();
	}
}