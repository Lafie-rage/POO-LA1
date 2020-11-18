package quizz;

import java.util.Objects;

public class Option implements quizz.InformationGenerale {
    protected final int noOption = countItems++;
    private String texteOption;

    private static int countItems = 0;

    public Option(String texteOption) {
        this.texteOption = texteOption;
    }

    /*public int getNoOption() {
        return noOption;
    }

    public String getTexteOption() {
        return texteOption;
    }

    public void setTexteOption(String texteOption) {
        this.texteOption = texteOption;
    }

    public static int getNumberItems() {
        return countItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return noOption == option.noOption &&
                texteOption.equals(option.texteOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOption, texteOption);
    }

    @Override
    public String toString() {
        return "quizz.Option{" +
                "noOption=" + noOption +
                ", texteOption='" + texteOption + '\'' +
                '}';
    }*/

    @Override
    public boolean estUneQuestion() {
        return texteOption.endsWith("?");
    }
}
