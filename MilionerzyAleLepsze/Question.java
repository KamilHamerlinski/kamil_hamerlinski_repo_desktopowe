class Question{
    public String text;
    public int points;
    public String[] answers = new String[4];
    public String goodAnswer;
    public int goodAnswerI;
    public boolean isUsed;

    public Question(String t, int p, String a, String b, String c, String d, String g, int gi){
        this.text = t;
        this.points = p;
        this.answers[0] = a;
        this.answers[1] = b;
        this.answers[2] = c;
        this.answers[3] = d;
        this.goodAnswer = g;
        this.goodAnswerI = gi;
    }
}