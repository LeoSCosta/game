package Jogo2D;

public class Hit {

	private float x0 = 0, x1 = 0, y0 = 0, y1 = 0;
	

	
	// Atualiza a posi��o do hitBox
	public void mover (float x, float y, float largura, float altura){
		this.x0 = x;
		this.x1 = x + largura; 
		this.y0 = y;
		this.y1 = y + altura;
		
	}

	//metodo que indentifica o contato entre dois objetos
	public Boolean dano (Hit b){
		double w = ((x1-x0) + (b.x1 - b.x0)) / 2;
		double h = ((y1-y0) + (b.y1 - b.y0)) / 2;
		double dx = ((x1 + x0) - (b.x1 + b.x0)) / 2;
		double dy = ((y1 + y0) - (b.y1 + b.y0)) / 2;
		if (Math.abs(dx) <= w && Math.abs(dy) <= h) {
			double wy = w * dy; double hx = h * dx;
			if (wy > hx) {
				if (wy > -hx) return true;
				else return true;
			} else {
				if (wy > -hx) return true;
				else return true;
			}
		}
		return false;
	}
}