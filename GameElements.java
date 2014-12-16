package snake;

import java.awt.Graphics;
/**
 * @author Adrian Berger
 * @version 1.0.0
 * @since jdk7.8
 */
public abstract class GameElements {
	protected int positionX;
	protected int positionY;
	protected static final int UNIT = 25;
	GameElements(int positionX, int positionY){
		this.positionX = positionX * this.UNIT;
		this.positionY = positionY * this.UNIT;
	}
	public abstract void draw(Graphics g);
	public abstract boolean checkCollison(Snake s);
}