
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Muerte extends JPanel{
	
	ImageIcon icon;
	Image foto;
	
	Timer tempo;
	
	public Muerte(){
		
		this.setFocusable(true);
		
		try{
			
			Musica.muerte();
			//Musica.muerte.loop();
			
		}catch(Exception excpt){
			
		}
		
		tempo = new Timer();
		tempo.scheduleAtFixedRate(new repite(), 0, 40);
		
		icon = new ImageIcon("./gameOver.png");
		foto = icon.getImage();

	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		g.drawImage(foto, 0, 0, ventana.ancho, ventana.alto,this);

	}
	
	private class repite extends TimerTask{

		public void run() {
			
			requestFocus();
			Muerte.this.repaint();
			
		}
	}

}
