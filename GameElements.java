package snake;

import java.awt.Graphics;

public abstract class GameElements {
	protected int positionX;
	protected int positionY;
	protected final int UNIT = 25;
	GameElements(int positionX, int positionY){
		this.positionX = positionX * this.UNIT;
		this.positionY = positionY * this.UNIT;
	}
	public abstract void draw(Graphics g);
}
