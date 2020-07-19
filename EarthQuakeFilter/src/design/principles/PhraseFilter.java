package design.principles;

public class PhraseFilter implements Filter {
    private String type;
    private String phrase;

    public PhraseFilter(String type, String phrase) {
        this.type = type;
        this.phrase = phrase;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        switch (type) {
            case "start":
                return qe.getInfo().startsWith(phrase);
            case "any":
                return qe.getInfo().contains(phrase);
            case "end":
                return qe.getInfo().endsWith(phrase);
            default:
                return false;
        }
    }

    @Override
    public String getName() {
        return null;
    }
}
