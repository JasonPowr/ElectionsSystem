package sample;

public class Election {
    private String type, location, yearDate, seats, electionID;
    private PoliticanList politicanList = new PoliticanList();
    private CandidateList candidateList = new CandidateList();

    /**
     * Constructor for objects of class Election
     *
     * @param type       The type of election
     * @param location   The location of the election
     * @param yearDate   The date of the election
     * @param seats      The number of seats in the election
     * @param electionID The election ID
     */

    public Election(String electionID, String type, String location, String yearDate, String seats) {
        this.type = type;
        this.location = location;
        this.yearDate = yearDate;
        this.seats = seats;
        this.electionID = electionID;
    }

    //-------
    //getters
    //-------

    /**
     * Returns the Candidate List
     */

    public CandidateList getCandidateList() {
        return candidateList;
    }

    /**
     * Returns the Politician List
     */

    public PoliticanList getPoliticanList() {
        return politicanList;
    }

    /**
     * Returns the Election type
     */

    public String getType() {
        return type;
    }

    /**
     * Returns the Election location
     */

    public String getLocation() {
        return location;
    }

    /**
     * Returns the Election date
     */

    public String getYearDate() {
        return yearDate;
    }

    /**
     * Returns the Election seats
     */

    public String getSeats() {
        return seats;
    }

    /**
     * Returns the Election ID
     */

    public String getElectionID() {
        return electionID;
    }

    //-------
    //setters
    //-------


    /**
     * Updates Candidate List
     */

    public void setCandidateList(CandidateList candidateList) { this.candidateList = candidateList; }

    /**
     * Updates Politician List
     */

    public void setPoliticanList(PoliticanList politicanList) { this.politicanList = politicanList; }

    /**
     * Updates Election Type
     */

    public void setType(String type) { this.type = type; }

    /**
     * Updates Election Location
     */

    public void setLocation(String location) { this.location = location; }

    /**
     * Updates Election Date
     */

    public void setYearDate(String yearDate) { this.yearDate = yearDate; }

    /**
     * Updates Election Seats
     */

    public void setSeats(String seats) { this.seats = seats; }

    /**
     * Updates Election ID
     */

    public void setElectionID(String electionID) {
        this.electionID = electionID;
    }

    /**
     * Builds a String representing a user friendly representation of the object state
     *
     * @return Details of the specific Election
     */

    @Override
    public String toString() {
        return "Election ID : " + electionID + "    Type : " + type + "    Location : " + location + "    Year/Date : " + yearDate + "    Seats : " + seats + "\n" +
                "-------------------------------------------------------------------------" + "\n";
    }
}





