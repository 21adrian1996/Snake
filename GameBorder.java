package snake;

import java.awt.Graphics;

public class GameBorder extends GameElements {
	private int width;
	private int height;
	
	GameBorder(int positionX, int positionY, int width, int height){
		super(positionX, positionY);
		this.width = width * super.UNIT;
		this.height = height * super.UNIT;
	}
	public void draw(Graphics g){
		g.drawRect(1,1, this.width,this.height);
	}
	public boolean checkCollison(Snake s){
				if(s.parts.lastElement().positionX == super.UNIT || s.parts.lastElement().positionY == 0-super.UNIT 
						|| s.parts.lastElement().positionY == this.height || s.parts.lastElement().positionX == this.width){
			    	s.isAbbgenippelt = true;
			    	return true;
		    	}

		return false;
	};

}