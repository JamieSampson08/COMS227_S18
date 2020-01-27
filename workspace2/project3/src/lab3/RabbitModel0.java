package lab3;

public class RabbitModel0 {
	
	private int rabbitAlive;
	
	public RabbitModel0() {
		rabbitAlive = 2;
	}
	
	public int getPopulation() {
		return rabbitAlive;
	}
	
	public void simulateYear() {
		rabbitAlive += 1;
	}
	
	public void reset() {
		rabbitAlive = 2;
	}
}
