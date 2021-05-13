package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Pontuacao extends JPanel implements ActionListener{
	
	private Image fundo;
	private Lixeiras lixeiras;

	
	
	public Pontuacao() {
		ImageIcon img = new ImageIcon("img\\pontuaçao.png");
		fundo = img.getImage();
		
	}

	
	
	
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(fundo, 0, 0, null);

		
		g2d.setPaint(Color.black);
		g2d.setFont(new Font("Arial",Font.BOLD,70));
		g2d.drawString(""+lixeiras.getPontFinal(), 540, 200);
		
		/*
		g2d.setPaint(Color.black);//azul
		g2d.setFont(new Font("Arial",Font.BOLD,39));
		g2d.drawString(""+lixeiras.getPontAzul(), 270,448);
		
		g2d.setPaint(Color.black);//vermelho
		g2d.setFont(new Font("Arial",Font.BOLD,39));
		g2d.drawString(""+lixeiras.getPontVermelho(), 490,448);
		
		g2d.setPaint(Color.black);//verde
		g2d.setFont(new Font("Arial",Font.BOLD,39));
		g2d.drawString(""+lixeiras.getPontVerde(), 705, 448);
		
		g2d.setPaint(Color.black);//amarelo
		g2d.setFont(new Font("Arial",Font.BOLD,39));
		g2d.drawString(""+lixeiras.getPontAmarelo(), 920, 448);
*/
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
