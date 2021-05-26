package jogo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel {

	public Menu() throws IOException {

		BufferedImage imagem = ImageIO.read(new File("img\\menu fundo.png"));
		JLabel fundo = new JLabel(new ImageIcon(imagem));

		
		//Tamanho fundo

		fundo.setBounds(0, 0, 1280, 720);

		ImageIcon bttJogar = new ImageIcon("img\\botaoJogar.png");
		ImageIcon bttInstr = new ImageIcon("img\\botaoinstucoes.png");
		ImageIcon bttSair = new ImageIcon("img\\botaosair.png");
		JButton bttini = new JButton(bttJogar);
		JButton bttins = new JButton(bttInstr);
		JButton bttsair = new JButton(bttSair);
		bttini.setBounds(450, 150, 310, 74);
		bttins.setBounds(450, 300, 310, 74);
		bttsair.setBounds(450, 450, 310, 74);

		bttsair.setContentAreaFilled(false);
		bttsair.setBorder(null);

		bttins.setContentAreaFilled(false);
		bttins.setBorder(null);

		bttini.setContentAreaFilled(false);
		bttini.setBorder(null);

		this.add(bttini);
		this.add(bttins);
		this.add(bttsair);
		this.setLayout(null);
		this.setBackground(Color.gray);
		this.add(fundo);

		bttini.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Jogo jogo = new Jogo();
					Janela.telas.add(jogo, "Tela Jogo");
					Janela.controleTela.show(Janela.telas, "Tela Jogo");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}
		});
		bttins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Instrucao instrucao = new Instrucao();
					Janela.telas.add(instrucao, "Instrução");
					Janela.controleTela.show(Janela.telas, "Instrução");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		bttsair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
