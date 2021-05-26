package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Lixos {
	private Image imagem;
	private ImageIcon imglixo;
	private int x, y;
	private boolean isVisivel;
	private String material;
	private static final int LIMITE = 450;
	private static int VELOCIDADE = 3;

	public Lixos(int x, int y, int tipo, int img) {
		this.x = x;
		this.y = y;
		isVisivel = true;
		material = null;

		imgAleatoria(tipo, img);
	}

	public void imgAleatoria(int tipo, int img) {

		ImageIcon templixo = null;
		if (tipo == 1) {
			setMaterial("papel");
			if (img == 1) {
				templixo = new ImageIcon("img\\papel\\papel1.png");
			}
			if (img == 2) {
				templixo = new ImageIcon("img\\papel\\papel2.png");
			}
			if (img == 3) {
				templixo = new ImageIcon("img\\papel\\papel3.png");
			}
			if (img == 4) {
				templixo = new ImageIcon("img\\papel\\papel4.png");
			}
		}

		if (tipo == 2) {
			setMaterial("metal");
			if (img == 1) {
				templixo = new ImageIcon("img\\metal\\metal1.png");
			}
			if (img == 2) {
				templixo = new ImageIcon("img\\metal\\metal2.png");
			}
			if (img == 3) {
				templixo = new ImageIcon("img\\metal\\metal3.png");
			}
			if (img == 4) {
				templixo = new ImageIcon("img\\metal\\metal4.png");
			}
		}

		if (tipo == 3) {
			setMaterial("plastico");
			if (img == 1) {
				templixo = new ImageIcon("img\\plastico\\plastico1.png");
			}
			if (img == 2) {
				templixo = new ImageIcon("img\\plastico\\plastico2.png");
			}
			if (img == 3) {
				templixo = new ImageIcon("img\\plastico\\plastico3.png");
			}
			if (img == 4) {
				templixo = new ImageIcon("img\\plastico\\plastico4.png");
			}
		}

		if (tipo == 4) {
			setMaterial("vidro");
			if (img == 1) {
				templixo = new ImageIcon("img\\vidro\\vidro1.png");
			}
			if (img == 2) {
				templixo = new ImageIcon("img\\vidro\\vidro2.png");
			}
			if (img == 3) {
				templixo = new ImageIcon("img\\vidro\\vidro3.png");
			}
			if (img == 4) {
				templixo = new ImageIcon("img\\vidro\\vidro4.png");
			}
		}

		if (tipo == 5) {
			setMaterial("naoreciclavel");
			if (img == 1) {
				templixo = new ImageIcon("img\\naoreciclavel\\naoreciclavel1.png");
			}
			if (img == 2) {
				templixo = new ImageIcon("img\\naoreciclavel\\naoreciclavel2.png");
			}
			if (img == 3) {
				templixo = new ImageIcon("img\\naoreciclavel\\naoreciclavel3.png");
			}
			if (img == 4) {
				templixo = new ImageIcon("img\\naoreciclavel\\naoreciclavel4.png");
			}
		}
		setImglixo(templixo);
		setImagem(imglixo.getImage());
	}

	public void update() {
		this.y += VELOCIDADE;
		if (this.y > LIMITE) {
			isVisivel = false;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 65, 66);
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setImglixo(ImageIcon imglixo) {
		this.imglixo = imglixo;
	}

}
