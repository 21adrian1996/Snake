package snake;

import java.awt.Graphics;
import java.awt.Color;
public class Diamond extends GameElements {
    private int value = 1;
    
    Diamond(int positionX, int positionY, int value){
    	super(positionX, positionY);	
    }
    public void draw(Graphics g){
    	Zufallsgenerator generator= new Zufallsgenerator();
    	g.setColor(Color.white);
		g.drawOval(this.positionX,this.positionY,25,25);
		Color c = new Color(generator.zufallszahl(1, 255),generator.zufallszahl(1, 255),generator.zufallszahl(1, 255));
		g.setColor(c);
		g.fillOval(this.positionX,this.positionY,25,25);
	}
    public boolean checkCollison(Snake s){
	    if(this.positionX == s.parts.lastElement().positionX && this.positionY == s.parts.lastElement().positionY){
	    	Zufallsgenerator generator= new Zufallsgenerator();
	    	s.addParts();
	    	s.setSpeed(10);
	    	s.addToValue(this.value);
	    	this.positionX = generator.zufallszahl(1, 23) * super.UNIT;
	    	this.positionY = generator.zufallszahl(1, 14) * super.UNIT;
	    	this.value = generator.zufallszahl(1, 5);
    	}
		return false;
	};
    
}