import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class corazon extends JPanel implements sprite{

	int y = 2;
	int x;
	int ancho = 11 * ventana.escala;
	int alto = 9* ventana.escala;
	public static int i;
	
	ImageIcon icon;
	Image corasonLatino;
	
	public corazon(int i){
		
		icon = new ImageIcon("sprites/others/heart.png");
		corasonLatino = icon.getImage();
		
		x = ventana.ancho -  ancho - (ancho * i) -2*ventana.escala;
		
	}
	public void paint(Graphics g) {
		
		g.drawImage(corasonLatino, x, y, ancho, alto, this);
		
	}
	
	@Override
	public void keyPressed(KeyEvent tecla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent tecla) {
		// TODO Auto-generated method stub
		
	}


	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ataque() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void golpeado() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void muerte() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getALife() {
		// TODO Auto-generated method stub
		return 0;
	}

}
