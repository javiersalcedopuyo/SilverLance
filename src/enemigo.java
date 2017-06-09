import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class enemigo extends JPanel implements sprite{
	
	private final int derecha = 1;
	private final int izquierda = 2;
	
	private final int ninja = 0;
	private final int mago = 1;
	
	int alto = 55 * ventana.escala;
	int ancho = 29 * ventana.escala;
	int x = 300 * ventana.escala;
	int y = ventana.alto - alto;
	int direction;
	int velocidad;
	int distancia;
	int vida;
	int valor;
	int clase;
	int i;
	
	ImageIcon icon;
	Image spriteR1, spriteR2, spriteL1, spriteL2, spriteAttackR, spriteAttackL, spriteAhora, spriteRedR, spriteRedL;

	Rectangle rec;
	
	public enemigo(){
		
	
	}
	
	public void move() {
		
		if(distancia > 0){
			
			if(direction == derecha){
				
				x = x + velocidad;
				
				
			}else if(direction == izquierda){
				
				x = x - velocidad;
				
			}
			
			distancia--;
			
		}else if(distancia <= 0){
			
			if(direction == derecha){
				
				direction = izquierda;
				
			}else if(direction == izquierda){
				
				direction = derecha;
			}
			
			distancia = (int)(Math.random()*(10-51)+50);
		
			
		}
		
		if(dibujador.sprites.get(0).getX() >= 150 * ventana.escala){
			
			x = x - (int)(dibujador.sprites.get(0).getSpeed()/2);
			
		}

		if(x < -ancho){
			
			dibujador.sprites.remove(this);
		}
 		
		if(direction == derecha && i > 5){
			
			if(spriteAhora == spriteR1){
				
				spriteAhora = spriteR2;
			
			}else{
			
				spriteAhora = spriteR1;
			}
			i = 0;
			
		}else if(direction == izquierda && i > 5){
			
			if(spriteAhora == spriteL1){
				
				spriteAhora = spriteL2;
			
			}else{
			
				spriteAhora = spriteL1;
				
			}
			i=0;
		}
		rec = new Rectangle(x, y, ancho, alto);
		
		if(x < -ancho){
			
			dibujador.sprites.remove(this);
		}
	}
	public void paint(Graphics g){
		
		g.drawImage(spriteAhora, x, y,ancho, alto, this);
		i++;
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void golpeado() {
		
		Musica.ataque();
		
		vida = vida - 1;
		
		if(direction == derecha){
			
			spriteAhora = spriteRedR;
			
		}else if(direction == izquierda){
			
			spriteAhora = spriteRedL;
		}
		
		if(vida == 0){
			
			this.muerte();
		}
		
		return;
	}

	public void muerte() {
		
		dibujador.numeroEnemigos--;
		dibujador.score = dibujador.score + valor;
		dibujador.sprites.remove(this);
		
	}

	@Override
	public void ataque() {
		// TODO Auto-generated method stub
		
	}



	public void colision() {
		
		
	}

	public int getX(){
		
		return x;
	}
	
	public int getY(){
		
		return y;
	}
	
	public Rectangle getRec() {
		
		return null;
	}

	@Override
	public int getSpeed() {
		
		return velocidad;

	}
	public void keyPressed(KeyEvent tecla) {		
	}
	public void keyReleased(KeyEvent tecla) {		
	}
	public void keyTyped(KeyEvent tecla) {
	}
	public void salto() {
	}

	@Override
	public int getALife() {
		// TODO Auto-generated method stub
		return vida;
	}
	
}