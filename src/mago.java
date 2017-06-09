import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class mago extends enemigo{
	
	private final int derecha = 1;
	private final int izquierda = 2;
	private int contAtaque = 0;

	public mago(){
		
		vida = 3;
		velocidad = 1;
		valor = 500;
		
		icon = new ImageIcon("sprites/enemies/mago/mago-r1.png");
		spriteR1 = icon.getImage();
		
		icon = new ImageIcon("sprites/enemies/mago/mago-r2.png");
		spriteR2 = icon.getImage();
		
		icon = new ImageIcon("sprites/enemies/mago/mago-l1.png");
		spriteL1 = icon.getImage();
		
		icon = new ImageIcon("sprites/enemies/mago/mago-l2.png");
		spriteL2 = icon.getImage();
		
		icon = new ImageIcon("sprites/enemies/mago/mago-attack-r.png");
		spriteAttackR = icon.getImage();
		
		icon = new ImageIcon("sprites/enemies/mago/mago-attack-l.png");
		spriteAttackL = icon.getImage();
		
		icon = new ImageIcon("sprites/enemies/mago/mago-red-r.png");
		spriteRedR = icon.getImage();
		
		icon = new ImageIcon("sprites/enemies/mago/mago-red-l.png");
		spriteRedL = icon.getImage();
		
		distancia = (int)(Math.random()*(10-51)+50);
		direction = (int)(Math.random()*(1-3)+3);
		
		rec = new Rectangle(x, y, ancho, alto);

	}
	
	public void move(){
		
		super.move();
		
		if(contAtaque == 15){
			
			this.ataque();
			contAtaque = 0;
			
		}else{
			
			contAtaque++;
		}
	
	}
	
	public void ataque(){

		dibujador.sprites.add(new spell(x, y, direction));
		
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
	}
	public void golpeado(){
		
		super.golpeado();
	}
	public void muerte(){
		
		super.muerte();
	}
	public Rectangle getRec(){
		
		return rec;
	}
	public void colision(){
		
		super.colision();
	}
}
