package hw1;
/**
 * Homework 1: Calculating cab things
 * @author jsamp
 *
 */
public class Cab {
	
	private boolean person;
	private double totalMiles;
	private double meter;
	private double totalMoney;
	private double fare;
	private double rate;
	private double currentRate;
	
	/**
	 * Constructs a cab that will use the given base fare and per-mile rate
	 * @param givenBaseFare
	 * 		base fare charged for any ride
	 * @param givenPerMileRate
	 * 		per-mile rate
	 */
	public Cab(double givenBaseFare, double givenPerMileRate) {
		fare = givenBaseFare;
		rate = givenPerMileRate;
		currentRate = 0;
	}
	
	/**
	 * Drives the cab the given number of miles, 
	 * updating the total miles and possibly updating 
	 * the meter. In general, the current rate times the 
	 * miles driven is added to the meter, but the current rate 
	 * might be zero. This method does not modify the total cash
	 * @param miles
	 * 		miles = number of miles to drive
	 */
	public void drive(double miles) {
	
	}
	
	/**
	 * Ends the current ride, updating the total cash 
	 * collected and resetting the meter and current rate to zero.
	 */
	public void dropOff() {
		person = false;
		currentRate = 0;
		totalMoney += meter;
		meter = 0;
	
	}

	/**
	 * Returns the average income earned by this cab per mile driven.
	 * @return
	 * 		average income per mile
	 */
	public double getAverageIncomePerMile() {
		return 0;
	
	}

	/**
	 * Returns the current per-mile rate, which is always 
	 * either zero or the per-mile rate given in the constructor.
	 * @return
	 * 		the current per-mile rate
	 */
	public double getCurrentRate() {
		return currentRate;
	}
	
	/**
	 * Returns the amount of money shown on the meter for the 
	 * current ride. This will always be zero before 
	 * start() is called.
	 * @return
	 * 		amount of money shown on the meter
	 */
	public double getMeter() {
		return meter;
	}
	
	/**
	 * Returns the total cash collected by this cab during its lifetime.
	 * @return
	 * 		total cash collected
	 */
	public double getTotalCash() {
		return totalMoney;
	}
	
	/**
	 * Returns the total miles driven by this cab during its lifetime.
	 * @return
	 * 		total miles driven
	 */
	public double getTotalMiles() {
		return totalMiles;
	}

	/**
	 * Determines whether the cab currently has a 
	 * passenger (i.e., the current rate is nonzero).
	 * @return
	 * 		true if the cab has a passenger, false otherwise
	 */
	public boolean hasPassenger() {
		return person;
	}

	/**
	 *Starts a new ride, setting the meter to the base 
	 *fare and setting the current rate to the per mile charge. 
	 *If there had been a previous call to pickUp() without a 
	 *corresponding call to dropOff(), the previous value on 
	 *the meter is ignored 
	 */
	public void pickUp() {
		person = true;
		currentRate = rate;
	}
}