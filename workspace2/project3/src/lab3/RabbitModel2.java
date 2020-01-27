package lab3;

public class RabbitModel2 {
	
	private int rabbitAlive;
	
	public RabbitModel2() {
		rabbitAlive = 500;
	}
	
	public int getPopulation() {
		return rabbitAlive;
	}
	
	public void simulateYear() {
		rabbitAlive = rabbitAlive / 2; 
		
	}
	
	public void reset() {
		rabbitAlive = 500; 
	}
}
