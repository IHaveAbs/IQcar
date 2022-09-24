package com.situ;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import com.situ.Car.DIRECTION;
import com.situ.Menu;


//import com.zetcode.Shape.Tetrominoe;

public class Board extends JPanel {
	// Graphics g = (Graphics);
	// Graphics2D g2d = (Graphics2D) g;
	private Image backImg;
	private List<Car> cars = new ArrayList<>();
	int fps;
	int x;
	public boolean ischoselevel;
	int y;
	private Image ExitImage;
	public boolean drawExit;
	// public Boolean superclick;
	public Car GAMEWIN;
	public int whichBUTTON;
	public int whichnumber;
	public JButton RealPlay;
	public boolean ultranone = true;
	protected enum Which {
		easy1, easy2, easy3, medium1, medium2, medium3, hard1, hard2, hard3, none
	}

	protected Car currentCar = null;
	protected Car fakecar = null;
	private TAdapter MouseAdapter;
	private TAdapter2 KeyAdapter;
	protected Which whichlevel = Which.none;
	protected Menu menu = null;
	private JFrame mainFrame;
	
	public Board(Levelbar levelbar, JFrame frame) {
		//ImageIcon iia2 = new ImageIcon("src/resources/exit.png");
		//ExitImage = iia2.getImage();
		
		//ExitImage = ExitImage.getScaledInstance(100, 30, Image.SCALE_DEFAULT);
		//validate();

		//Board.add(ExitImage);
		mainFrame = frame;
		
		levelbar.restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (whichlevel == Which.easy1) {
					Easy1();
				}
				if (whichlevel == Which.easy2) {
					Easy2();
				}
				if (whichlevel == Which.easy3) {
					Easy3();
				}
				if (whichlevel == Which.medium1) {
					Medium1();
				}
				if (whichlevel == Which.medium2) {
					Medium2();
				}
				if (whichlevel == Which.medium3) {
					Medium3();
				}
				if (whichlevel == Which.hard1) {
					hard1();
				}
				if (whichlevel == Which.hard2) {
					hard2();
				}
				if (whichlevel == Which.hard3) {
					hard3();
				}

			}
		});
		levelbar.Level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String name = JOptionPane.showInputDialog(frame, "What is your name?", null);
				menu = new Menu();
				menu.setLocationRelativeTo(frame);
				menu.setVisible(true);
				System.out.println("theLevel: " + menu.getLevel() + "  theGame: " + menu.getGame());
				int Level = menu.getLevel();
				int Game = menu.getGame();
				boolean hello = menu.getHello();
				if (Game == 1) {
					Level = menu.getLevel();
					Game = menu.getGame();
					
					if (Level == 1) {
						if (hello == true) {
							Easy1();
							whichlevel = Which.easy1;
							hello = false;
						}	
						
						
							
						
					}
					else if (Level == 2) {
						if (hello == true) {
							Medium1();
							whichlevel = Which.medium1;
							hello = false;
						}	
						
							
						
					}
					else if (Level == 3) {
						if (hello == true) {
							hard1();
							whichlevel = Which.hard1;
							hello = false;
						}	
						
							
						
					}
					
				}
				else if (Game == 2) {
					Level = menu.getLevel();
					Game = menu.getGame();
					if (Level == 1 ) {
						if (hello == true) {
							Easy2();
							whichlevel = Which.easy2;
							hello = false;
						}	
						
							
					}
					else if (Level == 2) {
						if (hello == true) {
							Medium2();
							whichlevel = Which.medium2;
							hello = false;	
						}	
						
						
						
					}
					else if (Level == 3) {
						if (hello == true) {
							hard2();
							whichlevel = Which.hard2;
							hello = false;
						}	
						
							
						
					}
				}
				else if (Game == 3) {
					Level = menu.getLevel();
					Game = menu.getGame();
					if (Level == 1) {
						if (hello == true) {
							Easy3();
							whichlevel = Which.easy3;
							hello = false;
						}	
						
							
						
					}
					else if (Level == 2) {
						if (hello == true) {
							Medium3();
							whichlevel = Which.medium3;
							hello = false;
						}	
						
							
						
					}
					else if (Level == 3) {
						if (hello == true) {
							hard3();
							whichlevel = Which.hard3;
							hello = false;
						}	
						
							
						
					}
				}
				
				//menu.sh
				//menu.sho
				//menu.show();
				//add(menu, BorderLayout.CENTER);
			}
			
		});
		
		//Starting(whichlevel);
		initBoard();

	}
	public boolean IsChoseLevel() {
		
		if (whichlevel == Which.none) {
			ischoselevel = false;
		}
		return ischoselevel;
	}
	private void initBoard() {
		ImageIcon iia = new ImageIcon("src/resources/background.png");
		Image tempImg = iia.getImage();
		backImg = tempImg.getScaledInstance(600, 600, Image.SCALE_DEFAULT);

		setFocusable(true);
		requestFocus(true);
		setFocusable(true);
		setPreferredSize(new Dimension(GameCons.WINDOW_WIDTH, GameCons.WINDOW_HEIGHT));

		TAdapter adapter = new TAdapter();
		addMouseListener(adapter);
		TAdapter2 adapter2 = new TAdapter2();
		addKeyListener(adapter2);
		// fps = 60;
		

	}	
	public void Starting(Which whichlevel) {
		drawExit = false;
		setFocusable(true);
		requestFocus(true);
		setFocusable(true);
		setPreferredSize(new Dimension(GameCons.WINDOW_WIDTH, GameCons.WINDOW_HEIGHT));
		cars.removeAll(cars);
		/*JButton Play = new JButton("Play");
		Play.setBounds(300, 300, 400, 400);
		add(Play);
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initBoard();
				if (whichlevel == Which.none) {
					System.out.println("No level selected");
				}
			}
			
		});
		*/
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		g2d.setColor(Color.BLACK);
		repaint();
		doGameCycle();
		
		//draw background
		g2d.drawImage(backImg, 0, 0, this);
		
		for (Car car : cars) {
			if (car == currentCar) {
				// car.draw(g2d);
				car.draw2(g2d, true);

				repaint();
				doGameCycle();
			} else {
				car.draw(g2d);
				car.draw2(g2d, false);
				repaint();
				doGameCycle();
			}

		}
		drawCar(g);
		repaint();
		doGameCycle();

	}

	private void doGameCycle() {

		repaint();
	}

	private void drawCar(Graphics g2d) {
		for (Car thecar : cars) {
			if (thecar.getDirection() == DIRECTION.leftRight) {
				g2d.drawImage(thecar.getCar(), thecar.getX(), thecar.getY(), this);
			}
			if (thecar.getDirection() == DIRECTION.upDown) {
				g2d.drawImage(thecar.getCar2(), thecar.getX(), thecar.getY(), this);
			}
		}
		g2d.setColor(Color.red);
		if (drawExit == true) {
			g2d.setFont(new Font("Purisa", Font.PLAIN, 40));
			g2d.drawString("EXIT",500 , 250);
		}
		
		
		
		//g2d.setStroke(new BasicStroke(1));

	}
	private void Easy1() {
		cars.removeAll(cars);
		cars.add(new Car(3, 0, Color.ORANGE, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(1, 2, Color.RED, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(0, 2, Color.blue, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(2, 0, Color.blue, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(4, 4, Color.MAGENTA, DIRECTION.upDown, 2, Color.BLACK));

		cars.add(new Car(4, 0, Color.orange, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(0, 1, Color.gray, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(1, 4, Color.YELLOW, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(5, 4, Color.CYAN, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(3, 3, Color.green, DIRECTION.leftRight, 3, Color.BLACK));
		
		

	}
	private void Easy2() {
		cars.removeAll(cars);

		cars.add(new Car(3, 2, Color.red, DIRECTION.leftRight, 2, Color.BLACK));
		
		cars.add(new Car(5, 1, Color.green, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(3, 3, Color.CYAN, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(4, 4, Color.gray, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(0, 3, Color.blue, DIRECTION.leftRight, 3, Color.BLACK));

		cars.add(new Car(2, 0, Color.orange, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(0, 1, Color.orange, DIRECTION.leftRight, 2, Color.BLACK));

	}
	private void Easy3() {
		cars.removeAll(cars);

		cars.add(new Car(2, 2, Color.red, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(4, 1, Color.green, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(1, 0, Color.blue, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(3, 4, Color.yellow, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(0, 3, Color.orange, DIRECTION.leftRight, 3, Color.BLACK));    
		cars.add(new Car(2, 4, Color.cyan, DIRECTION.upDown, 2, Color.BLACK));
	

	}
	private void Medium1() {
		cars.removeAll(cars);
		cars.add(new Car(0, 0, Color.yellow, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(5, 0, Color.magenta, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(3, 1, Color.green, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(1, 2, Color.red, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(0, 1, Color.orange, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(0, 4, Color.cyan, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(2, 5, Color.blue, DIRECTION.leftRight, 3, Color.BLACK));
		cars.add(new Car(4, 4, Color.pink, DIRECTION.leftRight, 2, Color.BLACK));
		

	}
	private void Medium2() {
		cars.removeAll(cars);

		cars.add(new Car(2, 5, Color.ORANGE, DIRECTION.leftRight, 3, Color.BLACK));
		cars.add(new Car(1, 2, Color.RED, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(5, 4, Color.CYAN, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(3, 0, Color.blue, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(0, 0, Color.MAGENTA, DIRECTION.upDown, 3, Color.BLACK));

		cars.add(new Car(2, 3, Color.pink, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(3, 3, Color.green, DIRECTION.leftRight, 3, Color.BLACK));
		

	}
	private void Medium3() {
		cars.removeAll(cars);

		cars.add(new Car(1, 2, Color.red, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(3, 2, Color.green, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(1, 3, Color.cyan, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(1, 4, Color.pink, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(5, 3, Color.magenta, DIRECTION.upDown, 3, Color.BLACK));    
		cars.add(new Car(2, 5, Color.blue, DIRECTION.leftRight, 2, Color.BLACK));
		

	}
	private void hard1() {
		cars.removeAll(cars);

		cars.add(new Car(0, 0, Color.ORANGE, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(0, 2, Color.RED, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(2, 0, Color.CYAN, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(4, 0, Color.YELLOW, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(4, 1, Color.MAGENTA, DIRECTION.upDown, 2, Color.BLACK));

		cars.add(new Car(5, 1, Color.BLUE, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(2, 3, Color.gray, DIRECTION.leftRight, 3, Color.BLACK));
		cars.add(new Car(1, 3, Color.YELLOW, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(0, 4, Color.PINK, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(3, 4, Color.PINK, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(1, 5, Color.BLUE, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(4, 4, Color.LIGHT_GRAY, DIRECTION.leftRight, 2, Color.BLACK));
		

	}
	private void hard2() {
		cars.removeAll(cars);

		cars.add(new Car(0, 0, Color.green, DIRECTION.leftRight, 3, Color.BLACK));
		cars.add(new Car(0, 1, Color.blue, DIRECTION.leftRight, 3, Color.BLACK));
		cars.add(new Car(0, 2, Color.red, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(0, 3, Color.orange, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(2, 4, Color.magenta, DIRECTION.upDown, 2, Color.BLACK));    
		cars.add(new Car(3, 0, Color.BLUE, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(3, 2, Color.pink, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(3, 4, Color.YELLOW, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(4, 0, Color.orange, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(4, 3, Color.PINK, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(5, 4, Color.cyan, DIRECTION.upDown, 2, Color.BLACK));
		

	}
	private void hard3() {
		
		cars.removeAll(cars);

		cars.add(new Car(0, 0, Color.gray, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(2, 0, Color.pink, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(4, 0, Color.orange, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(0, 1, Color.orange, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(2, 2, Color.red, DIRECTION.leftRight, 2, Color.BLACK));    
		cars.add(new Car(4, 2, Color.green, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(5, 1, Color.blue, DIRECTION.upDown, 3, Color.BLACK));
		cars.add(new Car(1, 3, Color.magenta, DIRECTION.leftRight, 3, Color.BLACK));
		cars.add(new Car(4, 4, Color.magenta, DIRECTION.leftRight, 2, Color.BLACK));
		cars.add(new Car(3, 4, Color.PINK, DIRECTION.upDown, 2, Color.BLACK));
		cars.add(new Car(0, 5, Color.cyan, DIRECTION.leftRight, 2, Color.BLACK));

	}

	//public void showwin(Graphics g2d) {
		//if (GAMEWIN == true) {
			//GAMEWIN = false;
		//}
	//}

	private class TAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {

			x = e.getX();
			y = e.getY();

			// x = Math.round(x);
			// y = Math.round(y);

			// x = x / 100;
			// y = y / 100;
			currentCar = null;
			for (Car thecar : cars) {
				if (thecar.onClick(x, y)) {
					currentCar = thecar;
					requestFocus(true);
					setFocusable(true);
					break;
				}
			}

			// if (null != currentCar) {

			// }

		}

	}

	class TAdapter2 extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			repaint();
			doGameCycle();
			int keycode = e.getKeyCode();

			if (null != currentCar) {
				if (currentCar.getDirection() == DIRECTION.leftRight) {

					if (keycode == KeyEvent.VK_RIGHT) {
						boolean isCar = false;
						Car tempCar = null;

						for (Car thecar : cars) {
							if (thecar.onClick(currentCar.getX() + (currentCar.getSize() * 100 + 50),
									currentCar.getY() + 50)) {
								isCar = true;
								tempCar = thecar;
								break;
							}
						}

						if (tempCar != null) {

						}

						if (isCar != true) {
							currentCar.moveRight(mainFrame);
							repaint();
							doGameCycle();
							isCar = false;
						}

					}
					if (keycode == KeyEvent.VK_LEFT) {
						boolean isCar = false;
						for (Car thecar : cars) {
							if (thecar.onClick(currentCar.getX() - 50, currentCar.getY() + 50)) {
								isCar = true;
								break;
							}
						}

						if (!isCar) {
							currentCar.moveLeft();
							repaint();
							doGameCycle();

						}

					}

				}
				if (currentCar.getDirection() == DIRECTION.upDown) {
					if (keycode == KeyEvent.VK_UP) {
						boolean isCar = false;
						for (Car thecar : cars) {
							if (thecar.onClick(currentCar.getX() + 50, currentCar.getY() - 50)) {
								isCar = true;
								break;
							}
						}

						if (!isCar) {
							if (currentCar.getY() - 100 > 600) {

							} else {
								currentCar.moveUp();
								repaint();
								doGameCycle();

							}

						}

					}
					if (keycode == KeyEvent.VK_DOWN) {
						boolean isCar = false;
						for (Car thecar : cars) {
							if (thecar.onClick(currentCar.getX() + 50,
									currentCar.getY() + (currentCar.getSize() * 100 + 50))) {
								isCar = true;
								break;
							}
						}

						if (!isCar) {
							currentCar.moveDown();
							repaint();
							doGameCycle();

						}

					}

				}

			}

		}

	}

	private class GameCycle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			doGameCycle();
		}
	}

}
