package jogo;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu  extends JPanel{
	

	public Menu() {
		
		
		// Configs botões
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
		bttsair.setBorderPainted(true);
		bttsair.setBorder(null);

		bttins.setContentAreaFilled(false);
		bttins.setBorderPainted(true);
		bttins.setBorder(null);

		bttini.setContentAreaFilled(false);
		bttini.setBorderPainted(true);
		bttini.setBorder(null);

		

		this.add(bttini);
		this.add(bttins);
		this.add(bttsair);
		this.setLayout(null);

		bttini.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Jogo jogo = new Jogo();
					Janela.telas.add(jogo, "Tela Jogo");
					Janela.controleTela.show(Janela.telas, "Tela Jogo");
					
					
					
					
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			
			}
		});
		bttins.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
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
