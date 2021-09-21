package sample;

public class PoliticanList {
    PoliticanNode head;

    /**
     * Adds a Politician
     */

    public void addPolitican(Politican p){
        PoliticanNode pN = new PoliticanNode();
        pN.setContents(p);
        pN.next = head;
        head = pN;
    }

    /**
     * Lists the Politicians in the System
     */

    public String listPoliticians(){
        if(numberOfPoliticans() == 0){
            return "No politicians in the system";
        }
        PoliticanNode node = head;
        String politicianList = "";

        while (node != null){
            politicianList += node.getContents().toString();
            node = node.next;
        }
        return politicianList;
    }

    /**
     * Finds a Politician in the System by Party
     */

    public String findPoliticiansByParty(String partyType) {
        if (numberOfPoliticans() == 0) {
            System.out.println("No Politicians in the system");
        }
        String politicianPartyList = "";
        PoliticanNode tempPolitician = head;
        int i = 0;
        while (i < numberOfPoliticans() && tempPolitician != null) {
            if (partyType.toLowerCase().contains(tempPolitician.getContents().getParty().toLowerCase())) {
                politicianPartyList += tempPolitician.getContents().toString();
            }
            tempPolitician = tempPolitician.next;
            i++;
        }
        return politicianPartyList;
    }

    /**
     * Finds Politicians in the System by Location
     */

    public String findPoliticiansByLocation(String Location) {
        if (numberOfPoliticans() == 0) {
            System.out.println("No Politicians in the system");
        }
        String politicianLocationList = "";
        PoliticanNode tempPolitician = head;
        int i = 0;
        while (i < numberOfPoliticans() && tempPolitician != null) {
            if (Location.toLowerCase().contains(tempPolitician.getContents().getHomeCounty().toLowerCase())) {
                politicianLocationList += tempPolitician.getContents().toString();
            }
            tempPolitician = tempPolitician.next;
            i++;
        }
        return politicianLocationList;
    }

    /**
     * Returns the number of Politicians
     */

    public int numberOfPoliticans(){
        PoliticanNode node = head;
        int numberOfPoliticians = 0;

        while(node != null){
            numberOfPoliticians++;
            node = node.next;
        }
        return numberOfPoliticians;
    }

    /**
     * Finds the Politicians in the System
     */

    public Politican findPoliticans(String politicansName){
        if(numberOfPoliticans() == 0){
            System.out.println("No politicians in the system");
        }
        PoliticanNode tempPolitican = head;
        Politican foundPolitician = null;

        int i = 0;
        while (i < numberOfPoliticans() && tempPolitican != null){
            if(politicansName.toLowerCase().contains(tempPolitican.getContents().getName().toLowerCase())){
                foundPolitician = tempPolitican.getContents();
            }
            tempPolitican = tempPolitican.next;
            i++;
        }
        return foundPolitician;
    }

    /**
     * Deletes a Politician in the System
     */

    public void deletePolitican(String politicianName){
        if(numberOfPoliticans() == 0){
            System.out.println("No Politicians in the system");
        }
        PoliticanNode tempPolitician = head;
        int i = 0;
        while (i < numberOfPoliticans() && tempPolitician != null){
            if(politicianName.toLowerCase().contains(head.getContents().getName())){
                head = head.next;
                tempPolitician = tempPolitician.next;
            }
            i++;
        }
        if (tempPolitician != null && tempPolitician.next != null){
            tempPolitician.next = tempPolitician.next.next;
        }

    }
}
