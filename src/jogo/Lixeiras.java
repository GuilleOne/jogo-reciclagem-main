package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import javax.swing.Timer;

public class Lixeiras implements ActionListener {

	private int x, y;
	private int dx;
	private Image imagem;
	private ImageIcon tempImg;
	private ImageIcon tempimg;
	private String material;
	static int cont = 1;
	
	private int pontAzul;
	private int pontAmarelo;
	private int pontVermelho;
	private int pontVerde;
	private int pontFinal;
	private Janela janela;
	
	
	public Lixeiras() {
		this.x = 540;
		this.y = 475;
		
		mudarLixeira();
	}

	public void mudarLixeira() {
	
		Timer timer = new Timer(3000, this);
		timer.start();

		if (cont == 1) {
			tempimg = new ImageIcon("img\\lixeira1.png");
			this.setMaterial("papel");
		}

		else if (cont == 2) {
			tempimg = new ImageIcon("img\\lixeira2.png");
			this.setMaterial("plastico");
			pontAzul = Jogo.pontuacao;
			timer.stop();
			
		} else if (cont == 3) {
			tempimg = new ImageIcon("img\\lixeira3.png");
			this.setMaterial("vidro");
			pontVermelho = Jogo.pontuacao- pontAzul;
			timer.stop();
			
		} else if (cont == 4) {
			tempimg = new ImageIcon("img\\lixeira4.png");
			pontVerde = Jogo.pontuacao- pontAzul - pontVermelho;
			this.setMaterial("metal");
			timer.stop();
			
			
		} else if (cont == 5) {
			pontAmarelo = Jogo.pontuacao - pontAzul - pontVermelho - pontVerde;
			pontFinal = Jogo.pontuacao;
			Jogo.emJogo = false;
			timer.stop();
		} else {
			timer.stop();
		}
		
		cont++;
		setTempImg(tempimg);
		setImagem(tempImg.getImage());

	}


	
	public void update() {
		x += dx;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 144, 196);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Jogo.emJogo) {
			mudarLixeira();
		}else {
			Pontuacao pontuacao = new Pontuacao();
			janela.telas.add(pontuacao, "Pontuacao");
			janela.controleTela.show(janela.telas, "Pontuacao");
			
			
		}	
	}

	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getExtendedKeyCode();

		if (codigo == KeyEvent.VK_LEFT) {
			dx = -10;

		}

		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 10;
		}

	}

	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getExtendedKeyCode();

		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public ImageIcon getTempImg() {
		return tempImg;
	}

	public void setTempImg(ImageIcon tempImg) {
		this.tempImg = tempImg;
	}

	public int getPontAzul() {
		return pontAzul;
	}

	public int getPontAmarelo() {
		return pontAmarelo;
	}

	public int getPontVermelho() {
		return pontVermelho;
	}

	public int getPontVerde() {
		return pontVerde;
	}

	public int getPontFinal() {
		return pontFinal;
	}

	public static int getCont() {
		return cont;
	}
	

}