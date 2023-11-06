public class Vokabelliste {

    private List<Vocab> vocabs;
    private Vocab currentVocab;
    private boolean askForGerman;
    
    public Vokabelliste() {
        vocabs = new List<Vocab>();
        askForGerman = false;
    }
    
    public void add(Vocab pVocab) {
        vocabs.append(pVocab);
    }

    public void remove(Vocab pVocab) {
        vocabs.toFirst();
        while (vocabs.hasAccess()) {
            if (vocabs.getContent().equals(pVocab)) {
                vocabs.remove();
                vocabs.toLast();
            }
            vocabs.next();
        }
    }

    public List<String> getNext() {
            vocabs.toFirst();
            Vocab worstVocab = vocabs.getContent();
            while (vocabs.hasAccess()) {
                if (vocabs.getContent().getCorrect() < worstVocab.getCorrect()) {
                    worstVocab = vocabs.getContent();
                }
                vocabs.next();
            }
            currentVocab = worstVocab;
            if (askForGerman) {
                return worstVocab.getEn();
            } else {
                return worstVocab.getDe();
            }
    }

    public boolean checkVocab(String pIn) {
        List<String> posAnswers = new List<>();
        if (askForGerman) {
            posAnswers = currentVocab.getDe();
        } else {
            posAnswers = currentVocab.getEn();
        }
        posAnswers.toFirst();
        boolean correct = false;
        while (posAnswers.hasAccess() && !correct) {
            if (posAnswers.getContent().equals(pIn)) {
                correct = true;
                currentVocab.setCorrect(currentVocab.getCorrect() + 1);
            }
            posAnswers.next();
        }
        if (!correct) {
            currentVocab.setCorrect(currentVocab.getCorrect() - 1);
        }
        return correct;
    }

    public void setAskForGerman() {
        askForGerman = !askForGerman;
    }
}
