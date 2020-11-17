package quizz;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private int nbQuestions = 1; // Au moins une questions
    private String nomJoueur = "Unknow player";
    private List<Categorie> categories = new ArrayList<>();
    private int score = 0;

    public Partie(int nbQuestions, String nomJoueur) {
        setNbQuestion(nbQuestions);
        setNomJoueur(nomJoueur);
    }

    private void setNbQuestion(int nbQuestions) {
        if (nbQuestions > 0) {
            this.nbQuestions = nbQuestions;
        }
    }

    public void addPoint(int points) {
        if (points > 0) {
            this.score += points;
        }
    }

    public int getNbQuestions() {
        return nbQuestions;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    private void setNomJoueur(String nomJoueur) {
        if (nomJoueur != null && !nomJoueur.equals(""))
            this.nomJoueur = nomJoueur;
    }

    public List<Categorie> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Categorie> categories) {
        if (categories != null && categories.size() > 0) {
            this.categories = categories;
        }
    }

    public Categorie getCategorie(int index) {
        return categories.get(index);
    }

    public int getScore() {
        return this.score;
    }
}
