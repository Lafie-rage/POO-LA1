package quizz;

public class Reponse extends Option {

    private int index;
    public Reponse(int index, String texteOption) {
        super(texteOption);
        this.index = index;
    }

    @Override
    public String toString() {
        return this.index + " - " + this.getTexteOption();
    }
}
