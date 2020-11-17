package quizz;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categorie {
    private static int countItems = 0;
    private final int id = countItems++;
    private final String nom;
    private List<Question> questions = new ArrayList<>();

    public Categorie(String nom, JSONObject json) {
        this.nom = nom;
        parseJSON(json);
    }

    private void parseJSON(JSONObject json) {
        JSONArray jsonQuestions = json.getJSONObject("quizz").getJSONObject("fr").getJSONArray("débutant");
        List<Question> questions = new ArrayList<>();

        for (Object question : jsonQuestions) {
            if (question instanceof JSONObject) {
                List<Reponse> propositions = new ArrayList<>();
                Reponse reponse = null;
                for (Object proposition : ((JSONObject) question).getJSONArray("propositions")) {
                    if (proposition.toString().equals(((JSONObject) question).getString("réponse"))) {
                        reponse = new Reponse(propositions.size(), proposition.toString());
                        propositions.add(reponse);
                    } else
                        propositions.add(new Reponse(propositions.size(), proposition.toString()));

                }
                questions.add(new Question(((JSONObject) question).getString("question"), propositions, reponse));
            }
        }
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return this.nom;
    }

    public List<Question> getQuestions(int nbQuestions) {
        List<Question> questions = new ArrayList<>();
        List<Integer> alreadyUsed = new ArrayList<>();
        int random;
        for (int i = 0; i < nbQuestions; i++) {
            do {
                random = (int) (Math.random() * this.questions.size());
            } while (alreadyUsed.contains(random));
            questions.add(this.questions.get(random));
            alreadyUsed.add(random);
        }
        Collections.sort(questions);
        return questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getNom();
    }
}
