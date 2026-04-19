package pascalsSword;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicProgressBarUI;


public class WindowDisplay implements ActionListener{
	SwordFinisher SwordFinisher = new SwordFinisher();
	JPanel NorthPanel;
	JPanel CenterPanel;
	JFrame window;
	JButton ExportButton;
	JButton SettingButton;
	JButton TextButton;
	JButton RunButton;
	JButton PastDiceButton;
	JButton NoteButton;
	JTextField TextField;
	JLabel DiceLabel;
	JProgressBar Bar;
	JPanel BackBar;
	JScrollPane ScrollPane;
	ImageIcon Gear;
	ImageIcon Arrow;
	ImageIcon Die;
	ImageIcon Note;
	Boolean TextOnly = false;
	Color Red = new Color(255,150,150);
	Color Green = new Color(150,255,150);
	Color Top_Bar = new Color(80,80,80);
	Color Display = new Color(120,120,120);
	Color Button_Color = new Color(240,240,240);
	Color Blue = new Color(60,180,230);
	Font ButtonFont = new Font("Georgia",Font.BOLD,24);
	BigInteger[] Dice;
	JPanel[] Bars;
	JLabel[] Labels;
	JLabel[] ProbLabels;
	JTextArea DiceText;
	String FileName;
	int BarSize;int RollNum;int SetPoint;int Adder;int Digits;int BarBorderSize;int BarGap;int BarWidth;BigInteger textLength;StringBuilder Holder;
	BigInteger divisor;BigInteger num = BigInteger.valueOf(1450);BigDecimal prob;
	Border ButtonBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
	Border TextBorder = BorderFactory.createEmptyBorder(0, 5, 0, 0);
	Border BarBorder;
	PrintWriter print;
	static boolean LOBO = false;
	
	public WindowDisplay(){

		initialize();
		display();
	}
	public void initialize(){
		ImageIcon Gear = new ImageIcon(getClass().getResource("/Images/Gear.png"));
		Gear = new ImageIcon(Gear.getImage().getScaledInstance(24, 47, Gear.getImage().SCALE_SMOOTH));
		ImageIcon Arrow = new ImageIcon(getClass().getResource("/Images/Arrow.png"));
		Arrow = new ImageIcon(Arrow.getImage().getScaledInstance(38, 48, Arrow.getImage().SCALE_SMOOTH));
		ImageIcon Die = new ImageIcon(getClass().getResource("/Images/Die.png"));
		Die = new ImageIcon(Die.getImage().getScaledInstance(24, 48, Die.getImage().SCALE_SMOOTH));
		ImageIcon Note = new ImageIcon(getClass().getResource("/Images/Note.png"));
		Note = new ImageIcon(Note.getImage().getScaledInstance(40, 40, Note.getImage().SCALE_SMOOTH));

		DiceLabel = new JLabel();
		window = new JFrame();
		NorthPanel = new JPanel();
		NorthPanel.setLayout(null);
		NorthPanel.setPreferredSize(new Dimension(800,150)); //IMPORT

		CenterPanel = new JPanel();
		CenterPanel.setLayout(null);
		CenterPanel.setPreferredSize(new Dimension(800,200));
		
		ScrollPane = new JScrollPane(CenterPanel);
		ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ScrollPane.setBackground(Display);
		ScrollPane.setOpaque(true);
		
		ExportButton = new JButton("Export");
		ExportButton.setIcon(Arrow);
		ExportButton.setBounds(100,15,150,50);
		ExportButton.setHorizontalAlignment(JButton.CENTER);
		ExportButton.setMargin(new Insets(0,-9,0,-10));
		ExportButton.setFont(ButtonFont);
		ExportButton.setFocusable(false);
		ExportButton.setContentAreaFilled(false);
		//ExportButton.setBorderPainted(false);
		ExportButton.setOpaque(true);
		ExportButton.setBackground(Button_Color);
		ExportButton.setBorder(ButtonBorder);
		ExportButton.addActionListener(this);
		ExportButton.setToolTipText("To export a dice distribution.");
		
		SettingButton = new JButton("Settings");
		SettingButton.setIcon(Gear);
		SettingButton.setBounds(275,15,150,50);
		SettingButton.setHorizontalAlignment(JButton.CENTER);
		SettingButton.setMargin(new Insets(0,-9,0,-10));
		SettingButton.setFont(ButtonFont);
		//SettingButton.setFocusable(false);
		SettingButton.setContentAreaFilled(false);
		//ExportButton.setBorderPainted(false);
		SettingButton.setOpaque(true);
		SettingButton.setBackground(Button_Color);
		SettingButton.setBorder(ButtonBorder);
		SettingButton.addActionListener(this);
		SettingButton.setToolTipText("To change settings.");

		
		TextButton = new JButton("Text-only");
		TextButton.setBounds(450,15,150,50);
		TextButton.setHorizontalAlignment(JButton.CENTER);
		TextButton.setMargin(new Insets(0,-9,0,-10));
		TextButton.setFont(ButtonFont);
		TextButton.setFocusable(false);
		TextButton.setContentAreaFilled(false);
		TextButton.setOpaque(true);
		TextButton.setBackground(Red);
		TextButton.setBorder(ButtonBorder);
		TextButton.addActionListener(this);
		TextButton.setToolTipText("To show the dice distribution in a text form.");

		RunButton = new JButton("Run");
		RunButton.setBounds(1325,85,100,50);
		RunButton.setHorizontalAlignment(JButton.CENTER);
		RunButton.setMargin(new Insets(0,-9,0,-10));
		RunButton.setFont(ButtonFont);
		RunButton.setFocusable(false);
		RunButton.setContentAreaFilled(false);
		//ExportButton.setBorderPainted(false);
		RunButton.setOpaque(true);
		RunButton.setBorder(ButtonBorder);
		RunButton.addActionListener(this);
		RunButton.setToolTipText("To calculate a dice distribution.");

		
		TextField = new JTextField();
		//TextField.setPreferredSize(new Dimension(1400,50));
		TextField.setBounds(100,85,1200,50);
		TextField.setFont(ButtonFont);
		TextField.setBorder(BorderFactory.createCompoundBorder(ButtonBorder,TextBorder));
		TextField.setMargin(new Insets(0,30,0,0));
		TextField.setText("Enter dice set here");
		TextField.setMargin(new Insets(10,0,10,0));
		TextField.addFocusListener(new FocusAdapter() {
            boolean firstClick = true;

            @Override
            public void focusGained(FocusEvent t) {
                if (firstClick) {
                    TextField.setText("");
                    firstClick = false;
                }
            }
        });
		BackBar = new JPanel();
		BackBar.setBounds(625, 15, 295, 50);
		BackBar.setBackground(Button_Color);
		BackBar.setBorder(ButtonBorder);
		
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
		UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
		
		Bar = new JProgressBar();
		Bar.setUI(new BasicProgressBarUI());
		Bar.setString("Not Started");
		Bar.setBounds(625, 15, 295, 50);
		Bar.setStringPainted(true);
		Bar.setFont(ButtonFont);
		Bar.setForeground(Blue);
		Bar.setBorderPainted(false);	
		Bar.setBorder(ButtonBorder);
		
		PastDiceButton = new JButton("Past Dice");
		PastDiceButton.setBounds(845+100,15,160,50);
		PastDiceButton.setHorizontalAlignment(JButton.CENTER);
		PastDiceButton.setMargin(new Insets(0,-9,0,-10));
		PastDiceButton.setFont(ButtonFont);
		PastDiceButton.setIcon(Die);
		//SettingButton.setFocusable(false);
		PastDiceButton.setContentAreaFilled(false);
		//ExportButton.setBorderPainted(false);
		PastDiceButton.setOpaque(true);
		PastDiceButton.setBackground(Button_Color);
		PastDiceButton.setBorder(ButtonBorder);
		PastDiceButton.addActionListener(this);
		PastDiceButton.setToolTipText("To see past dice calculated.");

		
		NoteButton = new JButton("Notation");
		NoteButton.setBounds(1030+100,15,170,50);
		NoteButton.setHorizontalAlignment(JButton.CENTER);
		NoteButton.setMargin(new Insets(0,-9,0,-10));
		NoteButton.setFont(ButtonFont);
		NoteButton.setIcon(Note);
		//SettingButton.setFocusable(false);
		NoteButton.setContentAreaFilled(false);
		//ExportButton.setBorderPainted(false);
		NoteButton.setOpaque(true);
		NoteButton.setBackground(Button_Color);
		NoteButton.setBorder(ButtonBorder);
		NoteButton.addActionListener(this);
		NoteButton.setToolTipText("To see the notation of how to enter what set of dice you want.");


		window.setTitle("Pascal's Sword");
	    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    window.setSize(1600,900);
	    
		NorthPanel.setBackground(Top_Bar);
	    //NorthPanel.setBackground(Display);
	    CenterPanel.setBackground(Display);
	    
		NorthPanel.add(ExportButton);NorthPanel.add(SettingButton);NorthPanel.add(TextButton);NorthPanel.add(RunButton);NorthPanel.add(TextField);NorthPanel.add(Bar);NorthPanel.add(PastDiceButton);NorthPanel.add(NoteButton);NorthPanel.add(BackBar);CenterPanel.add(DiceLabel);
		
	    window.add(NorthPanel,BorderLayout.NORTH);
	    window.add(ScrollPane,BorderLayout.CENTER);

	}
	public void display() {
		 window.setLocationRelativeTo(null);
		 window.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){ // make sure you add a little 		TextButton.addActionListener(this);
		if(e.getSource()==TextButton) {
			if(TextOnly) {
				TextOnly=false;
				TextButton.setBackground(Red);
			}else {
				TextOnly=true;
				TextButton.setBackground(Green);
			}
		}
		if(e.getSource()==SettingButton) {
			//System.out.println("Open settings");
			WindowSettings WindowSettings = new WindowSettings();
		}if(e.getSource()==RunButton) {
			Bar.setString("In progress");
			CenterPanel.removeAll();
			FileName = TextField.getText();
			Dice = SwordFinisher.Runner(TextField.getText());
			int Length = Dice.length-1;
			Bars = new JPanel[Length];
			Labels = new JLabel[Length];
			ProbLabels = new JLabel[Length];
			DiceLabel.setText(Arrays.toString(Dice));
			divisor = BigInteger.valueOf(0);
			SetPoint = Dice[Dice.length-1].intValue();
			ExportButton.setEnabled(true);
			try {
	        	File file = new File("PastDice.csv");
	        	if (!file.exists()) {
	                file.createNewFile();
	            }
				FileWriter writer = new FileWriter(file,true);
				writer.write(TextField.getText());
				writer.write("<br>");
				writer.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			if(Settings.AutoExport.Setting == "On") {
				ExportButton.setEnabled(false);	
				File csvFile = new File(FileName+".csv");
				StringBuilder Holder = new StringBuilder();
				try {
					PrintWriter out = new PrintWriter(csvFile);
					for(int thing = 0;Dice.length>(thing+1);thing++) {
						Holder.append((SetPoint+thing)+": ");
						if(thing == Dice.length-2) {
							Holder.append(Dice[thing]);
						}else {
							Holder.append(Dice[thing]+", ");
						}
					}
					out.println(FileName+":");
					out.println(Holder.toString());
					out.close();
					ExportButton.setEnabled(false);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
			if(TextOnly == true) {
				DiceText = new JTextArea();
				DiceText.setEditable(false);
				DiceText.setFont(ButtonFont);
				DiceText.setBackground(Button_Color);
				DiceText.setBorder(ButtonBorder);
				DiceText.setLineWrap(true);
				DiceText.setWrapStyleWord(true);
				textLength = BigInteger.valueOf(0);
				StringBuilder Holder = new StringBuilder();
				for(int thing = 0;Dice.length>(thing+1);thing++) {
					Holder.append((SetPoint+thing)+": ");
					//System.out.println("thing: "+thing+"/"+Dice.length);
					if(thing == Dice.length-2) {
						Holder.append(Dice[thing]);
					}else {
						Holder.append(Dice[thing]+", ");
					}
					textLength = textLength.add(BigInteger.valueOf((Dice[thing].toString()).length()));
					textLength = textLength.add(BigInteger.valueOf((Integer.toString((SetPoint+thing))).length()));

				}
				if(WindowDisplay.LOBO == false) {
					DiceText.setText(Holder.toString());
					DiceText.setBounds(20, 20, 1400,2+BigInteger.valueOf(28).multiply(BigInteger.valueOf(3).add(textLength.divide(BigInteger.valueOf(52)))).intValue());
					CenterPanel.setPreferredSize(new Dimension(1400,BigInteger.valueOf(28).multiply(BigInteger.valueOf(1).add(textLength.divide(BigInteger.valueOf(52)))).intValue() ));
					CenterPanel.add(DiceText);
				}else if(WindowDisplay.LOBO == true) {
					System.out.println("Finished");
				}
			}else if(TextOnly == false) {
				CenterPanel.setPreferredSize(new Dimension(1400, Dice.length * 50));
				if(0>SetPoint) {
					Adder = 5;
				}else {
					Adder = 0;
				}
				Digits = 2+(int)(Math.log(Length));
				if(Digits>6) {
					Digits = 6;
				}
				for(int prob = 0;Dice.length>(prob+1);prob++) {
					divisor = divisor.add(Dice[prob]);
					//System.out.println(Dice[prob]);
				}
				if(Settings.BarBorderSize.Setting=="Auto") {
					BarBorderSize = 3;
				}else {
					BarBorderSize=Integer.parseInt(Settings.BarBorderSize.Setting);
				}
				if(Settings.BarGap.Setting=="Auto") {
					BarGap = 10;
				}else {
					BarGap=Integer.parseInt(Settings.BarGap.Setting);
				}
				if(Settings.BarWidth.Setting=="Auto") {
					BarWidth = 40;
				}else {
					BarWidth=Integer.parseInt(Settings.BarWidth.Setting);
				}
				BarBorder = BorderFactory.createLineBorder(Color.BLACK, BarBorderSize);
				for(int bar = 0;Length>bar;bar++) {
					if(Settings.ShowValues.Setting == "On") {
						RollNum = bar+SetPoint;
						Labels[bar] = new JLabel();
						Labels[bar].setText(Integer.toString(RollNum)+":");//.setText((Dice[bar]).toString());
						Labels[bar].setBounds(0,bar*(BarWidth+BarGap)-5,100,50);
						Labels[bar].setFont(new Font("Georgia",Font.BOLD,(20-(int)(.5*Math.log(Length)))));
						CenterPanel.add(Labels[bar]);
					}
					if(Settings.ShowProbabilityValues.Setting == "On") {
						ProbLabels[bar] = new JLabel();
						prob = new BigDecimal(Dice[bar]).divide(new BigDecimal(divisor),Digits,RoundingMode.HALF_EVEN);
						ProbLabels[bar].setText(""+(prob).toString().substring(1,Digits));//.setText((Dice[bar]).toString());
						ProbLabels[bar].setBounds(0,bar*(BarWidth+BarGap)+13,100,50);
						ProbLabels[bar].setFont(new Font("Georgia",Font.BOLD,(13-(int)(.5*Math.log(Length)))));
						CenterPanel.add(ProbLabels[bar]);
					}
					Bars[bar] = new JPanel();
					//System.out.println("THING "+1500*(Dice[bar].divide(divisor)).intValue());
					BarSize = (num.multiply(Dice[bar]).divide(divisor)).intValue();
					Bars[bar].setBounds(20+(int)(Math.log(Length)*3.75)+Adder,bar*(BarWidth+BarGap)+10,BarSize,BarWidth); //make sure we divide!
					//Bars[bar].setPreferredSize(new Dimension(Dice[bar].intValue(),10)); 
					Bars[bar].setBackground(Color.blue);
					Bars[bar].setOpaque(true);
					if(!(BarBorderSize==0)){
						Bars[bar].setBorder(BarBorder);
					}
					Bars[bar].setToolTipText("The chance of rolling a "+RollNum+" Is a "+Dice[bar]+"/"+divisor+".");
					
					CenterPanel.add(Bars[bar]);
				}
			}
			Bar.setString("Finished");
			CenterPanel.revalidate();
			CenterPanel.repaint();
			
		}if(e.getSource()==PastDiceButton) {
			WindowPastDice WindowPastDice = new WindowPastDice();
		}if(e.getSource()==NoteButton) {
			WindowNote WindowNote = new WindowNote();
		}if(e.getSource()==ExportButton) {
			File csvFile = new File(FileName+".csv");
			StringBuilder Holder = new StringBuilder();
			try {
				PrintWriter out = new PrintWriter(csvFile);
				for(int thing = 0;Dice.length>(thing+1);thing++) {
					Holder.append((SetPoint+thing)+": ");
					if(thing == Dice.length-2) {
						Holder.append(Dice[thing]);
					}else {
						Holder.append(Dice[thing]+", ");
					}
				}
				out.println(FileName+":");
				out.println(Holder.toString());
				out.close();
				ExportButton.setEnabled(false);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
