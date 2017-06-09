import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class contenedor extends item {
	
	private final int JAR = 1;
	private final int BARREL = 2;
	private int alto;
	private int ancho;
	private int ruleta, type;
	private ImageIcon icon;
	private Image container, broken, dibujo;
	private boolean roto = false;
	
	public contenedor(){
		
		x = 300 * ventana.escala;
		
		ruleta = (int)(Math.random()*10);
		if(ruleta >= 0 && ruleta < 5){
			
			type = BARREL;
		
		}else if(ruleta >= 5 && ruleta <= 10){
			
			type = JAR;
		}
		
		if(type == BARREL){
			
			icon = new ImageIcon("sprites/items/barrel.png");
			container = icon.getImage();
			
			icon = new ImageIcon("sprites/items/broken-barrel.png");
			broken = icon.getImage();
			
			y = 156 * ventana.escala;
			alto = 26 *ventana.escala;
			ancho = 22 * ventana.escala;
			
		}else if(type == JAR){
			
			icon = new ImageIcon("sprites/items/jar.png");
			container = icon.getImage();
			
			icon = new ImageIcon("sprites/items/broken-jar.png");
			broken = icon.getImage();
			
			y = 156 * ventana.escala;
			alto = 25 * ventana.escala;
			ancho = 14 * ventana.escala;
			
		}
		rec = new Rectangle(x, y, ancho, alto);
	}
	public void move(){
		
		if(dibujador.sprites.get(0).getX() >= 150 * ventana.escala){
			
			x = x - (int)(dibujador.sprites.get(0).getSpeed()/2);
			
		}
		
		if(x < -ancho){
			
			dibujador.sprites.remove(this);
		}		
		
		if(roto == false){
			
			dibujo = container;
			rec = new Rectangle(x, y, ancho, alto);
			
		}else{
			
			dibujo = broken;
			rec = new Rectangle(-100,-100, 1, 1);
		}
	}
	
	public void paint(Graphics g){
		
		g.drawImage(dibujo, x, y, ancho, alto, this);
	}
	
		
	public void colision(){
		
		
	}
	public void golpeado(){
		
		if(roto == false){
			
			try{
				
				Musica.roto();
			
			}catch(Exception ex){
				
			}
			
			ruleta = (int)(Math.random()*(0-11)+11);
		
			if(ruleta >= 0 && ruleta <4){
				
				dibujador.sprites.add(new gema( (int)( x+(ancho-13)/2 )  )   );
				
			}else if(ruleta >= 4 && ruleta < 6){
				
				dibujador.sprites.add(new food((int)( x+(ancho-13)/2 )  )  );
			}
		}
		
		roto = true;
		
		return;
		
	}
}
