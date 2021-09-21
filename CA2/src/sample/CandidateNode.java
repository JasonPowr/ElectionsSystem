package sample;

public class CandidateNode {
    public CandidateNode next = null;
    private Candidate contents;

    /**
     * Returns Candidate the Contents
     */

    public Candidate getContents() {
        return contents;
    }

    /**
     * Updates Candidate the Contents
     */

    public void setContents(Candidate contents) {
        this.contents = contents;
    }

}
