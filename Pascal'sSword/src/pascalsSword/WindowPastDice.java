package pascalsSword;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.io.*;
import java.util.*;


public class WindowPastDice implements ActionListener {
    JFrame window  = new JFrame();
    JLabel Title;
    JPanel Panel = new JPanel();
    JScrollPane ScrollPane;
    
    public WindowPastDice() {
        initialize();
        display();
    }

    public void initialize() {
        window.setTitle("Past Dice");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(750,900);
    }

    public void display() {
        Title = new JLabel();
        Title.setText("Past Dice Sets");
        Title.setFont(new Font("Georgia",Font.BOLD,40));
        Title.setToolTipText("It's a title.");
        Title.setPreferredSize(new Dimension(100,70));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        
        Panel.setBackground(new Color(120,120,120));
        Panel.setLayout(new javax.swing.BoxLayout(Panel, javax.swing.BoxLayout.Y_AXIS)); // fix stacking

        try {
            Scanner scanner = new Scanner(new File("PastDice.csv"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine(); // actually read the line
                JLabel PastDice = new JLabel("<html>" + line + "</html>"); // fix null text
                PastDice.setFont(new Font("Georgia", Font.BOLD, 24));
                PastDice.setAlignmentX(JLabel.LEFT_ALIGNMENT); // left align
                Panel.add(PastDice); // add properly to panel
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("No past dice file found.");
            errorLabel.setFont(new Font("Georgia", Font.BOLD, 24));
            errorLabel.setForeground(Color.RED);
            Panel.add(errorLabel);
        }

        window.add(Title,BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(Panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(Panel.getBackground()); // keep background consistent
        scrollPane.setBackground(Panel.getBackground());        // scroll pane background
        scrollPane.setBorder(null);   
        
        window.add(scrollPane, BorderLayout.CENTER);
        window.getContentPane().setBackground(new Color(80,80,80));

        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // nothing needed for now
    }
}