import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class background extends JPanel implements fondo{
	
	private int x, y, aux;
	private ImageIcon icon;
	private Image imagen, imagen1, imagen2;
	public static int movimiento;
	private final int ancho = ventana.ancho;
	private final int alto = ventana.alto;
	
	public background(int xInicial){
		
		x = xInicial;
		y = 0;
		aux = 2;
		
		icon = new ImageIcon("background1.png");
		imagen1 = icon.getImage();
		
		icon = new ImageIcon("background2.png");
		imagen2 = icon.getImage();
		
		imagen = imagen1;
	}

	public void paint(Graphics g) {

		g.drawImage(imagen, x, y, ancho, alto, this);
		
	}

	public void move() {
		
		if(dibujador.sprites.get(0).getX() >= 150*ventana.escala){
			
			movimiento = (int)(dibujador.sprites.get(0).getSpeed()/2);
			
			x = x - movimiento;
			
		}
		
		if(x == -512 *ventana.escala){
			
			x = 256 *ventana.escala;
			if(aux == 1){
				
				imagen = imagen1;
				aux = 2;
			
			}else if(aux == 2){
				
				imagen = imagen2;
				aux = 1;
			}
			
		}else if(x < -512 *ventana.escala){
			
			x = (x+512*ventana.escala) + 256*ventana.escala;
			if(aux == 1){
			
				imagen = imagen1;
				aux = 2;
			
			}else if(aux == 2){
				
				imagen = imagen2;
				aux = 1;
			}
			
		}
	}

	public void borrar(){
		
	}
	public int getX() {
		
		return x;
	}

	public int getY() {
	
		return y;
	}
}
