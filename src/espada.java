import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class espada extends JPanel implements sprite{
	
	private final int derecha = 1;
	private final int izquierda = 2;
	private int ancho = 20 * ventana.escala;
	private int alto = 6 * ventana.escala;
	int x, y, direction, i, ii;
	boolean golpeado;
	ImageIcon icon;
	Image dibujo;
	Rectangle rec;

	public espada(int xP, int yP, int directionP){		
		
		golpeado = false;
		
		y = yP + (17* ventana.escala);
		direction = directionP;
		
		if(direction == derecha){
			
			x = xP + jugador.ancho;
			icon = new ImageIcon("sprites/weapons/sword-r.png");
			dibujo = icon.getImage();
		
		}else if(direction == izquierda){
			
			x = xP - ancho;
			icon = new ImageIcon("sprites/weapons/sword-l.png");
			dibujo = icon.getImage();
			
		}
		rec = new Rectangle(x,y,ancho, alto);
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
	public void paint(Graphics g) {
		
		g.drawImage(dibujo, x, y,ancho, alto, this);
		
	}

	@Override
	public void move() {
		
		rec = new Rectangle(x,y,ancho,alto);
		
		if(i < 3){
			
			for(ii=0; ii<dibujador.sprites.size(); ii++){
				
				if(rec.intersects(dibujador.sprites.get(ii).getRec()) == true && golpeado == false){
					
					dibujador.sprites.get(ii).golpeado();
					
					golpeado = true;
				}
			}
			i++;
			
		}else{
			
			dibujador.sprites.remove(this);
			//Musica.ataque.stop();
		}
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
