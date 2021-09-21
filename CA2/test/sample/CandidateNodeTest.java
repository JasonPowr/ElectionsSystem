package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateNodeTest {
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
     * Test tear down
     */

    @AfterEach
    void tearDown() {
        candidate1=candidate2=null;
    }

    /**
     * Getting Contents
     */

    @Test
    void getContents() {
        cl.addCandidate(candidate1);
        assertEquals(candidate1,cl.head.getContents());
        cl.addCandidate(candidate2);
        assertEquals(candidate2,cl.head.getContents());

    }


}