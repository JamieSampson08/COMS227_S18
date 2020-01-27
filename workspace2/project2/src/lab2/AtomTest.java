package lab2;

public class AtomTest {
	public static void main(String [] args) {
		Atom uranium = new Atom (92, 146, 92);
		
		System.out.println(uranium.getProtons());
		System.out.println(uranium.getNeutrons());
		System.out.println(uranium.getElectrons());
		
		System.out.println(uranium.getAtomicCharge());
		System.out.println(uranium.getAtomicMass());
		
		uranium.decay();
		System.out.println("After decay: ");
		System.out.println(uranium.getProtons());
		System.out.println(uranium.getNeutrons());
		
		
		
		
	}
}
