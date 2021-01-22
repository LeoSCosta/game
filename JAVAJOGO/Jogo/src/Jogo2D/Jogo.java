package Jogo2D;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Jogo extends JFrame implements Runnable{
	public MostroDemonio Demonio;
	public MostroZumbi Zumbi, Zumbi2;
	public MonstroOrc orc1;
	public RodolfoHeroi Rodolfo;
	public double milisegundo =50;
	public Cenario Cenario1;
	private boolean danoD, danoArmaD;
	private boolean danoZ, danoArmaZ;
	private boolean danoZ2, danoArmaZ2;
	private boolean danoO, danoArmaO;
	private int pontuacao;
	private JLabel placar;
	private JLabel vida;
	private JLabel gameOver;
	private ImageIcon zero;
	private ImageIcon um;
	private ImageIcon dois;
	private ImageIcon tres;
	private ImageIcon quatro;
	private ImageIcon cinco;
	private ImageIcon igameOver;

	public Jogo()	{

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Cenario1 = new Cenario();
		
		Zumbi = new MostroZumbi( 400 , 200 , 200 , 350);
		Zumbi2 = new MostroZumbi( 400 , 200 , 490 , 350);
		Demonio = new MostroDemonio(198 , -4);
		Rodolfo = new RodolfoHeroi(400, 200, 30, 32 );
		orc1 = new MonstroOrc(400,200);
		
		placar = new JLabel();
		vida = new JLabel();
		vida.setBounds(0, 0, 59, 10);
		
		gameOver = new JLabel();
		gameOver.setBounds(0, 0, 800, 400);
		
		zero = new ImageIcon(getClass().getResource("0.jpeg"));
		um = new ImageIcon(getClass().getResource("1.jpeg"));
		dois = new ImageIcon(getClass().getResource("2.jpeg"));
		tres = new ImageIcon(getClass().getResource("3.jpeg"));
		quatro = new ImageIcon(getClass().getResource("4.jpeg"));
		cinco = new ImageIcon(getClass().getResource("5.jpeg"));       
		igameOver= new ImageIcon(getClass().getResource("GameOver.png")); 
		janela( );
		addobjetos ();
		addKeyListener(Rodolfo);
		Thread t = new Thread(this);
		t.start();


	}
	public void atualiza() {


		//RODOLFO_________________________________________________________________________

		Rodolfo.atualiza(danoD, danoO, danoZ, danoZ2);
		pontuacao = Demonio.getPonto() + orc1.getPonto() + Zumbi.getPonto() + Zumbi2.getPonto();
		placar.setText( "Mortes: " + Integer.toString( pontuacao));	
		jVida();
		




		//ZUMBI______________________________________________________________________

		Zumbi.atualiza(Rodolfo.getPosx(), Rodolfo.getPosy(), danoArmaZ, danoZ);

		if(Rodolfo.getHitBox().dano(Zumbi.getHitbox())) {
			Rodolfo.recuar(Zumbi.getX(),Zumbi.getY());
			danoZ = true;
		}
		else danoZ = false;

		if(Rodolfo.isAtacando()) {
			if(Rodolfo.getArma().dano(Zumbi.getHitbox())){
				danoArmaZ = true;
				System.out.println("CONTATOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

			}
		}
		else danoArmaZ = false;

		//ZUMBI2______________________________________________________________________

		Zumbi2.atualiza(Rodolfo.getPosx(), Rodolfo.getPosy(), danoArmaZ2, danoZ2);

		if(Rodolfo.getHitBox().dano(Zumbi2.getHitbox())) {
			Rodolfo.recuar(Zumbi2.getX(),Zumbi2.getY());
			danoZ2= true;
		}
		else danoZ2 = false;

		if(Rodolfo.isAtacando()) {
			if(Rodolfo.getArma().dano(Zumbi2.getHitbox())){
				danoArmaZ2 = true;
				System.out.println("CONTATOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

			}
		}
		else danoArmaZ2 = false;		







		// Demonio______________________________________________________________________

		Demonio.atualiza(Rodolfo.getPosx(), Rodolfo.getPosy(), danoArmaD, danoD);

		if(Rodolfo.getHitBox().dano(Demonio.getHitbox())) {
			Rodolfo.recuar(Demonio.getX(),Demonio.getY());
			danoD = true;
		}
		else danoD = false;

		if(Rodolfo.isAtacando()) {
			if(Rodolfo.getArma().dano(Demonio.getHitbox())){
				danoArmaD = true;
				System.out.println("CONTATOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

			}
		}

		else danoArmaD = false;




		// ORC______________________________________________________________________

		orc1.atualiza(Rodolfo.getPosx(), Rodolfo.getPosy(), danoArmaO, danoO);

		if(Rodolfo.getHitBox().dano(orc1.getHitbox())) {
			Rodolfo.recuar(orc1.getX(),orc1.getY());
			danoO = true;
		}
		else danoO = false;



		if(Rodolfo.isAtacando()) {
			if(Rodolfo.getArma().dano(orc1.getHitbox())){
				danoArmaO = true;
				System.out.println("CONTATOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

			}
		}
		else danoArmaO = false;


	}
	
	public void jVida() {
		if (Rodolfo.getVida() == 5) {
			vida.setIcon(cinco);
		}
		if (Rodolfo.getVida() == 4) {
			vida.setIcon(quatro);
		}
		if (Rodolfo.getVida() == 3) {
			vida.setIcon(tres);
		}
		if (Rodolfo.getVida() == 2) {
			vida.setIcon(dois);
		}
		if (Rodolfo.getVida() == 1) {
			vida.setIcon(um);
		}
		if (Rodolfo.getVida() == 0) {
			vida.setIcon(zero);
			gameOver.setIcon(igameOver);
		}
	}



	private void initComponents() {

		placar = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		placar.setFont(new java.awt.Font("Bodoni MT Condensed", 3, 24)); // NOI18N
		placar.setText("jLabel1");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(310, Short.MAX_VALUE)
						.addComponent(placar)
						.addGap(32, 32, 32))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(37, 37, 37)
						.addComponent(placar)
						.addContainerGap(234, Short.MAX_VALUE))
				);

		pack();
	}




	public  void addobjetos () {
		add(Zumbi);
		add(vida);
		add(gameOver);
		initComponents();
		add(Zumbi2);
		add(Demonio);
		add(orc1);
		add(Rodolfo);
		add(Cenario1);

	}



	public void janela( ) {

		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setSize(800,400);
		setVisible(true);
		setLayout(null);

	}



	@Override
	public void run() {
		while(milisegundo > 0) {
			atualiza();
			try {
				Thread.sleep((long) milisegundo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}