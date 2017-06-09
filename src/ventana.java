import java.net.MalformedURLException;

import javax.swing.JFrame;


public class ventana extends JFrame {
	
	public static final int ALTO = 192;
	public static final int ANCHO = 256;
	
	public static int escala = 3;
	public static int alto = 192;
	public static int ancho = 256;
	
	static ventana win;
	
	public ventana() throws Exception{
		
		new Musica();
		
		alto = alto*escala;
		ancho = ancho*escala;
		
		this.add(new Inicio());
		this.setTitle("SilverLance");
		this.setSize(ancho, alto + 30);
		this.setResizable(true);
		//this.setLocation(500, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setUndecorated(true);
		this.setVisible(true);
	}
	
	public void menu_op(){
		
		this.setContentPane(new Opciones());
		this.setVisible(true)
;	}
	
	public void new_game() throws Exception{
		
		this.setContentPane(new dibujador());
		this.setVisible(true);
	}
	
	public void inicio(){
		
		this.setContentPane(new Inicio());
		this.setVisible(true);
		
	}
	
	public void gameOver(){
		
		this.setContentPane(new Muerte());
		this.setVisible(true);
	}
	
	public void victoria(){
		
		this.setContentPane(new Victoria());
		this.setVisible(true);
	}
	
	public void escalar(){
		
		this.setSize(ancho, alto + 30);
		
	}

	public static void main(String[] args) throws Exception{
		
		win = new ventana();

	}
}
