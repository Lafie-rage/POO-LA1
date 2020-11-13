package main;

import java.util.Objects;

public class Option implements InformationGenerale {
    protected int noOption;
    private String texteOption;

    private static int countItems = 0;

    public Option(int noOption, String texteOption) {
        this.noOption = noOption;
        this.texteOption = texteOption;
        countItems++;
    }

    public void finalize() { // deprecated
        System.out.println("Objet détruit");
        countItems--;
    }

    public int getNoOption() {
        return noOption;
    }

    public void setNoOption(int noOption) {
        this.noOption = noOption;
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
        return "Option{" +
                "noOption=" + noOption +
                ", texteOption='" + texteOption + '\'' +
                '}';
    }

    @Override
    public boolean estUneQuestion() {
        return texteOption.endsWith("?");
    }
}
