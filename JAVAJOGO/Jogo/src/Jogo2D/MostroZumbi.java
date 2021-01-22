package Jogo2D;


import javax.swing.*;



public class MostroZumbi extends JLabel  {


	ImageIcon imagemCorrendoDireita =new ImageIcon (getClass().getResource("Zumbis Miolos Verdes Correndo Direita.gif"));
	ImageIcon imagemCorrendoEsquerda =new ImageIcon (getClass().getResource("Zumbis Miolos Verdes Correndo Esquerda.gif"));
	ImageIcon imagemParadoDireita =new ImageIcon (getClass().getResource("Zumbis Miolos Verdes Parado Direita.gif"));
	ImageIcon imagemParadoEsqueda =new ImageIcon (getClass().getResource("Zumbis Miolos Verdes Parado Esquerda.gif"));


	private int largura, altura, vida = 0, posx, posy, direcaoX, velocidade, renascer, ponto = 0 , rx , ry;
	private boolean vivo = false, dano, danoArma;
	private Hit hitbox = new Hit();

	public MostroZumbi(int x, int y , int rx, int ry) {

		
		largura = 25;
		altura = 34;

		posx = (x);
		posy = (y);
		direcaoX = 0;
		velocidade = 2;

		setIcon(imagemParadoDireita);
		setBounds(posx, posy, largura, altura);
		this.hitbox.mover(x, y, largura, altura);
		
		this.rx = rx;
		this.ry = ry;
	}



	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public Hit getHitbox() {
		return hitbox;
	}
	public void setHitbox(Hit hitbox) {
		this.hitbox = hitbox;
	}
	public int getPonto() {
		return ponto;
	}
	public void setPonto(int ponto) {
		this.ponto = ponto;
	}
	public boolean isDano() {
		return dano;
	}
	public void setDano(boolean dano) {
		this.dano = dano;
	}
	public boolean isDanoArma() {
		return danoArma;
	}
	public void setDanoArma(boolean danoArma) {
		this.danoArma = danoArma;
	}



	//metodo que define a vida e a morte do monstro
	public void vida (boolean d) {
		if (d) {
			this.vida = this.vida - 1;
		}
	}






	// metodo que permite o monstro perseguir o heroi
	public void perseguir (int x,int y) {

		int somaX = 0;
		int somaY = 0;

		if (x <posx) {
			somaX = - velocidade;
			direcaoX = -1;
		}
		if (x >posx) {
			somaX = + velocidade;
			direcaoX = 1;
		}
		if (y <posy) {
			somaY = - velocidade;
		}

		if (y >posy) {
			somaY= + velocidade;
		}

		posx += somaX;
		posy += somaY;

		setBounds(posx, posy, largura, altura);

	}

	//Metodo que define a direcao da imagem do monstro
	public void setImage() {

		if (direcaoX == 1) {

			setIcon(imagemParadoDireita);
		}
		else if(direcaoX == 0 ) {
			setIcon(imagemParadoDireita);
		}
		else {
			setIcon(imagemCorrendoEsquerda);
		} 
	}

	public void recuar(boolean d, boolean h) {
		if(d || h) {
			this.velocidade = -5;
		}
		else this.velocidade = 3;


	}

	public void renascer() {
		renascer++;
		if (renascer == 50 ) {
			posx = rx;
			posy = ry;
			setBounds(posx, posy, largura, altura);
			hitbox.mover(posx, posy, largura, altura);
			vida = 1;
			renascer = 0;
		}
		else {
			posx = 484;
			posy = -10;
			setBounds(posx, posy, 0, 0);
			hitbox.mover(posx, posy, largura, altura);

		}
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

	public void mover(int x, int y) {
		manterMapa();
		setBounds(posx, posy, largura, altura);
		hitbox.mover(posx, posy, largura , altura);
		perseguir(x,y);
		setImage();

	}


	//Metodo que atualiza a situa��o do monstro
	public void atualiza(int x, int y, boolean d, boolean h) {
		
		
		if(vida > 0) {
			mover(x,y);
			vida(d);
			vivo = true;
			recuar(d,h);
		}
		else {
			renascer();
			if (vivo) {
				vivo = false;
				ponto++;
				
			}
		}

	}

}