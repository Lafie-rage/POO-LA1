package quizz;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int nbQuestions = 1; // Au moins une questions
    private List<Player> players = new ArrayList<>();
    private Category category;
    private int score = 0;

    public Game(int nbQuestions, List<Player> players, Category category) {
        setNbQuestion(nbQuestions);
        setListJoueurs(players);
        this.category = category;
    }

    private void setNbQuestion(int nbQuestions) {
        if (nbQuestions > 0) {
            this.nbQuestions = nbQuestions;
        }
    }

    /*
    public void addPoint(int points) {
        if (points > 0) {
            this.score += points;
        }
    }

    public int getNbQuestions() {
        return nbQuestions;
    }

    public List<Player> getJoueurs() {
        return new ArrayList<>(players);
    }
    */

    private void setListJoueurs(List<Player> players) {
        if (players != null)
            for(Player player : players)
                if(!this.players.contains(player))
                    this.players.add(player);
    }

    /*
    public Category getCategory() {
        return this.category;
    }

    public int getScore() {
        return this.score;
    }*/
}
