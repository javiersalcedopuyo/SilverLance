import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Opciones extends JPanel{
	
	private final Color NEGRO = new Color(0,0,0);
	private final Color BLANCO = new Color(255,255,255);
	
	private final int SirChapman = 1;
	private final int SirGalahad = 2;
	private final int SirLancebot = 3;
	private final int SirCheasy = 4;
	
	Timer tempo;
	private String[] personajes = {"KNIGHT", "ARCHER", "BARBARIAN", "ELITE KNIGHT"};
	String personaje;
	
	private int position = 0;
	private int aux;
	private int i;
	public static int ii = 1;
	private int escala = ventana.escala;
	
	public Opciones(){
		
		this.setFocusable(true);
		
		this.addKeyListener(new Tadapter());
		
		tempo = new Timer();
		tempo.scheduleAtFixedRate(new repite(), 0, 40);
	}
	
	public void paint(Graphics g){
		
		aux = 140;
		
		super.paint(g);
		
		g.setColor(NEGRO);
		g.drawString("HIT ENTER TO START OR EXIT", 15*ventana.escala, 10*ventana.escala);
		g.drawString("USE UP & DOWN ARROWS TO NAVIGATE", 15*ventana.escala, 20*ventana.escala);
		g.drawString("USE RIGHT & LEFT ARROWS TO CHANGE MENUS", 15*ventana.escala, 30*ventana.escala);
		
		for(i=0; i<4; i++){
			
			if(position == i){
				
				g.setColor(BLANCO);
				g.fillRect(25*ventana.escala, ventana.alto - aux*ventana.escala, ventana.ancho - 35*ventana.escala, 35);
				
				if(i == 0){
					
					g.setColor(NEGRO);
					g.drawString("START", 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
					
				}else if(i == 1){
					
					g.setColor(NEGRO);
					g.drawString(personajes[ii - 1], 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
					
				}else if(i == 2){
					
					g.setColor(NEGRO);
					g.drawString("ESCALE: " + escala, 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
					
				}else if(i == 3){
					
					g.setColor(NEGRO);
					g.drawString("EXIT", 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
				}

			}else{
				g.setColor(NEGRO);
				g.fillRect(25*ventana.escala, ventana.alto - aux*ventana.escala, ventana.ancho - 35*ventana.escala, 35);
				
				if(i == 0){
					
					g.setColor(BLANCO);
					g.drawString("START", 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
					
				}else if(i == 1){
					
					g.setColor(BLANCO);
					g.drawString(personajes[ii - 1], 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
					
				}else if(i == 2){
					
					g.setColor(BLANCO);
					g.drawString("ESCALE: " + escala, 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
					
				}else if(i == 3){
					
					g.setColor(BLANCO);
					g.drawString("EXIT", 25*ventana.escala + (int)((ventana.ancho - 35*ventana.escala)/2), ventana.alto - aux*ventana.escala + 20);
				}
			}
			
			
			aux = aux - 35;

			
			
		}
	}
	
	private class Tadapter extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			
			Musica.bip();
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				
				position++;
				
				if(position > 3){
					
					position = 0;
				}
				
			}else if(e.getKeyCode() == KeyEvent.VK_UP){
				
				position--;
				
				if(position < 0){
					
					position = 3;
				}
			
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				
				if(position == 1){
					
					ii++;
					if(ii > SirCheasy){
						
						ii = SirChapman;
					}
					
				}else if(position == 2){
					
					escala++;
					if(escala > 4){
						
						escala = 1;
					}
					ventana.escala = escala;
					ventana.alto = ventana.ALTO * escala;
					ventana.ancho = ventana.ANCHO * escala;
					
					ventana.win.escalar();
				}
				
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
				
				if(position == 1){
					
					ii--;
					if(ii < SirChapman){
						
						ii = SirCheasy;
					}
					
				}else if(position == 2){
					
					escala--;
					if(escala < 1){
						
						escala = 4;
					}
					ventana.escala = escala;
					ventana.alto = ventana.ALTO * escala;
					ventana.ancho = ventana.ANCHO * escala;
					
					ventana.win.escalar();
				}
					
			}else if(e.getKeyCode() == KeyEvent.VK_ENTER){
				
				if(position == 0){
					
					try{
						Musica.clip.close();
						ventana.win.new_game();
					}catch(Exception excpt){
						
					}
				}else if(position == 3){
					
					System.exit(0); 
				}
			}
		}
		
	}

	private class repite extends TimerTask{

		public void run() {
			
			requestFocus();
			Opciones.this.repaint();
		}
	}
	
}
