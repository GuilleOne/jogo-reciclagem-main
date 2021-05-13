package jogo;


import java.awt.Component;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class TelaPrincipal extends JPanel{
	
	
	public TelaPrincipal() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		
		
		
	}
	
	static Component teste() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Jogo jogo = new Jogo();
		return jogo;
	}

}
