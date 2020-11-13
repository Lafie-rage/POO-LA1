import main.Option;

public class Main {
    public static void main(String[] args) {
        Option uneOption = new Option(1, "nom de mon option");
        Option uneAutreOption = new Option(1, "nom de mon option");
        Option encoreUneOption = new Option(1, "Une ? option");
        Option encoreUneAutreOption = new Option(1, "Est-ce une option ?");

        System.out.println(uneOption.toString());

        System.out.println("Il y a " + Option.getNumberItems() + " options.");

        System.out.println("L'option est une question : " + uneOption.estUneQuestion());
        System.out.println("L'option est une question : " + encoreUneOption.estUneQuestion());
        System.out.println("L'option est une question : " + encoreUneAutreOption.estUneQuestion());
    }
}
