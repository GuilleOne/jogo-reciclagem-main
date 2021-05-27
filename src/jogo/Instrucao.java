
package jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instrucao extends JPanel {


	public Instrucao() throws IOException {
		BufferedImage imagem = ImageIO.read(this.getClass().getResourceAsStream("/img/instrucao.png"));
		JLabel fundo = new JLabel(new ImageIcon(imagem));
		fundo.setBounds(0, 0, 1280, 720);
		
	
        this.addComponentListener( new ComponentAdapter() {
        	@Override
            public void componentShown( ComponentEvent e ) {
                Instrucao.this.requestFocusInWindow();
            }
        });
	

		ImageIcon bttSair = new ImageIcon(getClass().getResource("/img/voltar.png"));
		JButton bttsair = new JButton(bttSair);

		bttsair.setBounds(950, 600, 310, 74);
		bttsair.setContentAreaFilled(false);
		bttsair.setBorder(null);

		this.add(bttsair);
		this.setLayout(null);
		this.add(fundo);
		bttsair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

	            Janela.controleTela.show(Janela.telas, "Menu");

			}
		});
	}

	
}
