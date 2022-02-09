import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
public class Tabele{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ile razy ma się wykonać?");
        int howMany = sc.nextInt();
        for(int a = 0; a < howMany; a++){
            //Zadanie 1
            Random r = new Random();
            int[] tab = new int[2000];
            int[] tabSorted = new int[2000];
            for(int x = 0; x < tab.length; x++){
                tab[x] = r.nextInt(9999) + 1;
                tabSorted[x] = tab[x];
            }
            Arrays.sort(tabSorted);  
            for(int x = 0; x < tabSorted.length; x++){
                System.out.println(tabSorted[x]);
            }
            int point = (int)tabSorted.length / 2;
            System.out.println("Mediana = " + tabSorted[point]);
            int sum = 0;
            for(int x = 0; x < tabSorted.length; x++){
                sum+=x;
            }
            System.out.println("Średnia = " + (sum / tabSorted.length));
            System.out.println("--------------------------------------");
            //Zadanie 2
            int[] tab2 = new int[r.nextInt(900) + 100];
            int[] tabSorted2 = new int[tab2.length];
            for(int x = 0; x < tab2.length; x++){
                tab2[x] = r.nextInt(10000) - 5000;
                tabSorted2[x] = tab2[x];
            }
            Arrays.sort(tabSorted2);  
            for(int x = 0; x < tabSorted2.length; x++){
                System.out.println(tabSorted2[x]);
            }
            point = (int)tabSorted2.length / 2;
            System.out.println("Mediana = " + tabSorted2[point]);
            sum = 0;
            for(int x = 0; x < tabSorted2.length; x++){
                sum+=x;
            }
            System.out.println("Średnia = " + (sum / tabSorted2.length));
            System.out.println("--------------------------------------");
        }
    }
}