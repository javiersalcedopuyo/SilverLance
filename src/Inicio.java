import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Inicio extends JPanel{

	ImageIcon icon;
	Image fondo;
	
	Timer tempo;
	
	private int aux = 0;
	
	public Inicio(){
		
		this.setFocusable(true);
		
		try{

			Musica.menu();
			
		}catch (Exception e){
			
		}
		
		tempo = new Timer();
		tempo.scheduleAtFixedRate(new repeat(), 0, 40);
		
		icon = new ImageIcon("./title-screen.png");
		fondo = icon.getImage();
		
		this.addKeyListener(new Tadapter());
		
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		g.drawImage(fondo, 0, 0, ventana.ancho, ventana.alto, this);
		
		if(aux < 15){
			
			g.setColor(new Color(255,255,255));
		
			g.drawString("Press any key to continue", (int)(ventana.ancho/2)-30*ventana.escala, ventana.alto - 20*ventana.escala);
			aux++;
			
		}else if(aux < 30){
		
			aux++;
		
		}else{
			
			aux = 0;
		}
		
		
	}
	
	private class repeat  extends TimerTask{

		public void run() {
			
			requestFocus();
			Inicio.this.repaint();
		}	
	}
	
	private class Tadapter extends KeyAdapter{
		
		public void keyReleased(KeyEvent e){

			ventana.win.menu_op();
		}
	}
}
