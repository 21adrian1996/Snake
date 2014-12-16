package snake;

import java.awt.Graphics;
import java.util.Vector;
/**
 * @author Adrian Berger
 * @version 1.0.0
 * @since jdk7.8
 */
public class SnakeParts extends GameElements {
	
	SnakeParts(int positionX, int positionY){
		super(positionX, positionY);
	}

	public void draw(Graphics g){};
	public boolean checkCollison(Snake s){
		return false;
	};
}