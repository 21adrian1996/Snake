package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class Snake extends GameElements{
	public boolean isAbbgenippelt;
	private int speed = 1500;
	private int positionX1;
	private int positionY1;
	private String direction = "right";
	private Vector<SnakeParts> parts = new Vector();
	
	Snake(int positionX, int positionY, int positionX1, int positionY1, boolean isAbgenippelt, int speed){
		super(positionX, positionY);
		this.isAbbgenippelt = isAbgenippelt;
		this.speed = speed * super.UNIT;
		this.positionX1 = positionX1 * super.UNIT;
		this.positionY1 = positionY1 * super.UNIT;
		
		
	}
	public void draw(Graphics g){
		g.setColor(Color.black);
		for(SnakeParts s : parts){
			g.drawRect(s.positionX, s.positionY,super.UNIT,super.UNIT);
			g.fillRect(s.positionX, s.positionY,super.UNIT,super.UNIT);
		}
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	public int getSpeed(){
		return this.speed;
	}
	public void move(int direction){
		 switch (direction) {
         case 37:
         case 65:
        	    if(this.direction != "right"){
        	 	    this.direction = "left";
        	    }
                break;
         case 38:
         case 87:
        	 	if(this.direction != "down"){
        	 		this.direction = "up";
     	    	}
                break;
         case 39: 
         case 68:
        	 	if(this.direction != "left"){
     	 	    	this.direction = "right";
     	    	}
                break;
         case 40:
         case 83:
        	 	if(this.direction != "up"){
     	 	    	this.direction = "down";
     	    	}
                break;
         default:
         case 0:
                break;
		 }
		SnakeParts lastElement = this.parts.lastElement();
		int currentX = lastElement.positionX;
		int currentY = lastElement.positionY;
			if(this.direction == "right"){
				currentX = currentX + super.UNIT;
			}else if(this.direction == "left"){
				currentX = currentX - super.UNIT;
			}else if(this.direction == "up"){
				currentY = currentY - super.UNIT;
			}else if(this.direction == "down"){
				currentY = currentY + super.UNIT;
			}
			this.parts.addElement(new SnakeParts(currentX, currentY));
			this.parts.remove(this.parts.firstElement());
	}
	public void addParts(){
		parts.addElement(new SnakeParts(this.positionX, this.positionY));
		parts.addElement(new SnakeParts(this.positionX+super.UNIT, this.positionY));
		parts.addElement(new SnakeParts(this.positionX+2*super.UNIT, this.positionY));
	}
}
