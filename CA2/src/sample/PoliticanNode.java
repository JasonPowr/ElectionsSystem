package sample;

public class PoliticanNode {
    public PoliticanNode next = null;
    private Politican contents;

    /**
     * Returns the Politician Contents
     */

    public Politican getContents() {
        return contents;
    }

    /**
     * Updates the Politician Contents
     */

    public void setContents(Politican contents) {
        this.contents = contents;
    }
}