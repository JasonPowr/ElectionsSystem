package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectionListTest {
    public ElectionList el = new ElectionList();
    public Election election1,election2,election3;

    /**
     * Test Setup
     */

    @BeforeEach
    void setUp() {
        election1 = new Election("1","Local","Waterford","18/06/2020","8");
        election2 = new Election("2","General","Cork","19/4/2021","7");
        election3 = new Election("3","European","Dublin","06/5/2020","6");
    }

    /**
     * Setup tear down
     */

    @AfterEach
    void tearDown() {
        election1=election2=election3=null;
    }

    /**
     * Add Election Test
     */

    @Test
    void addElection() {
        el.addElection(election1);
        el.addElection(election2);
        el.addElection(election3);

        assertEquals(3,el.numberOfElections());
    }

    /**
     * List Elections Test
     */

    @Test
    void listElections() {
        el.addElection(election1);
        el.addElection(election2);
        el.addElection(election3);

        assertEquals("Election ID : 3    Type : European    Location : Dublin    Year/Date : 06/5/2020    Seats : 6\n" +
                "-------------------------------------------------------------------------\n" +
                "Election ID : 2    Type : General    Location : Cork    Year/Date : 19/4/2021    Seats : 7\n" +
                "-------------------------------------------------------------------------\n" +
                "Election ID : 1    Type : Local    Location : Waterford    Year/Date : 18/06/2020    Seats : 8\n" +
                "-------------------------------------------------------------------------\n",el.listElections());
    }

    /**
     * Number of Elections Test
     */

    @Test
    void numberOfElections() {
        el.addElection(election1);
        el.addElection(election2);
        el.addElection(election3);

        assertEquals(3,el.numberOfElections());
    }

    /**
     * Find Elections Test
     */

    @Test
    void findElections() {
        el.addElection(election1);
        el.addElection(election2);
        el.addElection(election3);

        assertEquals(election1,el.findElections("1"));
        assertEquals(election2,el.findElections("2"));
        assertEquals(election3,el.findElections("3"));
    }

    /**
     * Find Elections by Type Test
     */

    @Test
    void findElectionsByType() {
        el.addElection(election1);
        el.addElection(election2);
        el.addElection(election3);

        assertEquals("Election ID : 2    Type : General    Location : Cork    Year/Date : 19/4/2021    Seats : 7\n" +
                "-------------------------------------------------------------------------\n",el.findElectionsByType("General"));

        assertEquals("Election ID : 1    Type : Local    Location : Waterford    Year/Date : 18/06/2020    Seats : 8\n" +
                "-------------------------------------------------------------------------\n",el.findElectionsByType("Local"));

        assertEquals("Election ID : 3    Type : European    Location : Dublin    Year/Date : 06/5/2020    Seats : 6\n" +
                "-------------------------------------------------------------------------\n",el.findElectionsByType("European"));
    }

    /**
     * Find Election by Year Test
     */

    @Test
    void findElectionsByYear() {
        el.addElection(election1);
        el.addElection(election2);
        el.addElection(election3);

        assertEquals("Election ID : 2    Type : General    Location : Cork    Year/Date : 19/4/2021    Seats : 7\n" +
                "-------------------------------------------------------------------------\n",el.findElectionsByYear("19/4/2021"));

        assertEquals("Election ID : 1    Type : Local    Location : Waterford    Year/Date : 18/06/2020    Seats : 8\n" +
                "-------------------------------------------------------------------------\n",el.findElectionsByYear("18/06/2020"));

        assertEquals("Election ID : 3    Type : European    Location : Dublin    Year/Date : 06/5/2020    Seats : 6\n" +
                "-------------------------------------------------------------------------\n",el.findElectionsByYear("06/5/2020"));
    }

    /**
     * Delete Election Test
     */

    @Test
    void deleteElection() {
        el.addElection(election1);
        el.addElection(election2);
        el.addElection(election3);

        assertEquals(3,el.numberOfElections());
        el.deleteElection("1");
        assertEquals(2,el.numberOfElections());
        el.deleteElection("2");
        assertEquals(1,el.numberOfElections());
    }
}