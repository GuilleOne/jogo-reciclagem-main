package jogo;


import java.awt.CardLayout;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Janela extends JFrame {
	public static int largura = 1280;
	public static int altura = 720;
	private static JFrame janelaPrinc;

	public Janela() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		
		JPanel telas = new JPanel(new CardLayout());
		
		this.setTitle("Jogo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, largura, altura);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		ImageIcon icone = new ImageIcon("img\\icone.png");
		this.setIconImage(icone.getImage());
		
		
		TelaPrincipal telaprincipal = new TelaPrincipal();
		Menu menu = new Menu();
		
		
		telas.add(menu);
		telas.add(TelaPrincipal.teste());
		
	
		
		this.add(telas);
		this.setVisible(true);

	}


	public JFrame getJanelaPrinc() {
		return janelaPrinc;
	}

	public static void setJanelaPrinc(JFrame janelaPrinc) {
		Janela.janelaPrinc = janelaPrinc;
	}

}
