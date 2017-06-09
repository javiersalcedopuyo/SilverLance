import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class boss extends enemigo {
	
	private Image entero;
	private Image damage1;
	private Image damage2;
	private Image damage3;
	private Image damage4;
	private Image stateNow;
	private int contador = 0;
	private int contador2 = 0;
	public static boolean muerto = false;
	
	public boss(){
		
		alto = alto*2;
		ancho = ancho*2;
		
		x = 300 * ventana.escala;
		y = ventana.alto - alto;
		
		icon = new ImageIcon("sprites/characters/mortimer/mortimer.png");
		entero = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/mortimer/mortimer-1.png");
		damage1 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/mortimer/mortimer-2.png");
		damage2 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/mortimer/mortimer-3.png");
		damage3 = icon.getImage();
		
		icon = new ImageIcon("sprites/characters/mortimer/mortimer-4.png");
		damage4 = icon.getImage();
		
		stateNow = entero;
		
		rec = new Rectangle(x, y, ancho, alto);
	}
	
	public void move(){
		
		if(dibujador.sprites.get(0).getX() >= 150* ventana.escala){
			
			x = x - (int)(dibujador.sprites.get(0).getSpeed()/2);
			
		}
		if(contador <= 50){
			
			x--;
			
		}else if(contador < 100){
			
			x++;
			
		}else if(contador == 100){
			
			contador = 0;
		}
		
		if(contador2 == 25){
			
			dibujador.sprites.add(new spell(x, (int)(Math.random()*( (int)(ventana.alto/2) - ventana.alto )+ventana.alto),2));
			contador2 = 0;
		}
		
		contador++;
		contador2++;

		rec = new Rectangle(x, y, ancho, alto);
	}
	
	public void golpeado(){
		
		Musica.ataque();
		
		if(stateNow == entero){
			
			stateNow = damage1;
			
		}else if(stateNow == damage1){
			
			stateNow = damage2;
			
		}else if(stateNow == damage2){
			
			stateNow = damage3;
			
		}else if(stateNow == damage3){
			
			stateNow = damage4;
			
		}else if(stateNow == damage4){
			
			muerto = true;
		}
	}
	
	public void colision(){		
			
			dibujador.sprites.get(0).golpeado();
		}
	
	public void paint(Graphics g){
		
		g.drawImage(stateNow, x, y, ancho, alto, this);
	}
	
	public Rectangle getRec(){
		
		return rec;
	}
}
