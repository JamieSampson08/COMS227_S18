package lab3;

import plotter.SimulationPlotter;

public class RabbitTest {
	
	public static void main(String [] args) {
		
		SimulationPlotter plotter = new SimulationPlotter();
		
		RabbitModel myModel = new RabbitModel();
		/*
		myModel.simulateYear();
		System.out.println(myModel.getPopulation());
		System.out.println("Expected: 1");
		
		myModel.simulateYear();
		System.out.println(myModel.getPopulation());
		System.out.println("Expected: 2");
		
		myModel.simulateYear();
		System.out.println(myModel.getPopulation());
		System.out.println("Expected: 3");
		
		myModel.simulateYear();
		System.out.println(myModel.getPopulation());
		System.out.println("Expected: 5");
		*/
		plotter.simulate(myModel);
	}
}
