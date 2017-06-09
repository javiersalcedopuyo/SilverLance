import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class spell extends JPanel implements sprite{

	private final int derecha = 1;
	private final int izquierda = 2;
	private final int ice = 1;
	private final int fire = 2;
	private final int magic = 3;
	private int tipo, ruleta;
	private int ancho = 10* ventana.escala;
	private int alto = 10 * ventana.escala;
	int x, y, direction, i, ii;
	ImageIcon icon;
	Image dibujo;
	Rectangle rec;
	
	public spell(int xP, int yP, int directionP){
		
		y = yP + (17* ventana.escala);
		direction = directionP;
		
		ruleta = (int)(Math.random()*10);
		
		if(ruleta >= 0 && ruleta < 5){
			
			tipo = ice;
			
		}else if(ruleta >= 5 && ruleta < 8){
			
			tipo = fire;
			
		}else if(ruleta >= 8 && ruleta <= 10){
			
			tipo = magic;
		}
		
		if(direction == derecha){
			
			x = xP + jugador.ancho;
			
			if(tipo == ice){
				
				icon = new ImageIcon("sprites/weapons/ice-spell-r.png");
				dibujo = icon.getImage();
				
			}else if(tipo == fire){
				
				icon = new ImageIcon("sprites/weapons/fire-spell-r.png");
				dibujo = icon.getImage();
				
			}else if(tipo == magic){
				
				icon = new ImageIcon("sprites/weapons/green-spell-r.png");
				dibujo = icon.getImage();
				
			}
		
		}else if(direction == izquierda){
			
			x = xP - ancho;
			
			if(tipo == ice){
				
				icon = new ImageIcon("sprites/weapons/ice-spell-l.png");
				dibujo = icon.getImage();
				
			}else if(tipo == fire){
				
				icon = new ImageIcon("sprites/weapons/fire-spell-l.png");
				dibujo = icon.getImage();
				
			}else if(tipo == magic){
				
				icon = new ImageIcon("sprites/weapons/green-spell-l.png");
				dibujo = icon.getImage();
				
			}
			
		}
		rec = new Rectangle(x,y,ancho, alto);
	}

	public void move() {
		
		if(direction == derecha){
			
			x = x + 5* ventana.escala;
			if(dibujador.sprites.get(0).getX() >= 165* ventana.escala){
				
				x = x + (int)(dibujador.sprites.get(0).getSpeed()/2);
				
			}
		
		}else if(direction == izquierda){
			
			x = x -5* ventana.escala;
			if(dibujador.sprites.get(0).getX() >= 165* ventana.escala){
				
				x = x - (int)(dibujador.sprites.get(0).getSpeed()/2);
				
			}
		}
		
		rec = new Rectangle(x,y,ancho,alto);
				
		for(ii=1; ii<dibujador.sprites.size(); ii++){
			
			if(rec.intersects(dibujador.sprites.get(ii).getRec()) == true && dibujador.sprites.get(ii) != this){
					
				dibujador.sprites.get(ii).golpeado();
				dibujador.sprites.remove(this);
			}
		}
			
		if(x > 256* ventana.escala || x < -ancho){
			
			dibujador.sprites.remove(this);
		}
		
	}


	public void paint(Graphics g) {
		
		g.drawImage(dibujo, x, y, ancho, alto, this);
		
	}
	
	@Override
	public void salto() {
	
		
	}

	@Override
	public void muerte() {
		// TODO Auto-generated method stub
		
	}

	public void colision() {
		
		dibujador.sprites.get(0).golpeado();
		dibujador.sprites.remove(this);

		
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
		
		return 0;
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
