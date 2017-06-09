import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class jugador extends JPanel implements sprite{
	
	private final int SirChapman = 1;
	private final int SirGalahad = 2;
	private final int SirLancebot = 3;
	private final int elite = 4;

	int quieto = 0;
	int derecha = 1;
	int izquierda = 2;
	int gravedad = -2 * ventana.escala;
	int velocidad;
	int impulsoOriginal;
	public static final int alto = 55 * ventana.escala;
	public static final int ancho = 29 * ventana.escala;
	int x, y, impulso, direction, attackDirection, i, ii, iii, aux;
	public static int speedNow;
	ImageIcon icon = new ImageIcon("gameOver.png");
	ImageIcon icon2 = new ImageIcon("victory.png");
	Image spriteAhora;
	Image spriteQuieto;
	Image spriteR1;
	Image spriteR2;
	Image spriteL1;
	Image spriteL2;
	Image spriteAttackR;
	Image spriteAttackL;
	Image spriteJumpR;
	Image spriteJumpL;
	Image spriteRedR;
	Image spriteRedL;
	Image spriteRed;
	Image gameOverScreen = icon.getImage();		
	Image VICTORY = icon2.getImage();
	boolean salto = false;
	boolean attack = false;
	boolean muerto = false;
	boolean victoria = false;
	boolean pausado = false;
	boolean saltando = false;
	int vida;
	

	
	Rectangle rec;
	
	public jugador(){
		
	}

	public void keyPressed(KeyEvent tecla) {
		
		if(tecla.getKeyCode() == 68){
			
			direction = derecha;
			speedNow = velocidad;
			attackDirection = derecha;
			
		}else if(tecla.getKeyCode() == 65){
			
			direction = izquierda;
			speedNow = velocidad;
			attackDirection = izquierda;
			
		}else if(tecla.getKeyCode() == 75){
			
			attack = true;
		}
		
		if(tecla.getKeyCode() == 27 && pausado == false){
			
			pausado = true;
			dibujador.timer.cancel();
			
		}
	}
	public void keyReleased(KeyEvent tecla) {
		
		if(tecla.getKeyCode() == 68 || tecla.getKeyCode() == 65){
			
			direction = quieto;
			speedNow = 0;
			
		}else if(tecla.getKeyCode() == 32){
			
			salto = true;
			
		}else if(tecla.getKeyCode() == 75){
			
			attack = false;
		}
	}
	public void keyTyped(KeyEvent tecla){
	}

	public void paint(Graphics g) {
		
		if(muerto == false){
		
			g.drawImage(spriteAhora, x, y, ancho, alto, this);
			i++;
	
		}else{
			
			try{

				Musica.clip.close();
				
			}catch(Exception excpt){
				
			}
			ventana.win.gameOver();
		}
		
		if(boss.muerto == true){
			
			try{
				
				Musica.clip.close();
				
			}catch(Exception excpt){
				
			}

			ventana.win.victoria();
		}
	
		Toolkit.getDefaultToolkit().sync();
	}

	public void move() {
		
		if(direction == derecha){
			
			if(x < 150*ventana.escala){
				
				x= x + speedNow;
				
			}else{	
			}
		}else if(direction == izquierda){
			
			if(x > 0){
				
				x= x - speedNow;
				
			}else{
			}
		}else if(direction == quieto){
			
			x = x + 0;
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
			i = 0;
			
		}else if(direction == quieto && i > 5){
			
			if(attack == true){
				
				
			}else{
				
				spriteAhora = spriteQuieto;	
			}
			i = 0;
			
		}
		
		if(salto == true){		
				
			this.salto();
			
		}
		if(attack == true){
			
			//speedNow = 0;
			
			this.ataque();
			
			if(iii > 1){

				iii = 0;
				
				if(direction != quieto){
					
					speedNow = velocidad;
				}
				iii++;
			}
		}
		rec = new Rectangle(x, y, ancho, alto);
		
		for(ii=1; ii<dibujador.sprites.size(); ii++){
			
			if (rec.intersects(dibujador.sprites.get(ii).getRec()) == true){
				
				dibujador.sprites.get(ii).colision();
			}
		}
	}
	
	public void salto(){
		
		if(saltando == false){
			
			saltando = true;
			Musica.salto();
		}
		
		y = y - impulso;
		//spriteAhora = spriteSalto;
		if(y < (ventana.alto - alto)){
				
			impulso = impulso + gravedad;

		}else{
			y = ventana.alto - alto;
			salto = false;
			saltando = false;
			impulso = impulsoOriginal;
			//Musica.salto.stop();
		}	
	}
	
	public void ataque() {
		
		i = 0;
		
		if(attackDirection == izquierda){
			
				spriteAhora = spriteAttackL;
		
		}else if(attackDirection == derecha){
			
				spriteAhora = spriteAttackR;
		}
		return;
	}

	public void golpeado() {
		
		Musica.ataque();
		
		x = x -50*ventana.escala;
		
		//vida--;
		dibujador.corazones.remove(dibujador.corazones.size()-1);
		
		if(direction == derecha){
			
			spriteAhora = spriteRedR;
			
		}else if(direction == izquierda){
			
			spriteAhora = spriteRedL;
			
		}else if(direction == quieto){
			
			spriteAhora = spriteRed;
		}
		
		if(dibujador.corazones.size() == 0){
			
			this.muerte();
			
		}else{
			
			return;
		}
	}

	public void muerte() {
		
		muerto = true;
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
	
	public int getSpeed(){
		
		return speedNow;
	}
	public int getALife(){
		
		return vida;
	}
}

