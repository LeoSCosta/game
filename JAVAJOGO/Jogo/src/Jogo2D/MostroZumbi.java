package Jogo2D;


import javax.swing.*;
import java.util.Objects;


public class MostroZumbi extends Monstro  {

	private final int rx;
	private final int ry;

	public MostroZumbi(int x, int y , int rx, int ry) {


		super.largura = 25;
		super.altura = 34;

		super.posx = (x);
		super.posy = (y);
		super.direcaoX = 0;
		velocidade = 3;
		velo = velocidade;

		imagemCorrendoDireita =new ImageIcon (Objects.requireNonNull(getClass().getResource("Zumbis Miolos Verdes Correndo Direita.gif")));
		imagemCorrendoEsquerda =new ImageIcon (Objects.requireNonNull(getClass().getResource("Zumbis Miolos Verdes Correndo Esquerda.gif")));
		imagemParadoDireita =new ImageIcon (Objects.requireNonNull(getClass().getResource("Zumbis Miolos Verdes Parado Direita.gif")));
		imagemParadoEsqueda =new ImageIcon (Objects.requireNonNull(getClass().getResource("Zumbis Miolos Verdes Parado Esquerda.gif")));

		super.setIcon(imagemParadoDireita);
		super.setBounds(posx, posy, largura, altura);
		super.getHitbox().mover(x, y, largura, altura);
		
		this.rx = rx;
		this.ry = ry;
	}

	@Override
	public void renascer() {
		renascer++;
		if (renascer == 50 ) {
			posx = rx;
			posy = ry;
			setBounds(posx, posy, largura, altura);
			super.getHitbox().mover(posx, posy, largura, altura);
			vida = 2;
			renascer = 0;
		}
		else {
			posx = 484;
			posy = -10;
			setBounds(posx, posy, 0, 0);
			super.getHitbox().mover(posx, posy, largura, altura);

		}
	}

}