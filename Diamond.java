package snake;

import java.awt.Graphics;
import java.awt.Color;
public class Diamond extends GameElements {
    private int value;
    private int color;
    
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
    public void remove(Graphics g){
    //	g.clearOval(10,10,10,10);
    }
    
}
