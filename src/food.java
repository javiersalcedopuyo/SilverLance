import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class food extends item{
	
	private final int alto = 15* ventana.escala;
	private final int ancho = 15* ventana.escala;
	int vida;
	
	public food(int xSpawn){
		
		icon = new ImageIcon("sprites/items/filete.png");
		dibujo = icon.getImage();
		
		x = xSpawn;
		y = ventana.alto - alto;
		
		rec = new Rectangle(x, y, ancho, alto);
		
	}
	
	public void move(){
		
		super.move();
		
		rec = new Rectangle(x, y, ancho, alto);
	}
	
	public void colision(){
		
		Musica.vida();
		vida = dibujador.corazones.size();
		dibujador.corazones.add(new corazon(vida));
		dibujador.sprites.remove(this);
		
	}
	public void paint(Graphics g){
		
		g.drawImage(dibujo, x, y, ancho, alto, this);
	}
}
