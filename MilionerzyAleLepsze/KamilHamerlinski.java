import java.util.Random;
import java.util.Scanner;

class KamilHamerlinski{
    public static Question[] question = new Question[100];
    public static Scanner sc = new Scanner(System.in);
    public static int numberOfHints; //ilość zużytych podpowiedzi w trakcie obecnego
    public static int score;
    public static boolean endOfQuestion = false;
    public static String usersAnserwWithHints = ""; //to jest to co przechowuje ostanią podpowiedź aby było łatwiej
    public static String usersAnswer; //odpowiedz użytkownika
    public static int currentQuestionNumber; //id obecnego pytnaia

    public static void main(String[] args) {
        questionManagment();
        for(int x = 0; x < 10; x++){
            questionPicking();
        }
    }

    public static void getQuestion(){ //pobieranie nowej pytania
        Random r = new Random();
        //DcurrentQuestionNumber = r.nextInt(100);
        endOfQuestion = false;
        if(question[currentQuestionNumber].isUsed){
            getQuestion();
        }
        else{
            question[currentQuestionNumber].isUsed = true;
            Question currentQuestion = question[currentQuestionNumber];
            System.out.println(currentQuestion.text);
            System.out.println("A. " + currentQuestion.answers[0] + "   C. " + currentQuestion.answers[2] + "\nB. " + currentQuestion.answers[1] + "   D. " + currentQuestion.answers[3]);
            for(int x = 0; x < currentQuestion.answers[currentQuestion.goodAnswerI].length(); x++){
                if(currentQuestion.answers[currentQuestion.goodAnswerI].charAt(x) == " ".charAt(0)){
                    usersAnserwWithHints += new String(" ");
                }
                else{
                    usersAnserwWithHints += new String("x");
                }   
            }
            System.out.println(usersAnserwWithHints);
        }
    }
    public static void questionPicking(){
        getQuestion();
        while(!endOfQuestion){
            usersAnswer = sc.nextLine();
            if(usersAnswer.equals(question[currentQuestionNumber].goodAnswer)) questionAnswerd(true);
            else questionAnswerd(false);
        }
    }
    public static void questionAnswerd(boolean isCorretctAnswerd){ //odpowiadanie
        if(isCorretctAnswerd){ //wygranie
            score += question[currentQuestionNumber].points - (question[currentQuestionNumber].points / 3 * numberOfHints);
            numberOfHints = 0;
            endOfQuestion = true;
            System.out.println("------------------------------");
        }
        else{
            if(numberOfHints < 2){ //podpowiedź
                numberOfHints++;
                getHint();
            }
            else{ //przegranie
                endOfQuestion = true;
                System.out.println("------------------------------");
            }
        }
        return;
    }
    
    public static void getHint(){
        Question currentQuestion = question[currentQuestionNumber];
        String uawh = "";
        Random r = new Random();
        int a;
        do{
            a = r.nextInt(currentQuestion.answers[currentQuestion.goodAnswerI].length());
        }
        while(currentQuestion.answers[currentQuestion.goodAnswerI].charAt(a) == " ".charAt(0));
        for(int x = 0; x < currentQuestion.answers[currentQuestion.goodAnswerI].length(); x++){
            if(x == a){
                uawh += currentQuestion.answers[currentQuestion.goodAnswerI].charAt(x);
            }
            else if(usersAnserwWithHints.charAt(x) == " ".charAt(0)){
                uawh += " ";
            }
            else{
                uawh += usersAnserwWithHints.charAt(x);
            }
        }
        System.out.print(uawh);
        usersAnserwWithHints = uawh;
        System.out.println("");
    }

    public static void questionManagment(){
        question[0] = new Question("Gdzie noworodki mają niezrośniętą kość", 3, "W ręce", "W kręgosłupie", "Mają wszystkie kości zrośnięte", "W czaszce", "D", 4);
        question[1] = new Question("Ulubioną piosenką Hirohiko Arakiego do randke jest", 6, "Shine on your, Crazy Diamond", "Amerika", "GOMBAO 33", "Nothing Else Matters", "A", 1);
        question[2] = new Question("Obraz Dom nad jeziorem z górami został namalowany przez", 9, "Adama Mickiewicza", "Filipa Szcześniaka", "Adolfa Hitlera", "Leonardo DiCaprio", "C", 3);
        question[3] = new Question("Rekorda Suma w Polsce wynosi", 3, "261 cm", "260 cm", "198 cm", "197 cm", "A", 1);
        question[4] = new Question("Wiedźmin, pierwszy raz został wydany jako", 6, "Gra", "Film", "Opowiadanie", "Książka", "C", 3);
        question[5] = new Question("Wiedźmin, pierwszy raz został wydany jako", 6, "Gra", "Film", "Opowiadanie", "Książka", "C", 3);
    }
}