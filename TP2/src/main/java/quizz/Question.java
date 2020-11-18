package quizz;

import java.util.ArrayList;
import java.util.List;

public class Question extends Option implements Comparable<Question>{

    private List<Answer> propositions = new ArrayList<>();
    private Answer bonneAnswer;

    public Question(String texteOption, List<Answer> propositions, Answer bonneAnswer) {
        super(texteOption);
        setProposition(propositions);
        setBonneReponse(bonneAnswer);
    }

    private void setProposition(List<Answer> propositions) {
        if(propositions.size() == 4) // On vérifie qu'il y ai unique 4 réponses
            for(Answer prop : propositions) // On vérifie la présence des réponses en un seul exemplaire
                if(!this.propositions.contains(prop))
                    this.propositions.add(prop);
    }

    private void setBonneReponse(Answer bonneAnswer) {
        if(propositions != null && propositions.contains(bonneAnswer)) // On vérifie la présence de la réponse dans les propositions
            this.bonneAnswer = bonneAnswer;
    }

    public List<Answer> getPropositions() {
        return new ArrayList<>(propositions);
    }

    public boolean isCorrect(int pos) {
        return bonneAnswer == propositions.get(pos);
    }

    @Override
    public int compareTo(Question question) {
        return Integer.compare(this.noOption, question.noOption);
    }
}
