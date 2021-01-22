package Jogo2D;



import javax.swing.*;




public class Cenario extends JLabel{



	ImageIcon imagemC =new ImageIcon (getClass().getResource("Cenario.png"));

	public Cenario () {


		setSize(800, 400);
		setIcon(imagemC);

		setBounds(CENTER, CENTER, 800, 400);

	}


}
