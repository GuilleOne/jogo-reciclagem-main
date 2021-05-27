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
	public static CardLayout controleTela = new CardLayout();
	public static JPanel telas = new JPanel(controleTela);
	public Menu menu = new Menu();
	public static int pontuacao;
	
	public Janela() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			
		this.setTitle("Jogo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, largura, altura);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		ImageIcon icone = new ImageIcon(getClass().getResource("/img/icone.png"));
		this.setIconImage(icone.getImage());
	
		telas.add(menu, "Menu");
		controleTela.show(telas, "Menu");
		this.add(telas);
		this.setVisible(true);
	}
}
