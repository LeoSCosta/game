package Jogo2D;


import javax.swing.*;



public class Monstro extends JLabel  {

	//Atributos que definem a imagem do monstro
	ImageIcon imagemCorrendoDireita;
	ImageIcon imagemCorrendoEsquerda;
	ImageIcon imagemParadoDireita;
	ImageIcon imagemParadoEsqueda;



	 int largura;
	 int altura;
	 int vida = 0;
	 int posx;
	 int posy;
	 int direcaoX;
	 int velocidade;
	 int velo;
	 int renascer;
	 int ponto = 0;
	 boolean vivo = false, dano, danoArma;

	private final Hit hitbox = new Hit();



	//Metodo construtor do monstro
	public Monstro() {

	}
	public Hit getHitbox() {
		return hitbox;
	}
	public int getPonto() {
		return ponto;
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

			setIcon(imagemCorrendoDireita);
		}
		else if(direcaoX == 0 ) {
			setIcon(imagemParadoDireita);
		}
		else {
			setIcon(imagemCorrendoEsquerda);
		} 
	}

	public void recuar(boolean d, boolean h) {
		if(h || d) {

			this.velocidade = -5;

		}else{
			velocidade= velo;
		}

	}

	public void renascer() {
		renascer++;
		if (renascer == 100 ) {
			posx = 484;
			posy = -4;
			setBounds(posx, posy, largura, altura);
			hitbox.mover(posx, posy, largura, altura);
			vida = 6;
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


	//Metodo que atualiza a situação do monstro
	public void atualiza(int x, int y, boolean danoMonstro, boolean danoHeroi) {

		if(vida > 0) {
			mover(x,y);
			vida(danoMonstro);
			vivo = true;
			recuar(danoMonstro,danoHeroi);
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


