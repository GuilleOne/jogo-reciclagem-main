
package jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Instrucao extends JPanel implements ActionListener {


	public Instrucao() {
		
		// coloca o foco para a janela
        this.addComponentListener( new ComponentAdapter() {
        	@Override
            public void componentShown( ComponentEvent e ) {
                Instrucao.this.requestFocusInWindow();
            }
        });
	

		ImageIcon bttSair = new ImageIcon("img\\botaosair.png");
		JButton bttsair = new JButton(bttSair);

		bttsair.setBounds(950, 600, 310, 74);

		bttsair.setContentAreaFilled(false);

		bttsair.setBorderPainted(true);

		bttsair.setBorder(null);

		this.add(bttsair);
		this.setLayout(null);
		
		bttsair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
	            Janela.controleTela.show(Janela.telas, "Menu");

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
