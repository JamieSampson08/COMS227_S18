package lab3;

public class RabbitModel1 {
	
	private int rabbitAlive;
	
	public RabbitModel1() {
		rabbitAlive = 0; 
	}
	
	public int getPopulation() {
		return rabbitAlive;
	}
	
	public void simulateYear() {
		rabbitAlive += 1;
		if(rabbitAlive % 5 == 0) {
			reset();
		}
	}
	
	public void reset() {
		rabbitAlive = 0;
	}
}
