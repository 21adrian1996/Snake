package snake;

/**
 * @author Adrian Berger
 * @version 1.0.0
 * @since jdk7.8
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class Snake extends GameElements{
	public boolean isAbbgenippelt;
	private int speed = 100000;
	private String direction = "right";
	public int value;
	public Vector<SnakeParts> parts = new Vector();
	
	Snake(int positionX, int positionY, boolean isAbgenippelt, int speed){
		super(positionX, positionY);
		this.isAbbgenippelt = isAbgenippelt;
		this.speed = speed * super.UNIT;
		for(int i = 0; i < 5; i++){
			parts.addElement(new SnakeParts(this.positionX/super.UNIT+i, this.positionY /super.UNIT));
		}
		
		
	}
	public void draw(Graphics g){
		g.setColor(Color.black);
		for(SnakeParts s : parts){
			g.drawRect(s.positionX, s.positionY,super.UNIT,super.UNIT);
			g.fillRect(s.positionX, s.positionY,super.UNIT,super.UNIT);
		}
	}
	public void setSpeed(int speed){
		if(this.speed > speed){
			this.speed = this.speed - speed;
		}
	}
	public void addToValue(int val){
		this.value += val;
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
		int currentX = lastElement.positionX / 25;
		int currentY = lastElement.positionY / 25;
			if(this.direction == "right"){
				currentX = currentX + 1;
			}else if(this.direction == "left"){
				currentX = currentX - 1;
			}else if(this.direction == "up"){
				currentY = currentY - 1;
			}else if(this.direction == "down"){
				currentY = currentY + 1;
			}
			this.parts.addElement(new SnakeParts(currentX, currentY));
			this.parts.remove(this.parts.firstElement());
	}
	public void addParts(){
		SnakeParts lastElement = this.parts.lastElement();
		int currentX = lastElement.positionX / 25;
		int currentY = lastElement.positionY / 25;
			if(this.direction == "right"){
				currentX = currentX + 1;
			}else if(this.direction == "left"){
				currentX = currentX - 1;
			}else if(this.direction == "up"){
				currentY = currentY - 1;
			}else if(this.direction == "down"){
				currentY = currentY + 1;
			}
			this.parts.addElement(new SnakeParts(currentX, currentY));
		
	}
	public boolean checkCollison(Snake s){
		for(SnakeParts p : parts){
			if(p != s.parts.lastElement()){
				if(p.positionX == s.parts.lastElement().positionX && p.positionY == s.parts.lastElement().positionY){
			    	s.isAbbgenippelt = true;
			    	return true;
		    	}
			}
		}
		return false;
	};
}