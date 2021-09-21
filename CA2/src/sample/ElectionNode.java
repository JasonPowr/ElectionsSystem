package sample;

public class ElectionNode {
    public ElectionNode next = null;
    private Election contents;

    /**
     * Returns the Election Contents
     */

    public Election getContents() {
        return contents;
    }

    /**
     * Updates the Election Contents
     */

    public void setContents(Election contents) {
        this.contents = contents;
    }
}
