package snake;
import java.util.Vector;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends KeyAdapter {
	private Vector<GameElements> elements;
	private GUI gui;
	
	Game(Vector<GameElements> elements){
		this.gui = new GUI(this);
	    this.elements = elements;
	}
	public void drawElements(Graphics g) {  
		  for (GameElements e : this.elements) {
			    e.draw(g);
		  }
	}
	public void addFigur(GameElements element) {
		this.elements.addElement(element);
	}
	public void keyPressed(KeyEvent e) {
		  Snake putzi = (Snake)this.elements.get(1);
		  putzi.move(e.getKeyCode());
		  this.gui.repaint();
	  }
	public static void main(String[] args){	
		Zufallsgenerator generator= new Zufallsgenerator();
		Diamond dia = new Diamond(generator.zufallszahl(1, 24),generator.zufallszahl(1, 15),100);
		Snake putzi = new Snake(1,1,6,1, false, 10);
		putzi.addParts();
		GameBorder border = new GameBorder(0,0,25,15);
		Vector<GameElements> GameElements = new Vector();
		GameElements.addElement(dia);
		GameElements.addElement(putzi);
		GameElements.addElement(border);
		Game game = new Game(GameElements);
		while(putzi.isAbbgenippelt == false){
			try{
				Thread.sleep(putzi.getSpeed());
				putzi.move(0);
				game.gui.repaint();
			}catch(InterruptedException e){
				
			} 
			
		}
	}
	
}
