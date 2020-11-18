package quizz;

public class Answer extends Option {

    private int index;
    public Answer(int index, String texteOption) {
        super(texteOption);
        this.index = index;
    }

    /*
    @Override
    public String toString() {
        return this.index + " - " + this.getTexteOption();
    }
    */
}
