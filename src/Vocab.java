public class Vocab {
    private List<String> en;
    private List<String> de;
    private int correct;

    public Vocab(List<String> pEN, List<String> pDE) {
        en = pEN;
        de = pDE;
        correct = 0;
        en.toFirst();
        de.toFirst();
    }

    public void setCorrect(int pCorrect) {
        this.correct = pCorrect;
    }

    public int getCorrect() {
        return correct;
    }

    public List<String> getDe() {
        return de;
    }

    public List<String> getEn() {
        return en;
    }
}
