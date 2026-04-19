package pascalsSword;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowNote implements ActionListener {
	Font Largest = new Font("Georgia",Font.BOLD,40);
	Font Large = new Font("Georgia",Font.BOLD,24);
	Font Small = new Font("Georgia",Font.BOLD,14);
	Color Display;
	JTextArea bigtext;
	JTextArea smalltext;
	JTextArea biggesttext;
	JTextArea smalltext1;
	JTextArea bigtext1;
	JTextArea smalltext2;
	JTextArea bigtext2;
	JTextArea smalltext3;
	JTextArea bigtext3;
	JPanel panel;


	JFrame window  = new JFrame();
	public WindowNote() {
		initialize();
		display();
	}
	public void initialize() {
		JTextArea biggesttext = new JTextArea();
		JTextArea bigtext = new JTextArea();
		JTextArea smalltext = new JTextArea();
		
		JTextArea bigtext1 = new JTextArea();
		JTextArea smalltext1 = new JTextArea();
		
		JTextArea bigtext2 = new JTextArea();
		JTextArea smalltext2 = new JTextArea();
		
		JTextArea bigtext3 = new JTextArea();
		JTextArea smalltext3 = new JTextArea();

		JPanel panel = new JPanel();
		
		Color Display = new Color(120,120,120);
		smalltext.setEditable(false);
		bigtext.setEditable(false);
		biggesttext.setEditable(false);
		smalltext.setFont(Small);
		bigtext.setFont(Large);
		biggesttext.setFont(Largest);
		smalltext.setBackground(Display);
		bigtext.setBackground(Display);
		biggesttext.setBackground(Display);
		biggesttext.setBorder(null);
		smalltext.setBorder(null);
		bigtext.setBorder(null);
		smalltext.setLineWrap(true);
        smalltext.setWrapStyleWord(true);
        bigtext.setLineWrap(true);
        bigtext.setWrapStyleWord(true);
        biggesttext.setLineWrap(true);
        biggesttext.setWrapStyleWord(true);
        
        smalltext1.setEditable(false);
		bigtext1.setEditable(false);
		smalltext1.setFont(Small);
		bigtext1.setFont(Large);
		smalltext1.setBackground(Display);
		bigtext1.setBackground(Display);
		smalltext1.setBorder(null);
		bigtext1.setBorder(null);
		smalltext1.setLineWrap(true);
        smalltext1.setWrapStyleWord(true);
        bigtext1.setLineWrap(true);
        bigtext1.setWrapStyleWord(true); 
        
        smalltext2.setEditable(false);
		bigtext2.setEditable(false);
		smalltext2.setFont(Small);
		bigtext2.setFont(Large);
		smalltext2.setBackground(Display);
		bigtext2.setBackground(Display);
		smalltext2.setBorder(null);
		bigtext2.setBorder(null);
		smalltext2.setLineWrap(true);
        smalltext2.setWrapStyleWord(true);
        bigtext2.setLineWrap(true);
        bigtext2.setWrapStyleWord(true);
        
        smalltext3.setEditable(false);
		bigtext3.setEditable(false);
		smalltext3.setFont(Small);
		bigtext3.setFont(Large);
		smalltext3.setBackground(Display);
		bigtext3.setBackground(Display);
		smalltext3.setBorder(null);
		bigtext3.setBorder(null);
		smalltext3.setLineWrap(true);
        smalltext3.setWrapStyleWord(true);
        bigtext3.setLineWrap(true);
        bigtext3.setWrapStyleWord(true);
        
		
		biggesttext.setText("Notation");
		bigtext.setText("Introduction:");
		smalltext.setText("Pascal’s Sword is a dice distribution calculation software. To calculate any set of dice, enter it in the text field. To enter in a simple set of dice, use nDx notation, where x is the number of sides a die has and n is the amount of dice you want to calculate. For example, 2d12 would return the dice distribution of 2 twelve-sided dice.\n"
				+ "To add more dice to the die set, you would add a + between the dice. 1d4+2d20 would return the dice distribution of 1 four-sided die and 2 twenty-sided dice.\n"
				+ "Sometimes when rolling dice, you would like a base modifier added to the dice set. To do this you would type a +[modifier] at the end of your die. 1d6+2 would be 1 six-sided die plus 2. You can subtract a modifier adding a -[modifier]. 1d6-2 would be 1 six-sided die minus 2.");

		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createMatteBorder(0, 10, -20, 10,Display));
		
		panel.add(biggesttext);
		panel.add(bigtext);
		panel.add(smalltext);
		
		bigtext1.setText("Custom Dice:");
		smalltext1.setText("Sometimes when rolling dice, you would like to know the distribution of custom dice. To do this you would type nD[x1,x2,x3,x4…], where x1,x2,x3,x4… would be the face value of the custom sides, and n would be the amount of custom dice. For example, 2d[2,7,9,10] would return the dice distribution of two dice, with the sides of 2,7,9, and 10. There is no limit to the amount of sides a custom die can have. If you want a face to represent a negative number, type “neg” in front of the number. Neg10 would return a side with the face value of negative 10.");
		panel.add(bigtext1);
		panel.add(smalltext1);
		
		bigtext2.setText("Functions:");
		smalltext2.setText("Sometimes when rolling dice, you would like to add particular changes to the rules of how you roll. Those changes will be called functions. There are several functions built within Pascal’s Sword. In general, the notation for using them will be [info] [function](Dice). [info] is any information related to the function, for example, for the advantage function, the number of times needed to apply the advantage would go in the info section. [function] is the name of the function. (Dice) is the set of dice you want to apply the function to. The dice need both parenthesis around them to work.");
		panel.add(bigtext2);
		panel.add(smalltext2);
		
		bigtext3.setText("Function List:");
		smalltext3.setText("Advantage/Disadvantage: Advantage is the process of rolling two (or more) dice, and taking the higher of the two as your result. Disadvantage is the same as advantage but taking the lower result. Advantage allows for additional info, an integer value asking for how many dice should be rolled in determining the resulting value. An example of this would be 3 disadv(1d6), which would return the result of the lowest of 3 six sided dice. Note: Advantage numbers past 6 greatly slow the program down.\n"
				+ "DR: DR is the process of reducing the total roll by the DR number, to a minimum of 0. An example of this would be 5 DR(1d6), which would return the result of one six sided die, subtracted by 5, to a minimum of 0.\n"
				+ "Drop/Reroll Drop: Drop/Reroll Drop is the process of taking a given roll on any die in the dice set, and removing it. Reroll drop is taking that particular value and rerolling when that face is rolled. Each value dropped needs to be separated by a comma. If a negative number needs to be dropped, add neg in front of the number as mentioned in the custom dice section. An example of this would be neg1,1,2,5drop(1d6), which would return the result of a six sided die, but whenever the faces of -1, 1, 2, and 5 are rolled, the result would be rerolled until those faces do not appear.\n"
				+ "Half: Half is the process of dividing the total roll by two. Halving rounds down, unless if it rounds down to 0, which then it rounds up. An example of this would be half(1d6), which would return a die with two faces with 1 on it, 2 faces with 2 on it, and two faces with 3 on it (or just 1d3).\n"
				+ "Multiplication: Multiplication is the process of multiplying the faces of a die by several values. The different values the faces of the die are multiplied by are separated by commas. If a negative number needs to be multiplied, add neg in front of the number, as mentioned in the custom dice section. An example of this would be 1,2,3 Multiplication(1d6), which would return 1 six sided die, multiplied by 1, 2 and 3.\n"
				+ "Remove: Remove is the process of taking a given roll in a dice set and removing its probability. Unlike the drop function, reroll calculates the dice distribution before removing a given value. The different removed values are separated by commas. If a negative number needs to be removed, add neg in front of the number, as mentioned in the custom dice section. An example of this would be 4,5,8 remove(2d6), which would return 2d6, with a 0 probability of rolling a 4,5, or 8.\n"
				+ "Vulnerability: Vulnerability is the process of multiplying by 1.5, rounding down. An example of this would be vulnerability(1d6), which would return a die with a face of 1, a face of 3, a face of 4, a face of 6, a face of 7 and a face of 9.\n"
				+ "\n"
				+ "One last note: Functions can be nested and added together, for example 1d6+1,2,3 drop(2d6) + 8 remove(2 adv(2d6+1d4)) is a valid function (there may be errors that are tied to it however).");
		panel.add(bigtext3);
		panel.add(smalltext3);
		
		window.add(panel);

		window.getContentPane().setBackground(Display);
		window.setTitle("Notation");
	    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    window.setSize(1200,900);
	}
	public void display() {
		 window.setLocationRelativeTo(null);
		 window.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}