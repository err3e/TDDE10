package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import Logic.Game;
import Logic.Snek;

/*Denna klass �r det som h�ller koll p� f�nstrets olika element.*/
public class GameWindow extends JFrame {

	private Snek snek = new Snek();
	private PlayArea playArea;
	private Game game;
	private SouthPanel southPanel;

	public GameWindow() {
		super("Snek");

		setLayout(new BorderLayout());
		this.setResizable(false);
		MenuPanel menuPanel = new MenuPanel();
		menuPanel.add(Box.createGlue());
		JButton goToGameButton = new JButton("Play the game");
		goToGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				playArea.setVisible(true);
				southPanel.setVisible(true);
			}
		});
		menuPanel.add(goToGameButton);
		menuPanel.add(Box.createGlue());
		this.add(menuPanel, BorderLayout.NORTH);

		JLabel menuPicture = new JLabel();
		try {
			menuPicture.setIcon(new ImageIcon(ImageIO.read(new File("src/Graphics/SnekV4.png"))));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		menuPanel.add(menuPicture, BorderLayout.SOUTH);

		JToggleButton map1Button = new JToggleButton("Map 1 - Ezy");
		map1Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setMap2(false);
				playArea.setMap2(false);
				snek.setMap2(false);
				game.newGame();
			}
		});
		menuPanel.add(map1Button);
		menuPanel.add(Box.createGlue());

		JToggleButton map2Button = new JToggleButton("Map 2 - Harrrd");
		map2Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.setMap2(true);
				playArea.setMap2(true);
				snek.setMap2(true);
				game.newGame();
			}
		});
		menuPanel.add(map2Button);
		menuPanel.add(Box.createGlue());

		ButtonGroup mapGroup = new ButtonGroup();
		mapGroup.add(map1Button);
		mapGroup.add(map2Button);
		menuPanel.setVisible(true);

		playArea = new PlayArea();
		this.add(playArea, BorderLayout.CENTER);
		playArea.setVisible(false);

		try {
			southPanel = new SouthPanel();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		southPanel.setSnek(snek);
		southPanel.setBackground(new Color(230, 230, 255));
		southPanel.setVisible(false);

		JButton menuButton = new JButton("Menu");
		menuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(true);
				playArea.setVisible(false);
				southPanel.setVisible(false);
			}
		});

		southPanel.add(menuButton);
		this.add(southPanel, BorderLayout.SOUTH);

		this.setSize(995, 995);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// getters och setters
	public Snek getSnek() {
		return snek;
	}

	public void setSnek(Snek snek) {
		this.snek = snek;
	}

	public PlayArea getPlayArea() {
		return playArea;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public SouthPanel getSouthPanel() {
		return southPanel;
	}

}
