package Jogo2D;


import javax.swing.*;
import java.util.Objects;


public class MostroDemonio extends Monstro {

	public MostroDemonio(int x, int y ) {

		super.largura = 25;
		super.altura = 34;

   		super.posx = (x);
		super.posy = (y);
		super.direcaoX = 0;
		velocidade = 2;
		velo = 2;

		imagemCorrendoDireita =new ImageIcon (Objects.requireNonNull(getClass().getResource("Demonio Bocudo Correndo Direita.gif")));
		imagemCorrendoEsquerda =new ImageIcon (Objects.requireNonNull(getClass().getResource("Demonio Bocudo Correndo Esquerda.gif")));
		imagemParadoDireita =new ImageIcon (Objects.requireNonNull(getClass().getResource("Demonio Bocudo ParadoDireita.gif")));
		imagemParadoEsqueda =new ImageIcon (Objects.requireNonNull(getClass().getResource("Demonio Bocudo ParadoEsqueda.gif")));

		setIcon(imagemParadoDireita);
		setBounds(posx, posy, largura, altura);
		super.getHitbox().mover(x, y, largura, altura);

	}
	@Override
	public void renascer() {
		renascer++;
		if (renascer == 100 ) {
			posx = 198;
			posy = -4;
			setBounds(posx, posy, largura, altura);
			getHitbox().mover(posx, posy, largura, altura);
			vida = 3;
			renascer = 0;
		}
		else {
			posx = 198;
			posy = -10;
			setBounds(posx, posy, 0, 0);
			getHitbox().mover(posx, posy, largura, altura);

		}
	}
}