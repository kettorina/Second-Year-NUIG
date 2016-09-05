package week6;

public class Zoo {
	public static void main(String [] args){
		
		Canary canary1 = new Canary("Bob", 2, 3);
		Salmon salmon1 = new Salmon("Pete", 89, 237);
		Canary canary2 = new Canary("Bob", 2, 3);
		NorwegianBlue blue1 = new NorwegianBlue("Timmy", 7, 9);
		Ostrich ostrich1 = new Ostrich("Jimmy", 5.8);
		Shark shark1 = new Shark("Billy", 7);
		
		System.out.println(canary1.toString());
		System.out.println(salmon1.toString());
		System.out.println(canary2.toString());
		System.out.println(blue1.toString());
		System.out.println(ostrich1.toString());
		System.out.println(shark1.toString());
		
		canary1.move(35);
		salmon1.move(0);
		canary2.move(500);
		blue1.move(42);
		ostrich1.move(37);
		shark1.move(1000);
		
		String out = salmon1.equals(canary1)? "Canary and salmon are equal;" : "Canary and salmon are not equal;";
		String out1 = canary2.equals(canary1)? "Canary and canary are equal;" : "Canary and canary are not equal;";
		System.out.println(out);
		System.out.println(out1);
	}

}
