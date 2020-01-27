package lab3;

import java.util.Random;

public class RabbitModel3 {
	
	private int rabbitAlive;
	private Random rand;
	
	public RabbitModel3() {
		rabbitAlive = 0; 
		rand = new Random(10); 
	}
	
	public int getPopulation() {
		return rabbitAlive;
	}
	
	public void simulateYear() {
		rabbitAlive += rand.nextInt(10); 
		
	}
	
	public void reset() {
		rabbitAlive = 0; 
	}
}
