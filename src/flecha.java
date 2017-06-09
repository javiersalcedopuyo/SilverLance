import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class flecha extends JPanel implements sprite{

	private final int derecha = 1;
	private final int izquierda = 2;
	private int ancho = 9 * ventana.escala;
	private int alto = 3 * ventana.escala;
	int x, y, direction, i, ii;
	ImageIcon icon;
	Image dibujo;
	Rectangle rec;

	public flecha(int xP, int yP, int directionP){
		
		y = yP + (17* ventana.escala);
		direction = directionP;
		
		if(direction == derecha){
			
			x = xP + jugador.ancho + 1;
			icon = new ImageIcon("sprites/weapons/arrow-r.png");
			dibujo = icon.getImage();
		
		}else if(direction == izquierda){
			
			x = xP - ancho - 1;
			icon = new ImageIcon("sprites/weapons/arrow-l.png");
			dibujo = icon.getImage();
			
		}
		rec = new Rectangle(x,y,ancho, alto);
	}
	
	public void paint(Graphics g) {
		
		g.drawImage(dibujo, x, y, ancho, alto, this);
		
	}
	public void move() {
		
		if(direction == derecha){
			
			x = x + 10* ventana.escala;
		
		}else if(direction == izquierda){
			
			x = x -10* ventana.escala;
		}
		
		rec = new Rectangle(x,y,ancho,alto);
			
		for(ii=1; ii<dibujador.sprites.size(); ii++){
				
			if(rec.intersects(dibujador.sprites.get(ii).getRec()) == true && dibujador.sprites.get(ii) != this){
					
				dibujador.sprites.get(ii).golpeado();
				dibujador.sprites.remove(this);
			}
		}
			
		if(x > 260* ventana.escala || x < -ancho){
			
			dibujador.sprites.remove(this);
		}
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
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return rec;
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