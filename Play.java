// Fabian Gaspero-Beckstrom
// CS 110
// Assignment#10 Play Class - GUI

package HW10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Play class constructs a GUI window for a simulated game of war to be played in.
 * @author Fasogabe
 */
public class Play extends JFrame {
    // panels
    private JPanel usrPilePanel, battlePanel, buttonPanel, cpuPilePanel, numbersPanel;
    // labels
    private JLabel usrPileLabel, usrBattleLabel, usrNumbersLabel;
    private JLabel cpuPileLabel, cpuBattleLabel, cpuNumbersLabel;
    // buttons
    private JButton battleButton, reinforceButton;
    
    // start game
    Battle game = new Battle();

    public Play() {
        
        // set title
        setTitle("This Means War");

        // close action
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create BorderLayout manager
        setLayout(new BorderLayout());
        
        // create panels
        usrPilePanel = new JPanel();
        battlePanel = new JPanel();
        buttonPanel = new JPanel();
        numbersPanel = new JPanel();
        cpuPilePanel = new JPanel();
        
        // set layout managers
        battlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        numbersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 10));
        
        
        // build game start setup
        buildInitialSetup();
        
        // pack and display
        pack();
        setVisible(true);
        

        
    }
    public void buildInitialSetup() {
        // create labels
        usrPileLabel = new JLabel();
        cpuPileLabel = new JLabel();
        cpuBattleLabel = new JLabel();
        usrBattleLabel = new JLabel();
        cpuNumbersLabel = new JLabel("26");
        usrNumbersLabel = new JLabel("26");
        // set images
        String BACK = "back.jpg";
        ImageIcon backImg = new ImageIcon(BACK);
        usrPileLabel.setIcon(backImg);
        cpuPileLabel.setIcon(backImg);
        usrBattleLabel.setIcon(backImg);
        cpuBattleLabel.setIcon(backImg);
        
        // create buttons
        battleButton = new JButton("Battle!");
        reinforceButton = new JButton("Reinforce");
        // register action listeners
        battleButton.addActionListener(new BattleButtonListener());
        reinforceButton.addActionListener(new ReinforceButtonListener());
        
        
        // add labels and buttons to panels
        usrPilePanel.add(usrPileLabel);
        cpuPilePanel.add(cpuPileLabel);
        battlePanel.add(usrBattleLabel);
        battlePanel.add(cpuBattleLabel);
        numbersPanel.add(usrNumbersLabel);
        numbersPanel.add(cpuNumbersLabel);
        buttonPanel.add(battleButton);
        buttonPanel.add(reinforceButton);
        
        // add panels to frame
        add(usrPilePanel, BorderLayout.WEST);
        add(cpuPilePanel, BorderLayout.EAST);
        add(battlePanel, BorderLayout.CENTER);
        add(numbersPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
    
    private class BattleButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // retreive cards
            Card usr = game.usrCharge();
            Card cpu = game.cpuCharge();
            // get image names
            String uPicStr = usr.toString() + ".jpg";
            String cPicStr = cpu.toString() + ".jpg";
            // get images
            ImageIcon uPic = new ImageIcon(uPicStr);
            ImageIcon cPic = new ImageIcon(cPicStr);
            // add images to labels
            usrBattleLabel.setIcon(uPic);
            cpuBattleLabel.setIcon(cPic);
            // battle
            game.showdown();
            // update remaining cards label
            usrNumbersLabel.setText(null);
            cpuNumbersLabel.setText(null);
            String uNum = "" + game.getUsrNumbers();
            usrNumbersLabel.setText(uNum);
            String cNum = "" + game.getCpuNumbers();
            cpuNumbersLabel.setText(cNum);
            // re-pack
            pack();
            
            
        }
    
    }
    private class ReinforceButtonListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // reinforce deck
            game.reinforce();
            // update remaining cards label
            usrNumbersLabel.setText(null);
            cpuNumbersLabel.setText(null);
            String uNum = "" + game.getUsrNumbers();
            usrNumbersLabel.setText(uNum);
            String cNum = "" + game.getCpuNumbers();
            cpuNumbersLabel.setText(cNum);
            // re-pack
            pack();
            
        }
    }
    // open game
    public static void main(String[] args) {
        Play play = new Play();
    }

}
