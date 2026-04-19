package pascalsSword;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class WindowSettings implements ActionListener {
	JFrame window  = new JFrame();
	JLabel Title = new JLabel("Settings",SwingConstants.CENTER);
	JPanel panel = new JPanel();
	JLabel Desc = new JLabel();
	JButton ApplyButton = new JButton();
	JButton SVButton = new JButton();
	JButton SPVButton = new JButton();
	JButton AEButton = new JButton();
	JButton ResetButton = new JButton();
	JTextField BGField = new JTextField();
	JTextField BWField = new JTextField();
	JTextField BBSField = new JTextField();
	Color Button_Color = new Color(240,240,240);
	Color Red = new Color(255,150,150);
	Color Green = new Color(150,255,150);
	Font ButtonFont = new Font("Georgia",Font.BOLD,24);
	Border ButtonBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
	Border TextBorder = BorderFactory.createEmptyBorder(0, 5, 0, 0);
	String[] TempSettings = new String[6];
	int holder;
	
	public WindowSettings() {
		initialize();
		display();
	}
	public void initialize() {
		window.setTitle("Settings");
	    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    window.setSize(600,900);
	}
	public void display() {
		TempSettings[0] = Settings.BarGap.Setting;
		TempSettings[1] = Settings.BarWidth.Setting;
		TempSettings[2] = Settings.BarBorderSize.Setting;
		TempSettings[3] = Settings.ShowValues.Setting;
		TempSettings[4] = Settings.ShowProbabilityValues.Setting;
		TempSettings[5] = Settings.AutoExport.Setting;
		
		ApplyButton = new JButton("Apply");
		ApplyButton.setBounds(20,725,150,50);
		ApplyButton.setHorizontalAlignment(JButton.CENTER);
		ApplyButton.setMargin(new Insets(0,-9,0,-10));
		ApplyButton.setFont(ButtonFont);
		ApplyButton.setFocusable(false);
		ApplyButton.setContentAreaFilled(false);
		ApplyButton.setOpaque(true);
		ApplyButton.setBackground(Button_Color);
		ApplyButton.setBorder(ButtonBorder);
		ApplyButton.addActionListener(this);
		ApplyButton.setToolTipText("To apply the settings.");

		
		ResetButton = new JButton("Reset");
		ResetButton.setBounds(20+400,725,150,50);
		ResetButton.setHorizontalAlignment(JButton.CENTER);
		ResetButton.setMargin(new Insets(0,-9,0,-10));
		ResetButton.setFont(ButtonFont);
		ResetButton.setFocusable(false);
		ResetButton.setContentAreaFilled(false);
		ResetButton.setOpaque(true);
		ResetButton.setBackground(Button_Color);
		ResetButton.setBorder(ButtonBorder);
		ResetButton.addActionListener(this);
		ResetButton.setToolTipText("To reset settings back to defaults.");

		if(Settings.ShowValues.Setting == "On") {
			SVButton = new JButton("On");
			SVButton.setBackground(Green);
		}else {
			SVButton = new JButton("Off");
			SVButton.setBackground(Red);
		}
		SVButton.setBounds(475,180+85,100,50);
		SVButton.setHorizontalAlignment(JButton.CENTER);
		SVButton.setMargin(new Insets(0,-9,0,-10));
		SVButton.setFont(ButtonFont);
		SVButton.setFocusable(false);
		SVButton.setContentAreaFilled(false);
		SVButton.addActionListener(this);
		//ExportButton.setBorderPainted(false);
		SVButton.setOpaque(true);
		SVButton.setBorder(ButtonBorder);
		SVButton.setToolTipText("To add what value each bar repserents of the distribution to the final display.");

		
		if(Settings.ShowProbabilityValues.Setting == "On") {
			SPVButton = new JButton("On");
			SPVButton.setBackground(Green);
		}else {
			SPVButton = new JButton("Off");
			SPVButton.setBackground(Red);
		}
		SPVButton.setBounds(475,180+85*2,100,50);
		SPVButton.setHorizontalAlignment(JButton.CENTER);
		SPVButton.setMargin(new Insets(0,-9,0,-10));
		SPVButton.setFont(ButtonFont);
		SPVButton.setFocusable(false);
		SPVButton.setContentAreaFilled(false);
		SPVButton.addActionListener(this);
		//ExportButton.setBorderPainted(false);
		SPVButton.setOpaque(true);
		SPVButton.setBorder(ButtonBorder);
		SPVButton.setToolTipText("To add what probability each bar repserents of the distribution to the final display.");

		
		if(Settings.AutoExport.Setting == "Off") {
			AEButton = new JButton("Off");
			AEButton.setBackground(Red);
		}else {
			AEButton = new JButton("On");
			AEButton.setBackground(Green);
		}
		AEButton.setBounds(475,180+85*3,100,50);
		AEButton.setHorizontalAlignment(JButton.CENTER);
		AEButton.setMargin(new Insets(0,-9,0,-10));
		AEButton.setFont(ButtonFont);
		AEButton.setFocusable(false);
		AEButton.setContentAreaFilled(false);
		AEButton.addActionListener(this);
		//ExportButton.setBorderPainted(false);
		AEButton.setOpaque(true);
		AEButton.setBorder(ButtonBorder);
		AEButton.setToolTipText("To automatically export the dice distribution.");

		
		BGField = new JTextField();
		//TextField.setPreferredSize(new Dimension(1400,50));
		BGField.setBounds(475,180-85*2,100,50);
		BGField.setFont(ButtonFont);
		BGField.setBorder(BorderFactory.createCompoundBorder(ButtonBorder,TextBorder));
		BGField.setText(Settings.BarGap.Setting);
		BGField.setHorizontalAlignment(SwingConstants.CENTER);
		BGField.setToolTipText("To change the bar gap (default is 10).");

		
		BWField = new JTextField();
		//TextField.setPreferredSize(new Dimension(1400,50));
		BWField.setBounds(475,180-85*1,100,50);
		BWField.setFont(ButtonFont);
		BWField.setBorder(BorderFactory.createCompoundBorder(ButtonBorder,TextBorder));
		BWField.setText(Settings.BarGap.Setting);
		BWField.setHorizontalAlignment(SwingConstants.CENTER);
		BWField.setToolTipText("To change the bar width (default is 40).");

		
		BBSField = new JTextField();
		//TextField.setPreferredSize(new Dimension(1400,50));
		BBSField.setBounds(475,180,100,50);
		BBSField.setFont(ButtonFont);
		BBSField.setBorder(BorderFactory.createCompoundBorder(ButtonBorder,TextBorder));
		BBSField.setText(Settings.BarGap.Setting);
		BBSField.setHorizontalAlignment(SwingConstants.CENTER);
		BBSField.setToolTipText("To change the border on each of the bars (default is 3).");

		
		Title.setFont(new Font("Georgia",Font.BOLD,40));
		Title.setToolTipText("It's a title.");

		Desc.setText("<html>Bar Gap <br><br><br>Bar Width <br><br><br>Bar Border Size <br><br><br>Show Values<br><br><br>Show Probability Values<br><br><br>Auto Export</html>");
		Desc.setFont(new Font("Georgia",Font.BOLD,24));
		Desc.setBounds(5,0,1000,500);
		panel.setLayout(null);
		panel.setBackground(new Color(120,120,120));
		panel.add(Desc);
		panel.add(ApplyButton);panel.add(SVButton);panel.add(SPVButton);panel.add(AEButton);panel.add(BGField);panel.add(BWField);panel.add(BBSField);panel.add(ResetButton);
		window.add(panel);
		Title.setPreferredSize(new Dimension(100,70));
		window.add(Title,BorderLayout.NORTH);
		window.getContentPane().setBackground(new Color(80,80,80));
		
		//window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ApplyButton) {
			TempSettings[0] = BGField.getText();
			if(TempSettings[0].toLowerCase()=="auto") {
				TempSettings[0] = "auto";
				Settings.BarGap.Setting = "Auto";

			}else {
				try {
					holder = Integer.parseInt(TempSettings[0]);
					if(holder>50) {
						holder = 50;
					}else if(holder<0) {
						holder = 0;
					}
					Settings.BarGap.Setting = String.valueOf(holder);
				}catch (NumberFormatException n) {

				}
			}
			BGField.setText(Settings.BarGap.Setting); // DIDN"T DO THIS 
			
			TempSettings[1] = BWField.getText();
			if(TempSettings[1].toLowerCase()=="auto") {
				TempSettings[1] = "auto";
				Settings.BarWidth.Setting = "Auto";

			}else {
				try {
					holder = Integer.parseInt(TempSettings[1]);
					if(holder>500) {
						holder = 500;
					}else if(holder<1) {
						holder = 1;
					}
					Settings.BarWidth.Setting = String.valueOf(holder);
				}catch (NumberFormatException n) {

				}
			}
			BWField.setText(Settings.BarWidth.Setting); // DIDN"T DO THIS 
			
			TempSettings[2] = BBSField.getText();
			if(TempSettings[2].toLowerCase()=="auto") {
				TempSettings[2] = "auto";
				Settings.BarBorderSize.Setting = "Auto";

			}else {
				try {
					holder = Integer.parseInt(TempSettings[2]);
					if(holder>50) {
						holder = 50;
					}else if(holder<0) {
						holder = 0;
					}
					Settings.BarBorderSize.Setting = String.valueOf(holder);
				}catch (NumberFormatException n) {
					//System.out.println("failed");
				}
			}
			BBSField.setText(Settings.BarBorderSize.Setting); // DIDN"T DO THIS 
			//System.out.println(BBSField.getText());
			Settings.ShowValues.Setting = TempSettings[3];
			Settings.ShowProbabilityValues.Setting = TempSettings[4];
			Settings.AutoExport.Setting = TempSettings[5];  //DIDNT DO THIS EITHER
		}
		else if(e.getSource()==SVButton) {
			if(SVButton.getText()=="On") {
				SVButton.setText("Off");
				SVButton.setBackground(Red);
				TempSettings[3] = "Off";
				//System.out.println(SVButton.getText());
			}else {
				SVButton.setText("On");
				SVButton.setBackground(Green);
				TempSettings[3] = "On";
			}
		}
		else if(e.getSource()==SPVButton) {
			if(SPVButton.getText()=="On") {
				SPVButton.setText("Off");
				SPVButton.setBackground(Red);
				TempSettings[4] = "Off";
			}else {
				SPVButton.setText("On");
				SPVButton.setBackground(Green);
				TempSettings[4] = "On";
			}
		}
		else if(e.getSource()==AEButton) {
			if(AEButton.getText()=="On") {
				AEButton.setText("Off");
				AEButton.setBackground(Red);
				TempSettings[5] = "Off";
			}else {
				AEButton.setText("On");
				AEButton.setBackground(Green);
				TempSettings[5] = "On";
			}
		}else if(e.getSource()==ResetButton) {
			Settings.BarGap.Setting = "Auto";
			Settings.BarWidth.Setting = "Auto";
			Settings.BarBorderSize.Setting = "Auto";
			Settings.ShowValues.Setting = "On";
			Settings.ShowProbabilityValues.Setting = "On";
			Settings.AutoExport.Setting = "Off";
			BBSField.setText(Settings.BarGap.Setting);
			BWField.setText(Settings.BarGap.Setting);

			AEButton.setText("Off");
			AEButton.setBackground(Red);

			SVButton.setText("On");
			SVButton.setBackground(Green);

			SPVButton.setText("On");
			SPVButton.setBackground(Green);

		}
	}
}
