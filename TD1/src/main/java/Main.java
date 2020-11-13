import main.Question;
import main.Reponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Reponses
        List<Reponse> propQuest1 = new ArrayList<>(),
                propQuest2 = new ArrayList<>();

        propQuest1.add(new Reponse(0, "La basse"));
        propQuest1.add(new Reponse(1, "Le violon"));
        propQuest1.add(new Reponse(2, "Le piano"));
        propQuest1.add(new Reponse(3, "Le saxophone"));

        propQuest2.add(new Reponse(0, "Les triolets"));
        propQuest2.add(new Reponse(1, "Le tapping"));
        propQuest2.add(new Reponse(2, "Le crescendo"));
        propQuest2.add(new Reponse(3, "Le slap"));

        Question quest1 = new Question(0, "Quel instrument ayant communement 4 cordes (pouvant aller jusqu'à 6) est responsable du rythme dans les morceaux de musique ?", "Musique", propQuest1, propQuest1.get(0));
        Question quest2 = new Question(1, "Quelle technique souvent utilisé par les bassistes pour rendre leur jeu plus percussif consiste à frapper certains cordes avec le pouces et tirer d'autres avec l'index, le majeur ou l'annulaire ?", "Musique", propQuest2, propQuest2.get(3));

        List<Question> questions = new ArrayList<>();

        questions.add(quest1);
        questions.add(quest2);

        askQuestions(questions);

        System.out.println("Bravo ! Tu as réussis le quizz ! ;)");
    }

    private static void askQuestions(List<Question> questions) {
        Scanner scan = new Scanner(System.in);

        for (Question question : questions) {
            while (true) {
                System.out.println(question.getTexteOption());
                for (Reponse prop : question.getPropositions())
                    System.out.println(prop.getNoOption() + " - " + prop.getTexteOption());

                System.out.println("Entrez le numéro de la réponse souhaitée");
                String userInput = scan.nextLine();
                try {
                    int pos = Integer.parseInt(userInput);
                    if (pos < 0 || pos > 3) {
                        System.out.println("Nombre invalide...");
                    } else {
                        if (question.isCorrect(pos)) {
                            System.out.println("Bonne réponse !");
                            break;
                        } else
                            System.out.println("Mauvaise réponse... Essaye à nouveau !");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Cette réponse n'est pas un nombre...");
                }
            }

        }

    }
}
