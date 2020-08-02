import java.io.IOException;

public class Hauptmethode {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Matrix a =new Matrix();
		Matrix b=new Matrix();
		Matrix c=new Matrix();
		Matrix d=new Matrix();
		System.out.println("Klasse Matrix Version 1.0");
		System.out.println("Die erste Matrix eingeben : ");
		a.eingabe();
		System.out.println("Die erste Matrix lautet: ");
		a.ausgabe();
		a.transponieren();
		System.out.println("Die  transponierte Matrix lautet :");
		a.ausgabe();
		System.out.println("\n");
		System.out.println("Die zweite Matrix eingeben :");
		b.eingabe();
		System.out.println();
		System.out.println(" Die zweite Matrix lautet :");
		b.ausgabe();
		System.out.println("\n");
        c=Matrix.addieren(a, b);
        System.out.println("Die summe lautet : ");
        c.ausgabe();
        System.out.println("\n");
        d=Matrix.multiplizieren(a, b);
        System.out.println("Das produkt Lautet");
        d.ausgabe();
        
	}

}
