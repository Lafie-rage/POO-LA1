package quizz;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
    private final int id;
    private final String nom;
    private List<Question> questions = new ArrayList<>();

    public Category(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Category(int id,String nom, List<Question> questions) {
        this(id, nom);
        setQuestions(questions);
        //parseJSON(json);
    }

    /*private void parseJSON(JSONObject json) {
        JSONArray jsonQuestions = json.getJSONObject("quizz").getJSONObject("fr").getJSONArray("débutant");
        List<quizz.Question> questions = new ArrayList<>();

        for (Object question : jsonQuestions) {
            if (question instanceof JSONObject) {
                List<quizz.Reponse> propositions = new ArrayList<>();
                quizz.Reponse reponse = null;
                for (Object proposition : ((JSONObject) question).getJSONArray("propositions")) {
                    if (proposition.toString().equals(((JSONObject) question).getString("réponse"))) {
                        reponse = new quizz.Reponse(propositions.size(), proposition.toString());
                        propositions.add(reponse);
                    } else
                        propositions.add(new quizz.Reponse(propositions.size(), proposition.toString()));

                }
                questions.add(new quizz.Question(((JSONObject) question).getString("question"), propositions, reponse));
            }
        }
        this.questions = questions;
    }*/

    public int getId() {
        return id;
    }

    public String getNom() {
        return this.nom;
    }

    public List<quizz.Question> getQuestions(int nbQuestions) {
        List<quizz.Question> questions = new ArrayList<>();
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

    public void setQuestions(List<Question> questions) {
        if(questions != null)
            for(Question question : questions)
                if(!this.questions.contains(question))
                    this.questions.add(question);
    }

    public void addQuestion(quizz.Question question) {
        this.questions.add(question);
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getNom();
    }
}
