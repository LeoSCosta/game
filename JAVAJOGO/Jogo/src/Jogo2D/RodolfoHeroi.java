package Jogo2D;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

import javax.swing.*;



public class RodolfoHeroi extends JLabel implements KeyListener  {


	ImageIcon imagemCorrendoDireita =new ImageIcon (Objects.requireNonNull(getClass().getResource("GIf_Kin_Run_Direita.gif")));
	ImageIcon imagemCorrendoEsquerda =new ImageIcon (Objects.requireNonNull(getClass().getResource("GIf_Kin_Run_Esquerda.gif")));
	ImageIcon imagemParadoDireita =new ImageIcon (Objects.requireNonNull(getClass().getResource("GIf_Kin_Parado_Direita.gif")));
	ImageIcon imagemParadoEsqueda = new ImageIcon (Objects.requireNonNull(getClass().getResource("GIf_Kin_Parado_Esquerda.gif")));
	ImageIcon imagemATKDireita = new ImageIcon (Objects.requireNonNull(getClass().getResource("GIf_Kin_ATK_Direita.gif")));
	ImageIcon imagemATKEsqueda = new ImageIcon (Objects.requireNonNull(getClass().getResource("GIf_Kin_ATK_Esquerda.gif")));


	private final int largura;
	private int i;
	private final int altura;
	private int posx;
	private int posy;
	private int ultimaDirecao;
	private final int velocidade;
	private int somaX = 0;
	private int somaY = 0;
	private int vida;
	private boolean atacando;

	// O heroi possui uma arma, entao temos dois hitBox para ele, uma para arma e uma para ele
	private Hit hitBox,arma;

	//Metodo construtor do heroi
	public RodolfoHeroi (int x, int y, int largura, int altura) {

		hitBox = new Hit();
		arma = new Hit();
		vida = 5;

		this.largura = largura;
		this.altura = altura;
		this.posx = x;
		this.posy = y;

		this.ultimaDirecao = 1;
		this.velocidade =5;


		setIcon(imagemParadoDireita);
		setBounds(posx, posy, largura, altura);
		this.hitBox.mover(x, y, largura / 2, altura);
		this.arma.mover((x + largura)/2, y, largura /2 , altura);

	}


	public Hit getHitBox() {
		return hitBox;
	}
	public int getPosx() {
		return posx;
	}
	public int getPosy() {
		return posy;
	}
	public Hit getArma() {
		return arma;
	}
	public boolean isAtacando() {
		return atacando;
	}
	public int getVida() {
		return vida;
	}

	


	//Conforme o heroi muda sua dire��o, precisamos mudar a localiza�ao de suas hitbox entre elas.
	public void hitBoxArma() {
		if (ultimaDirecao == 1) {
			this.hitBox.mover(posx, posy, largura / 2, altura);
			this.arma.mover(posx + largura/2, posy, largura /2 , altura);
		}
		else {
			this.arma.mover(posx, posy, (largura) / 2, altura);
			this.hitBox.mover(posx + largura/2, posy, largura /2 , altura);
		}
	}

	// Identifica o ataque feito pelo heroi
	public boolean ataque(boolean a) {
		if (a) 
			return true;

		else 
			return false;
	}

	//Define a vida e a morte do heroi 
	public void vida(boolean d) {
		if (d) {
			this.vida = this.vida-1;
		}	


	}

	// metodos que indentificam as teclas pressionadas
	public void keyPressed(KeyEvent a){

		if (a.getKeyCode () == KeyEvent.VK_SPACE) {
			if (i < 2) {
				i++;
				atacando= true;
			}
			else atacando = false;

			if (ultimaDirecao == 1) {
				setIcon(imagemATKDireita);
			}
			if (ultimaDirecao == 0) {
				setIcon(imagemATKEsqueda);
			}

		}

		if (a.getKeyCode () == KeyEvent.VK_UP) {
			somaY = - velocidade;
		}	
		if (a.getKeyCode () == KeyEvent.VK_DOWN) {
			somaY = + velocidade;
		}
		if (a.getKeyCode () == KeyEvent.VK_RIGHT) {
			setIcon(imagemCorrendoDireita);
			ultimaDirecao = 1;
			somaX = velocidade;
		}
		if (a.getKeyCode () == KeyEvent.VK_LEFT) {
			setIcon(imagemCorrendoEsquerda);
			ultimaDirecao = 0;
			somaX = - velocidade;
		}

		posx += somaX;
		posy += somaY;
		setBounds(posx, posy, largura, altura);

	}



	@Override
	public void keyReleased(KeyEvent a) {

		if (a.getKeyCode () == KeyEvent.VK_SPACE) {
			atacando= false;
			i=0;
			if (ultimaDirecao == 1) {
				setIcon(imagemParadoDireita);
			}
			if (ultimaDirecao == 0) {
				setIcon(imagemParadoEsqueda);
			}
		}	

		if (a.getKeyCode () == KeyEvent.VK_UP) {

			somaY = 0;
		}

		if (a.getKeyCode () == KeyEvent.VK_DOWN) {

			somaY = 0;

		}
		if (a.getKeyCode () == KeyEvent.VK_RIGHT) {
			setIcon(imagemParadoDireita);
			somaX = 0;
		}

		if (a.getKeyCode () == KeyEvent.VK_LEFT) {


			setIcon(imagemParadoEsqueda);
			somaX = 0;

		}
	}



	@Override
	public void keyTyped(KeyEvent a) {}

	public void recuar (int x,int y) {
		int somaX = 0;
		int somaY = 0;

		if (x <posx) {
			somaX = + 10;

		}
		if (x >posx) {
			somaX = - 10;

		}
		if (y <posy) {
			somaY = + 10;
		}

		if (y >posy) {
			somaY= - 10;
		}

		posx += somaX;
		posy += somaY;

	}

	public void manterMapa() {
		if (posx > 800 - largura) {
			posx = 800 - largura;
		}
		if (posx < 0) {
			posx = 0;
		}
		if(posy < 0 ) {
			posy = 0;
		}
		if(posy>350) {
			posy = 350;
		}
	}

	//metodo que atualiza a situa��o do heroi no jogo
	public void atualiza(boolean d, boolean o, boolean z, boolean z2) {

		manterMapa();
		setBounds(posx, posy, largura, altura);
		hitBoxArma();
		vida(d);
		vida(o);
		vida(z);
		vida(z2);
	}
} 	
















