import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class barbarian extends jugador{
	
	//Rectangle rec;
	
	public barbarian(){
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot.png");
		spriteQuieto = icon.getImage();

		icon = new ImageIcon("sprites/characters/lancebot/lancebot-r1.png");
		spriteR1 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-r2.png");
		spriteR2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-l1.png");
		spriteL1 = icon.getImage();

		icon = new ImageIcon("sprites/characters/lancebot/lancebot-l2.png");
		spriteL2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-jump-r.png");
		spriteJumpR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-jump-l.png");
		spriteJumpL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-attack-r.png");
		spriteAttackR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-attack-l.png");
		spriteAttackL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-red-r.png");
		spriteRedR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-red-l.png");
		spriteRedL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/lancebot/lancebot-red.png");
		spriteRed = icon.getImage();
		
		x = 0;
		y = ventana.alto - alto;
		i = 0;
		direction = quieto;
		velocidad = 6 * ventana.escala;
		impulsoOriginal = 14 * ventana.escala;
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
	}
	public void ataque() {
		
		if(attackDirection == izquierda){
			
			spriteAhora = spriteAttackL;
			
			if(attack == true){
			
					dibujador.sprites.add(new hacha(x, y, izquierda));
			}
			
			attack = false;
	
		}else if(attackDirection == derecha){
		
			spriteAhora = spriteAttackR;
			
			if(attack == true){
		
				dibujador.sprites.add(new hacha(x, y, derecha));
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