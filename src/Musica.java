import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class Musica {
	
	public static AudioInputStream audioInputStream;
	public static AudioFormat format;
	public static DataLine.Info info;
	public static Clip clip, clipAtaque, clipSalto, clipGema, clipRoto, clipBip, clipVida;

	public Musica()throws Exception{
		
		 	audioInputStream = AudioSystem.getAudioInputStream(new File("./music/jump.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clipSalto = (Clip) AudioSystem.getLine(info);
	        clipSalto.open(audioInputStream);
			
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/hit.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clipAtaque = (Clip) AudioSystem.getLine(info);
	        clipAtaque.open(audioInputStream);
	        
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/broken.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clipRoto = (Clip) AudioSystem.getLine(info);
	        clipRoto.open(audioInputStream);
	        
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/coin.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clipGema = (Clip) AudioSystem.getLine(info);
	        clipGema.open(audioInputStream);
	        
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/bip.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clipBip = (Clip) AudioSystem.getLine(info);
	        clipBip.open(audioInputStream);
	        
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/life.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clipVida = (Clip) AudioSystem.getLine(info);
	        clipVida.open(audioInputStream);		
	}
	
	public static void salto(){
			
			try{
				
				clipSalto.setFramePosition(0);
		        clipSalto.start();
		        clipSalto.stop();

			}catch(Exception ex){
		        System.out.println("Error playing music.\n");
		    }
			
	}
	public static void ataque(){
		
		try{
			clipAtaque.setFramePosition(0);
	        clipAtaque.start();
	        clipAtaque.stop();
	        
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
	public static void roto(){
		
		try{

			clipRoto.setFramePosition(0);
	        clipRoto.start();
	        clipRoto.stop();
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
	
	public static void gema(){
		
		try{

			clipGema.setFramePosition(0);
	        clipGema.start();
	        clipGema.stop();
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
	
	public static void bip(){
		
		try{

			clipBip.setFramePosition(0);
	        clipBip.start();
	        clipBip.stop();
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
	
	public static void vida(){
		
		try{

			clipVida.setFramePosition(0);
	        clipVida.start();
	        clipVida.stop();
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
	
	public static void victoria(){
		
		try{
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/victory.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clip = (Clip) AudioSystem.getLine(info);
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
	public static void muerte(){
		
		try{
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/muerte.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clip = (Clip) AudioSystem.getLine(info);
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
	}
	
	public static void menu(){
		
		try{
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/title-screen.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clip = (Clip) AudioSystem.getLine(info);
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
	
	public static void partida(){
		
		try{
	        audioInputStream = AudioSystem.getAudioInputStream(new File("./music/explorer.wav"));
	        format = audioInputStream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clip = (Clip) AudioSystem.getLine(info);
	        clip.open(audioInputStream);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    
		}catch(Exception ex){
	        System.out.println("Error playing music.\n");
	    }
		
	}
}
