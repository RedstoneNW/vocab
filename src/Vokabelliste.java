public class Vokabelliste {

    private List<Vocab> vocabs;
    
    public Vokabelliste() {
        vocabs = new List<Vocab>();
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

    public Vocab getNext() {
            vocabs.toFirst();
            Vocab worstVocab = vocabs.getContent();
            while (vocabs.hasAccess()) {
                if (vocabs.getContent().getCorrect() < worstVocab.getCorrect()) {
                    worstVocab = vocabs.getContent();
                }
                vocabs.next();
            }
        return worstVocab;
    }
}
