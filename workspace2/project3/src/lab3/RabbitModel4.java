package lab3;

public class RabbitModel4 {
	
	private int rabbitAlive;
	private int lastYear;
	private int yearBefore;
	
	public RabbitModel4() {
		lastYear = 1;
		yearBefore = 0;
	}
	
	public int getPopulation() {
		return rabbitAlive;
	}
	
	public void simulateYear() {
		rabbitAlive = lastYear + yearBefore;
		yearBefore = lastYear;
		lastYear = rabbitAlive;
		
	}
	
	public void reset() {
		rabbitAlive = 0;
		lastYear = 1;
		yearBefore = 0;
	}
}
