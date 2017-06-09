import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class elite extends jugador{
	
	//Rectangle rec;
	
	public elite(){		
		
		icon = new ImageIcon("sprites/characters/elite/elite.png");
		spriteQuieto = icon.getImage();

		icon = new ImageIcon("sprites/characters/elite/elite-r1.png");
		spriteR1 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-r2.png");
		spriteR2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-l1.png");
		spriteL1 = icon.getImage();

		icon = new ImageIcon("sprites/characters/elite/elite-l2.png");
		spriteL2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-jump-r.png");
		spriteJumpR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-jump-l.png");
		spriteJumpL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-attack-r.png");
		spriteAttackR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-attack-l.png");
		spriteAttackL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-red-r.png");
		spriteRedR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-red-l.png");
		spriteRedL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/elite/elite-red.png");
		spriteRed = icon.getImage();
		
		x = 0;
		y = ventana.alto - alto;
		i = 0;
		direction = quieto;
		velocidad = 10 * ventana.escala;
		impulsoOriginal = 18 * ventana.escala;
		vida = 6;
		impulso = impulsoOriginal;
		spriteAhora = spriteQuieto;
		attackDirection = derecha;
		
		for(i=0; i<vida; i++){
			
			dibujador.corazones.add(new corazon(i));
		}
	}

	public void keyPressed(KeyEvent tecla) {
		
		super.keyPressed(tecla);
	}
	public void keyReleased(KeyEvent tecla) {
		
		super.keyReleased(tecla);
	}
	public void keyTyped(KeyEvent tecla){
		
		super.keyTyped(tecla);
	}
	public void paint(Graphics g) {
		
		super.paint(g);
	}
	public void move() {

		super.move();
	}
	public void salto(){
		
		super.salto();

		return;
	}
	public void ataque() {
		
		
		if(attackDirection == izquierda){
			
			spriteAhora = spriteAttackL;
			
			if(attack == true){
			
					dibujador.sprites.add(new espada(x, y, izquierda));
			}
			
			attack = false;
	
		}else if(attackDirection == derecha){
		
			spriteAhora = spriteAttackR;
			
			if(attack == true){
		
				dibujador.sprites.add(new espada(x, y, derecha));
			}
			
			attack = false;
	
		}
		return;
	}
	public void golpeado() {
	
		super.golpeado();
	}
	public void muerte() {
		
		super.muerte();
	}
	public void colision() {
	
		super.colision();
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
