import java.util.Random;
public class SortowanieTablic{
    public static void main(String[] args){
        final int iloscElementow = 1000;
        Random r = new Random();
        int[] tab = new int[iloscElementow];
        //losowe wypełnianie
        for(int i = 0; i < iloscElementow; i++){
            tab[i] = r.nextInt(10000) + 1;
        }
        System.out.println("Teraz sortowanie");
        long millisActualTime = System.currentTimeMillis();
        for(int i = 0; i < tab.length; i++){
            for(int j = 1; j < tab.length; j++){
                if(tab[j] < tab[j - 1]){
                    int wieksza = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = wieksza;
                    System.out.println(tab[j]);
                }
            }
        }
        long executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Proces sortownia trwał: " + executionTime);
    }
}