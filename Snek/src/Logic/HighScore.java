package Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Hanterar spelare och tidigare spelares highscore.*/
public class HighScore { //Läser in från en fil

	private String filen = "src/Logic/highscore.txt"; // Här placerar vi en tom txt fil.
	private int checkScore = 0;
	private int currentHScore = 0;

	private FileWriter writeFile;
	private BufferedWriter writer;

	Snek snek = new Snek();
	private Scanner reader2;

//Läser vad som finns i dokumentet. Placeras i SouthPanel
	public int HighScore() throws IOException {

		reader2 = new Scanner(new File(filen));
		while (reader2.hasNext()) {
			currentHScore = reader2.nextInt();
		}
		return currentHScore;

	}

//Kontrollerar ifall spelaren har fått ett highscore och skriver is�fall in det i filen.
	public boolean SetScore() {
		if (checkScore > currentHScore) {
			try (PrintWriter out = new PrintWriter(filen)) {
				out.println(checkScore);
				currentHScore = checkScore;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

	public int getCurrentHScore() {
		return currentHScore;
	}

	public void setCheckScore(int checkScore) {
		this.checkScore = checkScore;
	}
}