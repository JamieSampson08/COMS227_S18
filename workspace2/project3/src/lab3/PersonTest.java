package lab3;

public class PersonTest {
	public static void main(String [] args) {
		Person me = new Person("Jamie", 18);
		
		System.out.println(me.getName());
		System.out.println(me.getAge());
		//System.out.println(me.getNameLength());
		//NullPointerException
	}
}
