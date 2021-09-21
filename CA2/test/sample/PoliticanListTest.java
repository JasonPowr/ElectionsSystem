package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliticanListTest {
    public PoliticanList pl = new PoliticanList();
    public Politican pol1, pol2, pol3;

    /**
     * Test Setup
     */

    @BeforeEach
    void setUp() {
        pol1 = new Politican("Finbar Shanahan","25/01/1978","Finna Fail","Waterford"){};
        pol2 = new Politican("Dermot Maguire","12/09/1986","Sinn Fein","Cork"){};
        pol3 = new Politican("Dermot Quinn","19/02/1972","Green Party","Dublin"){};
    }

    /**
     * Setup tear down
     */

    @AfterEach
    void tearDown() {
        pol1=pol2=pol3=null;
    }

    /**
     * Add Politician Test
     */

    @Test
    void addPolitican() {
        pl.addPolitican(pol1);
        pl.addPolitican(pol2);
        pl.addPolitican(pol3);

        assertEquals(3,pl.numberOfPoliticans());
    }

    /**
     * List Politicians Test
     */

    @Test
    void listPoliticians() {
        pl.addPolitican(pol1);
        pl.addPolitican(pol2);
        pl.addPolitican(pol3);

        assertEquals("Name : Dermot Quinn    DOB : 19/02/1972    Political Party : Green Party    Home County : Dublin\n" +
                "-------------------------------------------------------------------------\n" +
                "Name : Dermot Maguire    DOB : 12/09/1986    Political Party : Sinn Fein    Home County : Cork\n" +
                "-------------------------------------------------------------------------\n" +
                "Name : Finbar Shanahan    DOB : 25/01/1978    Political Party : Finna Fail    Home County : Waterford\n" +
                "-------------------------------------------------------------------------\n",pl.listPoliticians());
    }

    /**
     * Find Politicians by Party Test
     */

    @Test
    void findPoliticiansByParty() {
        pl.addPolitican(pol1);
        pl.addPolitican(pol2);
        pl.addPolitican(pol3);

        assertEquals("Name : Dermot Quinn    DOB : 19/02/1972    Political Party : Green Party    Home County : Dublin\n" +
                "-------------------------------------------------------------------------\n",pl.findPoliticiansByParty("Green Party"));

        assertEquals("Name : Dermot Maguire    DOB : 12/09/1986    Political Party : Sinn Fein    Home County : Cork\n" +
                "-------------------------------------------------------------------------\n",pl.findPoliticiansByParty("Sinn Fein"));

        assertEquals("Name : Finbar Shanahan    DOB : 25/01/1978    Political Party : Finna Fail    Home County : Waterford\n" +
                "-------------------------------------------------------------------------\n",pl.findPoliticiansByParty("Finna Fail"));
    }

    /**
     * Find Politicians by Location Test
     */

    @Test
    void findPoliticiansByLocation() {
        pl.addPolitican(pol1);
        pl.addPolitican(pol2);
        pl.addPolitican(pol3);

        assertEquals("Name : Dermot Quinn    DOB : 19/02/1972    Political Party : Green Party    Home County : Dublin\n" +
                "-------------------------------------------------------------------------\n",pl.findPoliticiansByLocation("Dublin"));

        assertEquals("Name : Dermot Maguire    DOB : 12/09/1986    Political Party : Sinn Fein    Home County : Cork\n" +
                "-------------------------------------------------------------------------\n",pl.findPoliticiansByLocation("Cork"));

        assertEquals("Name : Finbar Shanahan    DOB : 25/01/1978    Political Party : Finna Fail    Home County : Waterford\n" +
                "-------------------------------------------------------------------------\n",pl.findPoliticiansByLocation("Waterford"));
    }

    /**
     * Number of Politicians Test
     */

    @Test
    void numberOfPoliticans() {
        pl.addPolitican(pol1);
        pl.addPolitican(pol2);
        pl.addPolitican(pol3);

        assertEquals(3,pl.numberOfPoliticans());
    }

    /**
     * Find Politicians Test
     */

    @Test
    void findPoliticans() {
        pl.addPolitican(pol1);
        assertEquals(pol1,pl.findPoliticans("Finbar Shanahan"));

        pl.addPolitican(pol2);
        assertEquals(pol2,pl.findPoliticans("Dermot Maguire"));

        pl.addPolitican(pol3);
        assertEquals(pol3,pl.findPoliticans("Dermot Quinn"));

    }

    /**
     * Delete Politician Test
     */

    @Test
    void deletePolitican() {
        pl.addPolitican(pol1);
        pl.addPolitican(pol2);
        pl.addPolitican(pol3);

        assertEquals(3,pl.numberOfPoliticans());

        pl.deletePolitican("Finbar Shanahan");
        assertEquals(2,pl.numberOfPoliticans());

        pl.deletePolitican("Dermot Maguire");
        assertEquals(1,pl.numberOfPoliticans());

        pl.deletePolitican("Dermot Quinn");
        assertEquals(1,pl.numberOfPoliticans());


    }
}