package snake;
import java.util.Vector;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends KeyAdapter {
	private Vector<GameElements> elements = new Vector();
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
		  Snake snake = (Snake)this.elements.get(1);
		  if(snake.isAbbgenippelt == false){
			  snake.move(e.getKeyCode());
			  this.gui.repaint();
		  }
	  }
	public static void main(String[] args){	
		Zufallsgenerator generator= new Zufallsgenerator();
		Diamond dia = new Diamond(generator.zufallszahl(1, 23),generator.zufallszahl(1, 14),100);
		Snake snake = new Snake(1,1, false, 10);
		snake.addParts();
		GameBorder border = new GameBorder(1,1,25,15);
		Vector<GameElements> GameElements = new Vector();
		GameElements.addElement(dia);
		GameElements.addElement(snake);
		GameElements.addElement(border);
		Game game = new Game(GameElements);
		while(snake.isAbbgenippelt == false){
			try{
				Thread.sleep(snake.getSpeed());
				snake.move(0);
				for(GameElements g : game.elements){
					g.checkCollison(snake);
				}
				game.gui.repaint();
			}catch(InterruptedException e){
				
			} 
			
		}
		System.out.println(snake.value);
	}
	
}