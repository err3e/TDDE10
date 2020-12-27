package Logic;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import Graphics.EnemyOneHit;
import Graphics.EnemyTwoHit;
import Graphics.GameWindow;
import Graphics.PlayArea;

/* Denna klass är själva hjärnan bakom spelet. Den innehåller delvis en loop som är det som får själva spelet att snurra (den får snek att öka etc.)*/
public class Game {
	private Snek snek = new Snek();
	private GameWindow gameWindow = new GameWindow();
	private PlayArea playArea;
	private int sleepTime = 100;
	private Thread thread = new Thread();
	private int bulletTimer = 0, powerUpTimer = 0, enemyOneCounter = 1, enemyTwoCounter = 1, slownessCounter = 1,
			slownessMultiplier = 1, avoidCollisionCounter = 1;
	private Random random = new Random();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<PowerUp> playAreaPowerUps = new ArrayList<PowerUp>();
	private HighScore highScore = new HighScore();
	private boolean map2 = false;

	public Game() {

		playArea = gameWindow.getPlayArea();
		playArea.setSnek(snek);
		playArea.setEnemies(enemies);
		playArea.setPlayAreaPowerUps(playAreaPowerUps);

		gameWindow.setSnek(snek);
		gameWindow.setFocusable(true);
		gameWindow.setGame(this);
		gameWindow.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (!snek.isOnTheMove()) {
					if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT
							|| e.getKeyCode() == KeyEvent.VK_DOWN) {
						snek.setOnTheMove(true);
					}
				}
				if (snek.isOnTheMove() && e.getKeyCode() == KeyEvent.VK_UP) {
					if (snek.getyDirection() != 1) {
						System.out.println("UP");
						snek.setyDirection(-1);
						snek.setxDirection(0);
					}
				}
				if (snek.isOnTheMove() && e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (snek.getyDirection() != -1) {
						System.out.println("DOWN");
						snek.setyDirection(1);
						snek.setxDirection(0);
					}
				}
				if (snek.isOnTheMove() && e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("LEFT");
					if (snek.getxDirection() != 1) {
						snek.setxDirection(-1);
						snek.setyDirection(0);
					}
				}
				if (snek.isOnTheMove() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("RIGHT");
					if (snek.getxDirection() != -1) {
						snek.setxDirection(1);
						snek.setyDirection(0);
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE && bulletTimer >= 100) {
					snek.createBullet();
					bulletTimer = 0;
					System.out.println("Fire!!!!");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

	}

	public void Run() {

		while (true) {
			playArea.repaint();

			// Hanterar bullet
			handleBullet();

			// Hanterar snek
			handleSnek();

			// Hanterar food
			handleFood();

			// Hanterar powerUps
			handlePowerUps();

			// Hanterar enemies
			handleEnemies();

			// V�ntar i X ms
			try {
				thread.sleep(sleepTime * slownessMultiplier);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Uppdaterar southpanels score och highscore.
			gameWindow.getSouthPanel().getCurrentScore().setText("Score: " + snek.getScore());

			highScore.setCheckScore(snek.getScore());
			highScore.SetScore();
			try {
				highScore.HighScore();
			} catch (IOException e) {
				e.printStackTrace();
			}
			gameWindow.getSouthPanel().getHighscore().setText("Highscore: " + highScore.getCurrentHScore());

			gameWindow.getSouthPanel().repaint();
			gameWindow.repaint();

			// Kollar om snek kraschar. Skapar ny snek efter 5 sekunder och �terst�ller
			// parametrar f�r att b�rja om spelet.
			if (snek.checkCollision(enemies)) {

				try {
					thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				newGame();
				continue;
			}

		}
	}

	public void handleEnemies() {
		if (snek.getScore() % 3 == 0 && snek.getScore() != 0) {
			if ((snek.getScore() / enemyOneCounter) % 3 == 0) {
				enemies.add(new EnemyOneHit(489 + (random.nextInt(11 - -12 + 1) + -12) * 25,
						490 + (random.nextInt(10 - -13 + 1) + -13) * 25, new Color(255, 0, 0)));
				enemyOneCounter++;
			}
		}

		if (snek.getScore() % 10 == 0 && snek.getScore() != 0) {
			if ((snek.getScore() / enemyTwoCounter) % 10 == 0) {
				enemies.add(new EnemyTwoHit(489 + (random.nextInt(11 - -12 + 1) + -12) * 25,
						490 + (random.nextInt(10 - -13 + 1) + -13) * 25, new Color(190, 0, 190)));
				enemyTwoCounter++;
			}
		}

	}

	public void handlePowerUps() {
		// L�gger till slowness power ups

		if (snek.getScore() % 5 == 0 && snek.getScore() != 0) {
			if ((snek.getScore() / slownessCounter) % 5 == 0) {
				playAreaPowerUps.add(new Slowness(489 + (random.nextInt(11 - -12 + 1) + -12) * 25,
						490 + (random.nextInt(10 - -13 + 1) + -13) * 25, new Color(0, 0, 255)));
				slownessCounter++;
			}
		}

		// L�gger till avoidCollision power ups.

		if (snek.getScore() % 12 == 0 && snek.getScore() != 0) {
			if ((snek.getScore() / avoidCollisionCounter) % 12 == 0) {
				playAreaPowerUps.add(new AvoidCollision(489 + (random.nextInt(11 - -12 + 1) + -12) * 25,
						490 + (random.nextInt(10 - -13 + 1) + -13) * 25, new Color(165, 42, 42)));
				avoidCollisionCounter++;
			}
		}

		// Kollar kollision med power ups och utf�r dess effekter. Tar �ven bort fr�n
		// playArea. Detta g�rs endast om snek inte redan har en powerUp. Den kan bara
		// ha en �t g�ngen.
		if (!snek.isHasPowerUp()) {
			for (int i = 0; i < playAreaPowerUps.size(); ++i) {
				if (playAreaPowerUps.get(i).getPosX() == snek.getSnekComponents().get(0).getPosX()
						&& playAreaPowerUps.get(i).getPosY() == snek.getSnekComponents().get(0).getPosY()) {

					// Utf�r effekter
					slownessMultiplier = playAreaPowerUps.get(i).getSlownessMultiplier();
					snek.setAvoidCollision(playAreaPowerUps.get(i).isAvoidCollision());
					playAreaPowerUps.remove(i);
					snek.setHasPowerUp(true);
				}
			}
		} else {
			System.out.println("PowerUpTimer v�xer med 1");
			powerUpTimer++;
			// �terst�ller slownessMultiplier och �ven collision med sig sj�lv.
			if (slownessMultiplier * powerUpTimer == 100) {
				slownessMultiplier = 1;
				powerUpTimer = 0;
				snek.setAvoidCollision(false);
				snek.setHasPowerUp(false);
			}
		}
	}

	public void handleBullet() {
		bulletTimer = bulletTimer + 1 * slownessMultiplier;
		if (snek.getBullet() != null) {

			// kollar om bullet kolliderar med v�ggarna eller enemies.
			if (snek.checkBulletCollision(enemies)) {
				snek.removeBullet();
			} else {
				// flyttar p� bullet
				snek.getBullet().move();
			}
		}
	}

	public void handleSnek() {
		snek.setMap2(map2);
		if (snek.getxDirection() == 1) {

			for (int i = snek.getLength() - 1; i > 0; --i) {
				snek.getSnekComponents().get(i).setPosX(snek.getSnekComponents().get(i - 1).getPosX());
				snek.getSnekComponents().get(i).setPosY(snek.getSnekComponents().get(i - 1).getPosY());
			}
			snek.getSnekComponents().get(0).setPosX(snek.getSnekComponents().get(0).getPosX() + 25);
		}

		if (snek.getxDirection() == -1) {
			for (int i = snek.getLength() - 1; i > 0; --i) {
				snek.getSnekComponents().get(i).setPosX(snek.getSnekComponents().get(i - 1).getPosX());
				snek.getSnekComponents().get(i).setPosY(snek.getSnekComponents().get(i - 1).getPosY());
			}
			snek.getSnekComponents().get(0).setPosX(snek.getSnekComponents().get(0).getPosX() - 25);
		}

		if (snek.getyDirection() == -1) {
			for (int i = snek.getLength() - 1; i > 0; --i) {
				snek.getSnekComponents().get(i).setPosX(snek.getSnekComponents().get(i - 1).getPosX());
				snek.getSnekComponents().get(i).setPosY(snek.getSnekComponents().get(i - 1).getPosY());
			}
			snek.getSnekComponents().get(0).setPosY(snek.getSnekComponents().get(0).getPosY() - 25);
		}

		if (snek.getyDirection() == 1) {
			for (int i = snek.getLength() - 1; i > 0; --i) {
				snek.getSnekComponents().get(i).setPosX(snek.getSnekComponents().get(i - 1).getPosX());
				snek.getSnekComponents().get(i).setPosY(snek.getSnekComponents().get(i - 1).getPosY());
			}
			snek.getSnekComponents().get(0).setPosY(snek.getSnekComponents().get(0).getPosY() + 25);
		}
	}

	public void handleFood() {
        // Kollar om snek äter maten samt om maten spawnar i korset i map2.
        if (playArea.checkFoodCollision()) {

            snek.addComponents();
            int x = 489 + (random.nextInt(11 - -12 + 1) + -12) * 25;
            int y = 490 + (random.nextInt(10 - -13 + 1) + -13) * 25;

            if (!map2) {
                playArea.getFood().setPosX(x);
                playArea.getFood().setPosY(y);
            } else {
                for (int i = -4; i < 5; i++) {

                    if (x == 489 + (i * 25) && y == 465 || (x == 489 && y == 465 + (i * 25))) {
                        x = x + 6 * 25;
                        y = y + 6 * 25;
                        break;
                    }
                }
                playArea.getFood().setPosX(x);
                playArea.getFood().setPosY(y);
            }
        }
    }

	public void newGame() {
		snek = new Snek();
		snek.setMap2(map2);
		enemies.removeAll(enemies);
		playAreaPowerUps.removeAll(playAreaPowerUps);
		gameWindow.setSnek(snek);
		playArea.setSnek(snek);
		gameWindow.repaint();
		playArea.repaint();
		sleepTime = 100;

		bulletTimer = 0;
		powerUpTimer = 0;
		enemyOneCounter = 1;
		enemyTwoCounter = 1;
		slownessCounter = 1;
		slownessMultiplier = 1;
		avoidCollisionCounter = 1;
	}

	// Getters och setters
	public Snek getSnek() {
		return snek;
	}

	public void setSnek(Snek snek) {
		this.snek = snek;
	}

	public Thread getThread() {
		return thread;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public HighScore getHighScore() {
		return highScore;
	}

	public boolean isMap2() {
		return map2;
	}

	public void setMap2(boolean map2) {
		this.map2 = map2;
	}

}
