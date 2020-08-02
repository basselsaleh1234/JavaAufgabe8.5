import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Matrix {

    
   private int [][] matrix;
   private int zeilen;
   private int spalten;

   public Matrix(){
       matrix = null;
       zeilen = spalten = 0;
   }


   private void allokieren(int z, int s){
       matrix = new int[z][s];
       zeilen = z;
       spalten = s;
   }


   public void ausgabe(){
       int i,j;	
       //Matrix ausgeben
       for (i=0;i<zeilen;i++){
               for (j=0; j < spalten; j++) System.out.print(matrix[i][j] + "   ");
               System.out.println();
       }
   }

   public void eingabe() throws IOException {
       int i,j;
       BufferedReader einlesen  = new BufferedReader(new InputStreamReader(System.in));
       
       System.out.print("Bitte die Anzahl der Zeilen eingeben: ");
       zeilen = Integer.parseInt(einlesen.readLine());
       System.out.print("Bitte die Anzahl der Spalten eingeben: ");
       spalten = Integer.parseInt(einlesen.readLine());
	        
       //Array anlegen
       allokieren(zeilen,spalten);

        //Matrix einlesen
       for (i=0;i<zeilen;i++) {
           for (j=0;j<spalten;j++) {
                   System.out.print("Bitte Element [" + i + " , " + j + "] eingeben: ");
                   matrix[i][j]= Integer.parseInt(einlesen.readLine());
           }
       }

   }

   public void transponieren() {
       int i,j;
       int [][] dummy = new int[zeilen][spalten];

       
	 //Kopie erstellen
       for (i = 0; i < zeilen; i++)
               for (j = 0; j < spalten; j++) 
               	dummy[i][j] = matrix[i][j];
       
       //Transponierung
       for (i = 0; i < zeilen; i++)
               for (j = 0; j < spalten; j++) 
               	matrix[i][j] = dummy[j][i];

   }


     
   static public Matrix addieren (Matrix a,Matrix b) {
       int i, j;
       Matrix summe = new Matrix();

       //Array anlegen
       summe.allokieren(a.zeilen, a.spalten);

       if (a.spalten != b.spalten || a.zeilen != b.zeilen) return summe;

       //Addieren
       for (i = 0; i < a.zeilen; i++)
               for (j = 0; j < a.spalten; j++)
                   summe.matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];

       return summe;
   }

   static public Matrix multiplizieren(Matrix a, Matrix b) {
       int i, j, k;
       int summe;
       Matrix produkt = new Matrix();

       produkt.allokieren(a.zeilen, b.spalten);

       if (a.spalten != b.zeilen) return produkt;

       b.transponieren();

       for (k = 0; k < a.zeilen; k++)
           for (i = 0; i < b.zeilen; i++) {
               summe = 0;
               for (j = 0; j < a.spalten; j++)
                       summe = summe + a.matrix[k][j] * b.matrix[i][j];

               produkt.matrix[k][i] = summe;
       }

       return produkt;
   }

	
	
}
