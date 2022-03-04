package Jogo2D;


import javax.swing.*;
import java.util.Objects;


public class MonstroOrc extends Monstro  {

	//Metodo construtor do monstro
	public MonstroOrc(int x, int y) {

		super.largura = 25;
		super.altura = 34;

		posx = (x);
		posy = (y);
		direcaoX = 0;
		velocidade = 1;
		velo = velocidade;

		super.imagemParadoDireita = new ImageIcon (Objects.requireNonNull(getClass().getResource("OrcParadoDireita.gif")));
		super.imagemParadoEsqueda = new ImageIcon (Objects.requireNonNull(getClass().getResource("OrcParadoEsquerda.gif")));
		super.imagemCorrendoDireita = new ImageIcon (Objects.requireNonNull(getClass().getResource("OrcCorrendoDireita.gif")));
		super.imagemCorrendoEsquerda = new ImageIcon (Objects.requireNonNull(getClass().getResource("OrcCorrendoEsquerda.gif")));

		super.setIcon(super.imagemParadoDireita);
		super.setBounds(posx, posy, largura, altura);
		super.getHitbox().mover(x, y, largura, altura);

	}


}


