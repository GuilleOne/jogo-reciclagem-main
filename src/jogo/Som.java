package jogo;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

public class Som {
	

	public static void somErro() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		URL file = Som.class.getResource("/sons/somerro.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip erro = AudioSystem.getClip();
		erro.open(audioStream);
		FloatControl gainControl = 
			    (FloatControl) erro.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10.0f); 
		erro.start();
	}
	
	public static void somAcerto() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		URL file = Som.class.getResource("/sons/somacerto.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip acerto = AudioSystem.getClip();
		acerto.open(audioStream);
		FloatControl gainControl = 
			    (FloatControl) acerto.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-5.0f); 
		acerto.start();
	}
	
public static void somFundo() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		

		URL file = Som.class.getResource("/sons/somdefundo2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip fundo = AudioSystem.getClip();
		fundo.open(audioStream);
		FloatControl gainControl = 
			    (FloatControl) fundo.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-20.0f); 
		fundo.start();
	}

public static void somFinal() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	
	URL file = Som.class.getResource("/sons/somFinal.wav");
	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	Clip fim = AudioSystem.getClip();
	fim.open(audioStream);
	FloatControl gainControl = 
		    (FloatControl) fim.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-20.0f); 
	fim.start();
}

}
