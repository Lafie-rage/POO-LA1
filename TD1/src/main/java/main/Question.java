package main;

import java.util.ArrayList;
import java.util.List;

public class Question extends Option{

    private String categorie;
    private List<Reponse> propositions = new ArrayList<>();
    private Reponse bonneReponse;

    public Question(int noOption, String texteOption, String categorie, List<Reponse> propositions, Reponse bonneReponse) {
        super(noOption, texteOption);
        this.categorie = categorie;
        setProposition(propositions);
        setBonneReponse(bonneReponse);
    }

    private void setProposition(List<Reponse> propositions) {
        if(propositions.size() == 4) // On vérifie qu'il y ai unique 4 réponses
            for(Reponse prop : propositions) // On vérifie la présence des réponses en un seul exemplaire
                if(!this.propositions.contains(prop))
                    this.propositions.add(prop);
    }

    private void setBonneReponse(Reponse bonneReponse) {
        if(propositions != null && propositions.contains(bonneReponse)) // On vérifie la présence de la réponse dans les propositions
            this.bonneReponse = bonneReponse;
    }

    public List<Reponse> getPropositions() {
        return new ArrayList<>(propositions);
    }

    public boolean isCorrect(int pos) {
        return bonneReponse == propositions.get(pos);
    }
}
