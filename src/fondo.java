import java.awt.Graphics;


public interface fondo {

	public void paint(Graphics g);
	
	public void move();
	
	public int getX();
	
	public int getY();
	
	public void borrar();
}
