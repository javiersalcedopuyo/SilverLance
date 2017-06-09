import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public interface sprite {
	
	public void keyPressed(KeyEvent tecla);
	
	public void keyReleased(KeyEvent tecla);
	
	public void keyTyped(KeyEvent tecla);

	public void paint(Graphics g);
	
	public void move();
	
	public void salto();
	
	public void ataque();
	
	public void golpeado();
	
	public void muerte();
	
	public void colision();
	
	public int getX();
	
	public int getY();
	
	public Rectangle getRec();
	
	public int getSpeed();
	
	public int getALife();
}