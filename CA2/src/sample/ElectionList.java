package sample;

public class ElectionList {
    ElectionNode head;

    public void addElection(Election e){
        ElectionNode eN = new ElectionNode();
        eN.setContents(e);
        eN.next = head;
        head = eN;
    }

    /**
     * Lists Elections in the system
     */

    public String listElections(){
        if(numberOfElections() == 0){
            return "No elections in the system";
        }
        ElectionNode node = head;
        String electionList = "";

        while (node != null){
            electionList += node.getContents().toString();
            node = node.next;
        }
        return electionList;
    }

    /**
     * Returns the Number of Elections
     */

    public int numberOfElections(){
        ElectionNode node = head;
        int numberOfElections = 0;

        while(node != null){
            numberOfElections++;
            node = node.next;
        }
        return numberOfElections;
    }

    /**
     * Finds Elections in the System
     */

    public Election findElections(String electionId){
        if(numberOfElections() == 0){
            System.out.println("No elections in the system");
        }
        ElectionNode tempElection = head;
        Election foundElection = null;
        int i = 0;

        while (i < numberOfElections() && tempElection != null) {
            if (electionId.toLowerCase().equals(tempElection.getContents().getElectionID().toLowerCase())) {
                foundElection = tempElection.getContents();
            }
            tempElection = tempElection.next;
            i++;
        }
        return foundElection;
    }

    /**
     * Finds Elections in the System by Type
     */

    public String findElectionsByType(String electionType) {
        if (numberOfElections() == 0) {
            System.out.println("No elections in the system");
        }
        String ElectionTypeList = "";
        ElectionNode tempElection = head;
        int i = 0;
        while (i < numberOfElections() && tempElection != null) {
            if (electionType.toLowerCase().contains(tempElection.getContents().getType().toLowerCase())) {
                ElectionTypeList += tempElection.getContents().toString();
            }
            tempElection = tempElection.next;
            i++;
        }
        return ElectionTypeList;
    }

    /**
     * Finds Elections by year
     */

    public String findElectionsByYear(String electionYear) {
        if (numberOfElections() == 0) {
            System.out.println("No elections in the system");
        }
        String ElectionYearList = "";
        ElectionNode tempElection = head;
        int i = 0;
        while (i < numberOfElections() && tempElection != null) {
            if (electionYear.toLowerCase().contains(tempElection.getContents().getYearDate().toLowerCase())) {
                ElectionYearList += tempElection.getContents().toString();
            }
            tempElection = tempElection.next;
            i++;
        }
        return ElectionYearList;
    }

    /**
     * Deletes an Election
     */

    public void deleteElection(String electionID) {
        if (numberOfElections() == 0) {
            System.out.println("No Elections in the system");
        }
        ElectionNode tempElection = head;
        int i = 0;
        while (i < numberOfElections() && tempElection != null) {
            if (electionID.toLowerCase().contains(head.getContents().getElectionID())) {
                head = head.next;
                tempElection = tempElection.next;
            }
            i++;
        }

        if (tempElection != null && tempElection.next != null) {
            tempElection.next = tempElection.next.next;
        }
    }
}
