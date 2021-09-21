package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateListTest {
    public CandidateList cl = new CandidateList();
    public Candidate candidate1,candidate2;

    /**
     * Test Setup
     */

    @BeforeEach
    void setUp() {
        candidate1 = new Candidate("Finbar Shanahan","25/01/1978","Finna Fail","Waterford",89);
        candidate2 = new Candidate("Dermot Maguire","12/09/1986","Sinn Fein","Cork",72);

    }

    /**
     * Tears down the setup
     */

    @AfterEach
    void tearDown() {
        candidate1=candidate2=null;
    }

    /**
     * Add Candidate Test
     */

    @Test
    void addCandidate() {
        cl.addCandidate(candidate1);
        cl.addCandidate(candidate2);

        assertEquals(2,cl.numberOfCandidates());
    }

    /**
     * Number of Candidates Test
     */

    @Test
    void numberOfCandidates() {
        cl.addCandidate(candidate1);
        assertEquals(1,cl.numberOfCandidates());

        cl.addCandidate(candidate2);

        assertEquals(2,cl.numberOfCandidates());
    }

    /**
     * List Candidates Test
     */

    @Test
    void listCandidates() {
        cl.addCandidate(candidate1);
        cl.addCandidate(candidate2);

        assertEquals("Name : Dermot Maguire    DOB : 12/09/1986    Political Party : Sinn Fein    Home County : Cork    Number of Votes : 72\n" +
                "----------------------------------------------------------------------------------\n" +
                "Name : Finbar Shanahan    DOB : 25/01/1978    Political Party : Finna Fail    Home County : Waterford    Number of Votes : 89\n" +
                "----------------------------------------------------------------------------------\n",cl.listCandidates());
    }

    /**
     * Delete Candidate Test
     */

    @Test
    void deleteCandidate() {
        cl.addCandidate(candidate1);
        cl.addCandidate(candidate2);
        assertEquals(2,cl.numberOfCandidates());
        cl.deleteCandidate("Finbar Shanahan");
    }

    }