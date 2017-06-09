import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JPanel;

import java.util.Timer;


@SuppressWarnings("serial")
public class dibujador extends JPanel{

	private final Color plata = new Color(192,192,192);
	private final int SirChapman = 1;
	private final int SirGalahad = 2;
	private final int SirLancebot = 3;
	private final int SirCheasy = 4;
	private int i, ii, contadorGemas, contadorEnemigos, contadorContenedor, contGemasMax, contEnemigosMax, contContMax, character;
	public static int numeroEnemigos;
	public static int score = 0;
	private String punt;	
	
	public static Timer timer = new Timer();
	
	public static ArrayList<sprite> personajes = new ArrayList <sprite>();
	public static ArrayList<sprite> sprites = new ArrayList <sprite>();
	public static ArrayList<fondo> fondos = new ArrayList <fondo>();
	public static ArrayList<sprite> corazones = new ArrayList <sprite>();	
	
 	
	public dibujador() throws Exception{

		try{
		
			Musica.partida();
			
		}catch(Exception e){
			
		}
		
		character = Opciones.ii;
		ii = -256 * ventana.escala;
		contadorGemas = 0;
		contadorEnemigos = 0;
		contadorContenedor = 0;
		contGemasMax = ((int)(Math.random()*(200-301)+301));
		contContMax = ((int)(Math.random()*(75-151)+151));
		contEnemigosMax = ((int)(Math.random()*(50-201)+201));
		numeroEnemigos = 0;

		setFocusable(true);
		
		this.addKeyListener(new Tadapter());
		
		if(character == SirChapman){
			
			sprites.add(new knight());
	
		}else if(character == SirGalahad){
			
			sprites.add(new archer());
			
		}else if(character == SirLancebot){
			
			sprites.add(new barbarian());
			
		}else if(character == SirCheasy){
			
			sprites.add(new elite());
		}
		
		for(i=0; i<3; i++){
			
			fondos.add(new background(ii));
			
			ii = ii + (256*ventana.escala);
		}
		
		this.timer.scheduleAtFixedRate(new repite(), 100, 40);
	}
	public void paint(Graphics g){
		
		super.paint(g);
		
		punt = "Score: " + Integer.toString(score);
		
		for(i=0; i<3; i++){
			
			fondos.get(i).move();
			fondos.get(i).paint(g);
		}
		
		for(i=0; i<corazones.size(); i++){
			
			corazones.get(i).paint(g);
		}
		
		for(i=0; i<sprites.size(); i++){
			
			sprites.get(i).move();
		
		}
		
		for(i=0; i<sprites.size(); i++){
					
				sprites.get(i).paint(g);
		}
		sprites.get(0).paint(g);
		
		
		g.setColor(plata);
		g.drawString(punt, 10, 10);
	}
	
	public class repite extends TimerTask{
		
		public void run(){
			
			requestFocus();
			
			contadorGemas++;
			contadorEnemigos++;
			contadorContenedor++;

			if(contadorGemas >= contGemasMax){
				
				sprites.add(new gema(275*ventana.escala));
				contadorGemas = 0;
				contGemasMax = ((int)(Math.random()*(200-301)+301));
			}
			if(contadorContenedor >= contContMax){
				
				sprites.add(new contenedor());
				contadorContenedor = 0;
				contContMax = ((int)(Math.random()*(100-201)+201));
			}
			if(contadorEnemigos >= contEnemigosMax){
				
				if(numeroEnemigos <= 2 && score < 5000){
					
					numeroEnemigos++;
					sprites.add(new mago());
					
				}else if(score >= 5000 && numeroEnemigos == 0){
					
					sprites.add(new boss());
				}
				
				contadorEnemigos = 0;
				contEnemigosMax = ((int)(Math.random()*(100-201)+201));
			}			
			
			
			dibujador.this.repaint();
		}
	}
	private class Tadapter implements KeyListener{
		
		public void keyPressed(KeyEvent tecla){
		
			sprites.get(0).keyPressed(tecla);
			
		}
		public void keyReleased(KeyEvent tecla){
			
			sprites.get(0).keyReleased(tecla);
			
		}
		public void keyTyped(KeyEvent tecla){
			
			sprites.get(0).keyTyped(tecla);
			
		}
	}
}

