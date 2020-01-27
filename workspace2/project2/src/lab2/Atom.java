package lab2;
/**
 * Information about an atom
 * @author jsamp
 *
 */

public class Atom {
	
	/**
	 * Number of protons of this atom
	 */
	private int protons;
	
	/**
	 * Number of neutrons of this atom
	 */
	private int neutrons;
	
	/**
	 * Number of electrons of this atom
	 */
	private int electrons;
	
	/**
	 * Constructs an atom with the given protons, neutrons, and electrons
	 * @param givenProtons
	 * 		the protons for this atom
	 * @param givenNeutrons
	 * 		the neutrons for this atom
	 * @param givenElectrons
	 * 		the electrons for this atom
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) 
	{
		protons = givenProtons;
		neutrons = givenNeutrons;
		electrons = givenElectrons;
	}
	
	/**
	 * Number of protons
	 * @return
	 * 		Number of protons for this atom
	 */
	public int getProtons()
	{
		return protons;
	}
	
	/**
	 * Number of neutrons
	 * @return
	 * 		Number of neutrons for this atom
	 */
	public int getNeutrons()
	{
		return neutrons;
	}
	
	/**
	 * Number of electrons
	 * @return
	 * 		Number of electrons for this atom
	 */
	public int getElectrons()
	{
		return electrons;
	}
	
	/**
	 * Returns total number of protons plus neutrons
	 * @return
	 * 		Atomic Mass = protons + neutrons
	 */
	public int getAtomicMass() 
	{
		return protons + neutrons;
	}
	
	/**
	 * Returns the difference between the number of protons and electrons
	 * @return
	 * 		Atomic Charge = protons - electrons
	 */
	public int getAtomicCharge()
	{
		return protons - electrons;
	}
	
	/**
	 * Decreases the number of protons and electrons by 2
	 */
	public void decay()
	{
		protons = protons - 2;
		neutrons = neutrons - 2;
	}
}
