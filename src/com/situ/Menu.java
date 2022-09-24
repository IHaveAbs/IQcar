package com.situ;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.situ.Board.Which;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Menu extends JDialog implements ItemListener{
	private JPanel m_panel;
	public JButton restart;
	private Image RestartImg;
	private Image LevelImg;
	private Image levelchoose;
	public BufferedImage myPicture;
	private JRadioButton Medium;
	private JRadioButton Hard;
	private ButtonGroup btnGroup;
	public boolean hello = false;
	private int theGame;
	private int theLevel;
	public JButton Play;
	
	
	public Menu() {
		setModal(true);
		
		getContentPane().setLayout(null);
		ImageIcon iia = new ImageIcon("src/resources/Chooselevel.png");
		levelchoose = iia.getImage();
		

		m_panel = new JPanel();
		m_panel.setBounds(0, 0, 400, 228);
		getContentPane().add(m_panel);
		m_panel.setLayout(null);
		
		ImageIcon iia2 = new ImageIcon("src/resources/Chooselevel.png");
		LevelImg = iia2.getImage();
		LevelImg = LevelImg.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
		validate();
		setSize(400, 250);
		ImageIcon DKJAFLKSAJDFLA = new ImageIcon("src/resources/Chooselevel.png");
		LevelImg = DKJAFLKSAJDFLA.getImage();
		
		LevelImg = LevelImg.getScaledInstance(300, 50, Image.SCALE_DEFAULT);
		validate();
		
		btnGroup = new ButtonGroup();
		
		JRadioButton Easy = new JRadioButton("Easy");
		Easy.setSelected(true);
		Easy.setBounds(54, 78, 77, 23);
		
		btnGroup.add(Easy);
		
		Medium = new JRadioButton("Medium");
		Medium.setBounds(162, 78, 94, 23);
		btnGroup.add(Medium);
		theLevel = 1;
		Hard = new JRadioButton("Hard");
		Hard.setBounds(294, 78, 69, 23);
		btnGroup.add(Hard);
		m_panel.add(Easy);
		m_panel.add(Medium);
		m_panel.add(Hard);
		Easy.addItemListener(this);
		
		Medium.addItemListener(this);
		Hard.addItemListener(this);

		JButton choose = new JButton("New button");
		choose.setBounds(54, 22, 309, 43);
		choose.setIcon(new ImageIcon(LevelImg));
		m_panel.add(choose);
		
		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(70, 0));
		m_panel.add(rigidArea_1_1);
		
		JComboBox cBGameList = new JComboBox();
		cBGameList.setLocation(54, 108);
		cBGameList.setModel(new DefaultComboBoxModel(new String[] { "Game 1", "Game 2", "Game 3"}));
		theGame = 1;
		cBGameList.setSize(new Dimension(309, 69));
		cBGameList.setPreferredSize(new Dimension(40, 27));
		cBGameList.setMaximumRowCount(1000);
		m_panel.add(cBGameList);
		
		Play = new JButton("Play");
		Play.setBounds(149, 193, 117, 29);
		m_panel.add(Play);
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hello = true;
				dispose();
			}
		});
		cBGameList.addItemListener(this);
		
		
		
		
		
		
		//this.add(Level);
	
	}
	
            
	public void itemStateChanged(ItemEvent e) {
        int sel = e.getStateChange();

        if (sel == ItemEvent.SELECTED) {

        	Object source = e.getSource();
        	if (source instanceof JComboBox) {
                JComboBox cb = (JComboBox)source;
                Object selectedItem = cb.getSelectedItem();
                if ("Game 1".equals(selectedItem)) {
                	theGame = 1;
                	System.out.println("You select game 1.");
                } else if ("Game 2".equals(selectedItem)) {
                	theGame = 2;
                	System.out.println("You select game 2.");
                }
                else if ("Game 3".equals(selectedItem)) {
                	theGame = 3;
                	System.out.println("You select game 3.");
                }
            }
        	else
        	{
        		JRadioButton button = (JRadioButton) e.getSource();
                String text = button.getText();

                //StringBuilder sb = new StringBuilder("Selected: ");
                //sb.append(text);
                //System.out.println(sb.toString());
                
                if ("Easy".equals(text)) {
                	theLevel = 1;
                	System.out.println("You select Easy Mode.");
                } else if ("Medium".equals(text)) {
                	theLevel = 2;
                	System.out.println("You select Medium Mode.");
                }
                else if ("Hard".equals(text)) {
                	theLevel = 3;
                	System.out.println("You select Hard Mode.");
                }
                else if ("None".equals(text)) {
                	theLevel = 0;
                	System.out.println("You select Hard Mode.");
                }
        	}
        	
        }
    }
	public int getGame() {

		return theGame;
	}
	public int getLevel() {

		return theLevel;
	}
	public boolean getHello() {
		return hello;
	}
}
