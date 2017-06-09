import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class archer extends jugador{
	
	private boolean disparado = false;
	
	Rectangle rec;
	
	public archer(){
		
		icon = new ImageIcon("sprites/characters/galahad/galahad.png");
		spriteQuieto = icon.getImage();

		icon = new ImageIcon("sprites/characters/galahad/galahad-r1.png");
		spriteR1 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-r2.png");
		spriteR2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-l1.png");
		spriteL1 = icon.getImage();

		icon = new ImageIcon("sprites/characters/galahad/galahad-l2.png");
		spriteL2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-jump-r.png");
		spriteJumpR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-jump-l.png");
		spriteJumpL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-attack-r.png");
		spriteAttackR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-attack-l.png");
		spriteAttackL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-red-r.png");
		spriteRedR = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-red-l.png");
		spriteRedL = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/galahad/galahad-red.png");
		spriteRed = icon.getImage();
		
		x = 0;
		y = ventana.alto - alto;
		i = 0;
		direction = quieto;
		velocidad = 10 * ventana.escala;
		impulsoOriginal = 18 * ventana.escala;
		vida = 3;
		impulso = impulsoOriginal;
		spriteAhora = spriteQuieto;
		attackDirection = derecha;
		
		for(i=0; i<vida; i++){
			
			dibujador.corazones.add(new corazon(i));
		}
	}

	public void keyPressed(KeyEvent tecla) {
		
		super.keyPressed(tecla);
		
		disparado = false;
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
		
		if(disparado == false){
			
			if(attackDirection == izquierda){
				
				spriteAhora = spriteAttackL;
				
				dibujador.sprites.add(new flecha(x, y, izquierda));
		
			}else if(attackDirection == derecha){
			
				spriteAhora = spriteAttackR;
			
				dibujador.sprites.add(new flecha(x, y, derecha));
		
			}
			
			disparado = true;
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