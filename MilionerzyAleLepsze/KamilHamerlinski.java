import java.util.Random;
import java.util.Scanner;

class KamilHamerlinski{
    public static Question[] question = new Question[100];
    public static Scanner sc = new Scanner(System.in);
    public static int numberOfHints;
    public static int score;
    public static String usersAnswer;
    public static int currentQuestionNumber;
    public static void main(String[] args) {
        questionManagment();
        getQuestion();
        usersAnswer = sc.nextLine();
        if(usersAnswer == question[currentQuestionNumber].goodAnswer) questionAnswerd(true);
        else questionAnswerd(false);
    }
    public static void getQuestion(){
        Random r = new Random();
        currentQuestionNumber = r.nextInt(100);
        currentQuestionNumber = 0;
        if(question[currentQuestionNumber].isUsed){
            getQuestion();
        }
        else{
            Question currentQuestion = question[currentQuestionNumber];
            System.out.println(currentQuestion.text);
            System.out.println("A. " + currentQuestion.answers[0] + "   C. " + currentQuestion.answers[2] + "\nB. " + currentQuestion.answers[1] + "   D. " + currentQuestion.answers[3]);
            for(int x = 0; x < currentQuestion.answers[currentQuestion.goodAnswerI].length(); x++){
                System.out.print("x");
            }
        }
    }
    public static void questionAnswerd(boolean isCorretctAnswerd){
        if(isCorretctAnswerd){ //wygranie
            score += question[currentQuestionNumber].points - (question[currentQuestionNumber].points / 3 * numberOfHints);
            numberOfHints = 0;
            System.out.println("KONIEC");
        }
        else{
            if(numberOfHints < 3){ //podpowiedź
                numberOfHints++;
            }
            else{ //przegranie
                System.out.println("KONIEC");
            }
        }
        return;
    }
    public static void questionManagment(){
        question[0] = new Question("Pytanie test", 5, "Tak", "Nie", "Może", "On nie wiedział", "D", 3);
    }
}