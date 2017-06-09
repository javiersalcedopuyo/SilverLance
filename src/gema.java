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
public class gema extends item{
	
	private final int ancho = 13 * ventana.escala;
	private final int alto = 10 * ventana.escala;
	private final int emerald = 10;
	private final int saphire = 50;
	private final int ruby = 250;
	private final int PINKPANTHER = 1250;
	private int valor;
	Clip clip;
	
	public gema(int xAparecer){
		
		try{
			AudioInputStream AIS = AudioSystem.getAudioInputStream(new File("./music/coin.wav"));
			AudioFormat format = AIS.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip)AudioSystem.getLine(info);
			clip.open(AIS);
		
		}catch(Exception ex){
			
		}

		x = xAparecer;
		y = 164 * ventana.escala;
		
		
		rec = new Rectangle(x, y, ancho, alto);
		
		aux = (int)(Math.random()*(0-101)+101);
		
		if(aux >= 0 && aux<= 50){
			
			valor = emerald;
			icon = new ImageIcon("sprites/items/emerald.png");
			dibujo = icon.getImage();
			
		}else if(aux <= 85){
			
			valor = saphire;
			icon = new ImageIcon("sprites/items/saphire.png");
			dibujo = icon.getImage();
			
		}else if(aux <= 95){
			
			valor = ruby;
			icon = new ImageIcon("sprites/items/ruby.png");
			dibujo = icon.getImage();
		
		}else if(aux <= 100){
			
			valor = PINKPANTHER;
			icon = new ImageIcon("sprites/items/pinkpanther.png");
			dibujo = icon.getImage();
		}
		
	}
	public void move(){
		
		super.move();
		
		
		rec = new Rectangle(x, y, ancho, alto);
	}
	
	public void paint(Graphics g){
		
		g.drawImage(dibujo, x, y, ancho, alto, this);
	}
	
	public void colision(){
		
		Musica.gema();
		
		dibujador.score = dibujador.score + valor;
		
		dibujador.sprites.remove(this);
	}
}
