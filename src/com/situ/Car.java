package com.situ;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Car {

	protected enum DIRECTION {
		upDown, leftRight
	}

	protected int imageWidth = 0;
	protected int imageHeight = 0;
	int x2 = 0;
	int x3 = 0;
	int y2;
	int y3;
	public boolean GAMEWIN;
	protected int x = 0;
	protected int y = 0;
	public boolean ismoveright;
	public boolean ultraright = true;
	protected Color c = Color.RED;
	protected Color BORDERCOLOR = Color.BLACK;
	protected DIRECTION d = DIRECTION.upDown;
	private Image carImage;
	private Image carImage2;
	public boolean ultrafuck;
	protected int size = 2;
	public boolean stupid;
	protected Image image;

	public Car(int x, int y, Color c, DIRECTION d, int size, Color BORDERCOLOR) {

		x = x * 100;
		y = y * 100;

		this.x = x;
		this.y = y;
		this.c = c;
		this.d = d;
		this.size = size;
		loadImage();

	}

	public int getImageWidth() {

		return imageWidth;
	}

	public int getImageHeight() {

		return imageHeight;
	}

	private void loadImage() {

		ImageIcon iia = new ImageIcon("src/resources/REALCAR.png");
		ImageIcon iia2 = new ImageIcon("src/resources/REALcarUP.png");
		carImage = iia.getImage();
		carImage2 = iia2.getImage();
		if (d == DIRECTION.leftRight) {
			carImage = carImage.getScaledInstance(size * 100, 100, Image.SCALE_DEFAULT);
			carImage2 = carImage2.getScaledInstance(size * 100, 100, Image.SCALE_DEFAULT);
		}
		if (d == DIRECTION.upDown) {
			carImage = carImage.getScaledInstance(100, size * 100, Image.SCALE_DEFAULT);
			carImage2 = carImage2.getScaledInstance(100, size * 100, Image.SCALE_DEFAULT);
		}

	}

	public Image getCar() {

		return carImage;
	}

	public Image getCar2() {
		return carImage2;
	}

	public void setApple(Image carImage) {

		this.carImage = carImage;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return c;
	}

	public DIRECTION getDirection() {
		return d;
	}

	public int getSize() {
		return size;
	}

	public boolean onClick(int mouseX, int mouseY) {

		boolean tempClick = false;
		if (size == 2) {
			if (d == DIRECTION.leftRight) {
				if (mouseX > x && mouseX < x + 200 && mouseY > y && mouseY < y + 100) {
					tempClick = true;
				}
			}
			if (d == DIRECTION.upDown) {
				if (mouseX > x && mouseX < x + 100 && mouseY > y && mouseY < y + 200) {
					tempClick = true;
				}
			}

		} else if (size == 3) {
			if (d == DIRECTION.leftRight) {
				if (mouseX > x && mouseX < x + 300 && mouseY > y && mouseY < y + 100) {
					tempClick = true;
				}
			}
			if (d == DIRECTION.upDown) {
				if (mouseX > x && mouseX < x + 100 && mouseY > y && mouseY < y + 300) {
					tempClick = true;
				}
			}

		} else {
			tempClick = false;
		}

		return tempClick;

	}

	public void draw(Graphics2D g2d) {

		g2d.setColor(Color.BLACK);
		if (d == DIRECTION.leftRight) {

			g2d.setColor(c);
			g2d.fillRect(x, y, (size) * 100, (1) * 100);
			// g2d.setColor(BORDERCOLOR);
			// g2d.drawRect(x, y, (size) * 100 - 1, (1) * 100 - 1);
		}
		if (d == DIRECTION.upDown) {

			g2d.setColor(c);
			g2d.fillRect(x, y, (1) * 100, (size) * 100);
			// g2d.setColor(BORDERCOLOR);
			// g2d.drawRect(x, y, (1) * 100 - 1, (size) * 100 - 1);
		}

	}

	public void draw2(Graphics2D g2d, boolean ISCOLOR) {
		if (ISCOLOR) {
			g2d.setColor(Color.white);
			// g2d.setStroke(new java.awt.BasicStroke(10));
			if (d == DIRECTION.leftRight) {
				g2d.drawRect(x, y, (size) * 100, (1) * 100);
				g2d.fillRect(x, y, (size) * 100, (1) * 100);
			}
			if (d == DIRECTION.upDown) {
				g2d.drawRect(x, y, (1) * 100, (size) * 100);
				g2d.fillRect(x, y, (1) * 100, (size) * 100);

			}
		} else {
			g2d.setColor(Color.black);
			// g2d.setStroke(new java.awt.BasicStroke(10));
			if (d == DIRECTION.leftRight) {
				g2d.drawRect(x, y, (size) * 100, (1) * 100);
			}
			if (d == DIRECTION.upDown) {
				g2d.drawRect(x, y, (1) * 100, (size) * 100);
			}
			draw3(g2d);
		}
		

		// g2d.setStroke(new java.awt.BasicStroke(2));
	}
	public void draw3(Graphics2D g2d) {
		g2d.setColor(Color.red);
	
		
		g2d.setFont(new Font("Purisa", Font.PLAIN, 40));
		g2d.drawString("EXIT",500 , 250);
		g2d.setStroke(new BasicStroke(1));
		
	}

	public int moveLeft() {
		x -= 100;
		if (x < 0) {

			x += 100;
		}
		return x;

	}

	/*
	public int moveRight() {
		ismoveright = true;

		if (x + size * 100 + 50> 500 && c == Color.red) {
			if (x + size * 100 + 50> 600 && c == Color.red) { 
				ultraright = false;
				
			}

			if (ultraright == true) {
				x=x+100;
				
			}
			
			
			JOptionPane.showMessageDialog(null, "Congratulations! You win!", "You win", JOptionPane.INFORMATION_MESSAGE, null);
			ismoveright = false;
			
		}	
		else if (x + size * 100 + 100 > 600 && c != Color.red){
			//x=x-100;
			ismoveright = false;
		}
		
		if (ismoveright == true) {
			x += 100;
		}
		return x;
		// System.out.println(x);

	}
	*/
	
	public int moveRight(JFrame frame) {
		if (x + size * 100 + 100 <= 600 ){
			x += 100;
			
			if ( c == Color.red && (x + size * 100) > 500 ) {
				JOptionPane.showMessageDialog(frame, "Congratulations! You win!", "You win", JOptionPane.INFORMATION_MESSAGE, null);
			}
		}
		
		return x;
		// System.out.println(x);
	}

	public int moveUp() {
		y -= 100;
		if (y < 0) {
			y += 100;
		}

		return y;
	}

	public int moveDown() {
		y += 100;
		if (y + size * 100 > 600) {
			y -= 100;
		}
		return y;
	}

}
