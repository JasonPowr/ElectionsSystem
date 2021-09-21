package sample;

public class Candidate extends Politican{
    private int numberOfVotes;

    /**
     * Constructor for objects of class Candidate
     *
     * @param numberOfVotes    Number of votes of a Politican
     */

    public Candidate(String name, String dateOfBirth, String party, String homeCounty, int numberOfVotes){
        super(name, dateOfBirth, party, homeCounty);
        this.numberOfVotes = numberOfVotes;
    }


    //-------
    //getters
    //-------

    /**
     * Returns the Number of Votes
     */

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    //-------
    //setters
    //-------

    /**
     * Updates the Number of Votes
     */

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    /**
     * Builds a String representing a user friendly representation of the object state
     *
     * @return Details of the specific Candidate
     */

    @Override
    public String toString() {
        return "Name : " + getName() + "    DOB : " + getDateOfBirth() + "    Political Party : " + getParty() + "    Home County : " + getHomeCounty() + "    Number of Votes : " + numberOfVotes +  "\n" +
                "----------------------------------------------------------------------------------"+"\n";
    }
}
