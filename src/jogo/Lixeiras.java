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
	private Jogo jogo;
	private boolean fimJogo;
	
	private Janela janelajogo;
	
	private int pontAzul;
	private int pontAmarelo;
	private int pontVermelho;
	private int pontVerde;
	private int pontFinal;


	public Lixeiras() {
		this.x = 540;
		this.y = 475;
		fimJogo=false;
		
		

		mudarLixeira();

	}

	public void mudarLixeira() {
		// ImageIcon tempimg = null;
	

		Timer timer = new Timer(30000, this);
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
			pontFinal = Jogo.pontuacao;;
			fimJogo = true;
			timer.stop();
			
		} else {
			timer.stop();
		}
		

		System.out.println(Jogo.pontuacao);
		cont++;
		setTempImg(tempimg);
		setImagem(tempImg.getImage());

	}

	public void load() {

		// ImageIcon referencia = new ImageIcon("img\\lixeira1.png");
		// imagem = referencia.getImage();
		// imagem = getImagem();

		// this.setMaterial("papel");

		// altura = imagem.getHeight(null);
		// largura = imagem.getWidth(null);
	}

	// atualizar posiçao
	public void update() {
		x += dx;

		// System.out.println(x);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 144, 196);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(fimJogo) {
			janelajogo.getJanelaPrinc().add(new Pontuacao());
			jogo.getPainel().setVisible(false);
			
		}else {
			mudarLixeira();
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