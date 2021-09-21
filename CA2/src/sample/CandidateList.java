package sample;

public class CandidateList {
    CandidateNode head;

    /**
     * Adds a Candidate
     */

    public void addCandidate(Candidate c){
        CandidateNode cN = new CandidateNode();
        cN.setContents(c);
        cN.next = head;
        head = cN;
    }

    /**
     * Returns the Number of Candidates
     */

    public int numberOfCandidates(){
        CandidateNode node = head;
        int numberOfCandidates = 0;

        while(node != null){
            numberOfCandidates++;
            node = node.next;
        }
        return numberOfCandidates;
    }

    /**
     * Lists the Candidates
     */

    public String listCandidates(){
        if(numberOfCandidates() == 0){
            return "No Candidates in the system";
        }
        CandidateNode node = head;
        String candidateList = "";

        while (node != null){
            candidateList += node.getContents().toString();
            node = node.next;
        }
        return candidateList;
    }

    /**
     * Deletes a Candidate
     */

    public void deleteCandidate(String candidateName){
        if(numberOfCandidates() == 0){
            System.out.println("No Candidates in the system");
        }
        CandidateNode tempCandidate = head;
        int i = 0;
        while (i < numberOfCandidates() && tempCandidate != null) {
            if (candidateName.toLowerCase().contains(head.getContents().getName())) {
                head = head.next;
                tempCandidate = tempCandidate.next;
            }
            i++;
        }
    }


}
