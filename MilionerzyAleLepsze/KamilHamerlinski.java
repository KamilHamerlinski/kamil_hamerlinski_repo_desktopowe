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
        currentQuestionNumber = r.nextInt(100);
        currentQuestionNumber = 0;
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
        question[0] = new Question("Pytanie test", 5, "Tak", "Nie", "Może", "On nie wiedział", "D", 3);
    }
}