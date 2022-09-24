package com.situ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class frame extends JFrame {
	private Levelbar level;

	public frame() {

		initUI();
	}

	private void initUI() {
		level = new Levelbar();
		level.setVisible(true);
		add(level, BorderLayout.NORTH);
		add(new Board(level, this));

		setResizable(false);
		pack();

		setTitle("IQ CAR 3");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			frame frame = new frame();
			frame.setVisible(true);
		});
	}
}
