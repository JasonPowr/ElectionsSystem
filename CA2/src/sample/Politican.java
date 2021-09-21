package sample;

public abstract class Politican {
    private String name,dateOfBirth,party,homeCounty;

    /**
     * Constructor for objects of class Politican
     *
     * @param name         Name of the Politician
     * @param dateOfBirth  Politicians date of birth
     * @param party        Politicians party
     * @param homeCounty   Politicians home county
     */

    public Politican(String name, String dateOfBirth, String party, String homeCounty) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.party = party;
        this.homeCounty = homeCounty;
    }

    //-------
    //getters
    //-------

    /**
     * Returns the Politicians name
     */

    public String getName() {
        return name;
    }

    /**
     * Returns the Politicians date of birth
     */

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns the Politicians party
     */

    public String getParty() {
        return party;
    }

    /**
     * Returns the Politicians home county
     */

    public String getHomeCounty() {
        return homeCounty;
    }

    //-------
    //setters
    //-------

    /**
     * Updates name
     */


    public void setName(String name) { this.name = name; }

    /**
     * Updates date of birth
     */


    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    /**
     * Updates party
     */


    public void setParty(String party) { this.party = party; }

    /**
     * Updates home county
     */

    public void setHomeCounty(String homeCounty) {
        this.homeCounty = homeCounty;
    }

    /**
     * Builds a String representing a user friendly representation of the object state
     *
     * @return Details of the specific Politician
     */

    @Override
    public String toString() {
        return "Name : " + name + "    DOB : " + dateOfBirth + "    Political Party : " + party + "    Home County : " + homeCounty + "\n" +
                "-------------------------------------------------------------------------"+"\n";
    }
}
