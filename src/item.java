import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class item extends JPanel implements sprite{
	
	int x, y, speed, i, aux, ancho, alto;
	Rectangle rec;
	ImageIcon icon;
	Image dibujo;
	
	public item(){

		
	}

	public void paint(Graphics g) {
		
		g.drawImage(dibujo, x, y, ancho, alto, this);
		
	}

	public void move() {
		
		if(dibujador.sprites.get(0).getX() >= 150* ventana.escala){
			
			x = x - (int)(dibujador.sprites.get(0).getSpeed()/2);
			
		}

	}
	public void salto(){
		
		
	}

	public void ataque() {
		
	}

	public void golpeado() {
		
	}

	public void muerte() {
		
	}

	public void colision() {
		
	}

	public int getX() {

		return x;
	}

	public int getY() {
		
		return y;
	}

	public Rectangle getRec() {
		
		return rec;
	}

	public int getSpeed() {
		
		return speed;
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

	@Override
	public int getALife() {
		// TODO Auto-generated method stub
		return 0;
	}

}
