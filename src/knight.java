import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class knight extends jugador{
	
	//Rectangle rec;
	
	public knight(){
		
		icon = new ImageIcon("sprites/characters/chapman/chapman.png");
		spriteQuieto = icon.getImage();

		icon = new ImageIcon("sprites/characters/chapman/chapman-r1.png");
		spriteR1 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-r2.png");
		spriteR2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-l1.png");
		spriteL1 = icon.getImage();

		icon = new ImageIcon("sprites/characters/chapman/chapman-l2.png");
		spriteL2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-jump-r.png");
		spriteJumpR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-jump-l.png");
		spriteJumpL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-attack-r.png");
		spriteAttackR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-attack-l.png");
		spriteAttackL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-red-r.png");
		spriteRedR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-red-l.png");
		spriteRedL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/chapman/chapman-red.png");
		spriteRed = icon.getImage();
		
		x = 0;
		y = ventana.alto - alto;
		i = 0;
		direction = quieto;
		velocidad = 8 * ventana.escala;
		impulsoOriginal = 16 * ventana.escala;
		vida = 4;
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