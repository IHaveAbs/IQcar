package com.situ;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Levelbar extends JPanel {
	public JButton Level;
	public JButton restart;
	private Image RestartImg;
	private Image LevelImg;

	public Levelbar() {
		setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		ImageIcon iia2 = new ImageIcon("src/resources/cooltext362797728160006.png");
		LevelImg = iia2.getImage();
		Level = new JButton();
		LevelImg = LevelImg.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
		validate();
		Level.setIcon(new ImageIcon(LevelImg));

		add(Level);

		ImageIcon iia = new ImageIcon("src/resources/restart.png");
		RestartImg = iia.getImage();
		restart = new JButton();
		RestartImg = RestartImg.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		validate();
		restart.setIcon(new ImageIcon(RestartImg));

		add(restart);
	}

}
 