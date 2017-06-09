import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Victoria extends JPanel{

	ImageIcon icon;
	Image foto;
	
	Timer tempo;

	
	public Victoria(){
		
		this.setFocusable(true);
		
		try{
			
			Musica.victoria();
			//Musica.victoria.loop();
			
		}catch(Exception excpt){
			
		}
		
		tempo = new Timer();
		tempo.scheduleAtFixedRate(new repite(), 0, 40);
		
		icon = new ImageIcon("./victory.png");
		foto = icon.getImage();

	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		g.drawImage(foto, 0, 0, ventana.ancho, ventana.alto,this);

	}
	
	private class repite extends TimerTask{

		public void run() {
			
			requestFocus();
			Victoria.this.repaint();
			
		}
	}

	
}
