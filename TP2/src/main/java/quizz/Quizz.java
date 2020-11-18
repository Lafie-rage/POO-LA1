package quizz;

import java.util.Scanner;

public class Quizz {

    private static final Scanner scan = new Scanner(System.in);
    private static Game game;

    public Quizz() {

        /*String playerName = retrievePlayerName();
        int nbQuestions = retrieveNumberOfQuestion();

        partie = new quizz.Partie(nbQuestions, playerName);

        List<JSONObject> jsonObjects = new ArrayList<>();


        partie.setCategory(retrieveCategories(jsonObjects));

        Category category = getChoosenCategory();

        askQuestions(category.getQuestions(partie.getNbQuestions()));

        System.out.println("Bravo " + partie.getNomJoueur() + "! Tu as réussis le quizz ! ;)\n" +
                "Et voici ton score : " + partie.getScore() + " point(s) sur " + partie.getNbQuestions());
        scan.close();*/
    }

    /*private static String retrievePlayerName() {
        System.out.println("Avant de commencer le jeu, choisis ton pseudo !");
        String input = scan.nextLine().replaceAll("\n", ""); // On enlève le \n
        return input;

    }

    private static int retrieveNumberOfQuestion() {
        System.out.println("Un dernier petit effort ! Combien de questions veux-tu dans cette partie ?");
        while (true) {
            String input = scan.nextLine();
            try {
                int nbQuestions = Integer.parseInt(input);
                if (nbQuestions < 1)
                    System.out.println("Ca fait pas beaucoup tout de même... Ca serait trop facile de gagner sinon..! Entre une valeur d'au moins 1 !");
                else if (nbQuestions > 10)
                    System.out.println("C'est peut-être un peu trop... Je sais que tu es un pro mais tu ne pourras avoir qu'au maximum 10 questions !");
                else {
                    return nbQuestions;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ce n'est pas un nombre..! Entre un nombre cette fois-ci !");
            }
        }
    }

    private static List<Category> retrieveCategories(List<JSONObject> jsonObjects) {
        JSONObject jsonObject;
        for (String url : URLOfQuizz.retrievetURLs()) {
            if ((jsonObject = JSONUtils.getJSONObjetcFromUrl(url)) != null) // On vérifie qu'on a réussi à parse le JSON même s'il ne devrait pas l'être
                jsonObjects.add(jsonObject);
        }

        List<Category> categories = new ArrayList<>();
        for (JSONObject json : jsonObjects)
            categories.add(new Category(json.get("thème").toString(), json));
        return categories;
    }

    private static Category getChoosenCategory() {
        List<Category> categories = partie.getCategories();
        System.out.println("Promis, tu pourras jouer juste après! Il va falloir que tu choisisses la catégorie de questions dans laquelle tu veux jouer ! La voici :");
        while (true) {
            for (Category categ : categories)
                System.out.println("\t" + categ.toString());

            String input = scan.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index < 0 || index > categories.size())
                    System.out.println("La valeur n'est pas dans la liste..! Reessaye");
                else {
                    return partie.getCategorie(index);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ce n'est pas un nombre..! Entre un nombre cette fois-ci !");
            }
        }
    }

    private static void askQuestions(List<quizz.Question> questions) {
        for (int i = 0; i < questions.size(); i++) {
            quizz.Question question = questions.get(i);
            while (true) {
                System.out.println(i+1 + " - " + question.getTexteOption());
                for (quizz.Reponse prop : question.getPropositions())
                    System.out.println("\t" + prop.toString());

                System.out.println("Entrez le numéro de la réponse souhaitée");
                String userInput = scan.nextLine();
                try {
                    int pos = Integer.parseInt(userInput);
                    if (pos < 0 || pos > 3) {
                        System.out.println("Nombre invalide...");
                    } else {
                        if (question.isCorrect(pos)) {
                            System.out.println("Bonne réponse !");
                            partie.addPoint(1);
                        } else
                            System.out.println("Mauvaise réponse..!");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Cette réponse n'est pas un nombre...");
                }
            }
        }
    }*/
}
