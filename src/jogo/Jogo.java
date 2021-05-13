package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jogo extends JPanel implements ActionListener {

	private Image fundo;
	private Lixeiras lixeiras;
	public static int pontuacao;
	private Timer timer;
	private List<Lixos> lixos;
	private JPanel painel;
	
	

	public Jogo() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setFocusable(true);
		setDoubleBuffered(true);

		ImageIcon img = new ImageIcon("img\\fundo2.png");
		fundo = img.getImage();
		
		

		lixeiras = new Lixeiras();
		lixeiras.load();
		
		

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		lixoAleatorio();
		Som.somFundo();

	}

	public void lixoAleatorio() {
		int coordenadas[] = new int[300];
		lixos = new ArrayList<Lixos>();

		for (int i = 0; i < coordenadas.length; i++) {

			int x = (int) (Math.floor(Math.random() * (1280 - 0 + 1)) + 0);
			int y = (int) (Math.floor(Math.random() * (-20000 - 0 + 1)) + 0);
			
			//int x = (int) (Math.random() * 1280 + 0);
			//int y = (int) (Math.random() * -20000 + 0);
			
			int tipo = (int) (Math.floor(Math.random() * (5 - 1 + 1) ) + 1);
			int img = (int) (Math.floor(Math.random() * (4 - 1 + 1) ) + 1);

			lixos.add(new Lixos(x, y,tipo,img));

		}

	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(fundo, 0, 0, null);

		// mostrar lixeira
		g2d.drawImage(lixeiras.getImagem(), lixeiras.getX(), lixeiras.getY(), this);

		// mostra lixos
		for (int o = 0; o < lixos.size(); o++) {
			Lixos in = lixos.get(o);
			//in.load();
			g2d.drawImage(in.getImagem(), in.getX(), in.getY(), this);
		}
		
		g2d.setPaint(Color.blue);
		g2d.fillRect(8, 17, 240, 30);
		
		g2d.setPaint(Color.red);
		g2d.setFont(new Font("Arial",Font.BOLD,25));
		g2d.drawString("Pontuação: "+ pontuacao, 10, 40);

		g.dispose();
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		lixeiras.update();

		for (int o = 0; o < lixos.size(); o++) {
			Lixos in = lixos.get(o);
			if (in.isVisivel()) {
				in.update();
			} else {
				lixos.remove(o);
			}
		}

		try {
			colisao();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		repaint();

	}

	public void colisao() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Rectangle colLixeira = lixeiras.getBounds();
		Rectangle colLixos;
		
		String lixoMat;


		// colisão entre o lixo e a lixaira

		for (int i = 0; i < lixos.size(); i++) {
			Lixos xLixo = lixos.get(i);
			colLixos = xLixo.getBounds();		
			if (colLixeira.intersects(colLixos)) {
				xLixo.setVisivel(false);
				lixoMat = xLixo.getMaterial();
				if( lixoMat == lixeiras.getMaterial()) {
					pontuacao += 100;
					Som.somAcerto();
				} else {
					Som.somErro();
					pontuacao -=50;
				}
			
			
					
			}
		}
		/*
		for (int j = 0; j < lixos.size(); j++) {
			Lixos xLixo = lixos.get(j);
			colLixos = xLixo.getBounds();
			for (int z = 0; z < lixos.size(); z = ) {
			Lixos yLixo = lixos.get(j);
			colLixos2 = yLixo.getBounds();
			
			if (colLixos.intersects(colLixos2)) {
				xLixo.setVisivel(false);
			}
		}
*/
		/// colisão entre os lixos para nao serem gerados no mesmo espaço
		/*
		 * for (int i = 0; i < lixos.size(); i++) { Lixos xLixo = lixos.get(i); colLixos
		 * = xLixo.getBounds();
		 * 
		 * for (int j = 0; j < lixos.size(); j = i+1) { Lixos xLixo2 = lixos.get(j);
		 * colLixos2 = xLixo2.getBounds(); if (colLixos.intersects(colLixos2)) {
		 * xLixo.setVisivel(false); } } }
		 */
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			lixeiras.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			lixeiras.keyRelease(e);
		}

	}

	

	public int getPontuacao() {
		return pontuacao;
	}

	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
	}
	
}
