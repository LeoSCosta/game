package Jogo2D;



import javax.swing.*;
import java.util.Objects;


public class Cenario extends JLabel{

	ImageIcon imagemC =new ImageIcon (Objects.requireNonNull(getClass().getResource("Cenario.png")));

	public Cenario () {
		setSize(800, 400);
		setIcon(imagemC);
		setBounds(CENTER, CENTER, 800, 400);

	}


}
