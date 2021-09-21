package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoliticanNodeTest {
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
     * Getting Contents
     */

    @Test
    void getContents() {
    pl.addPolitican(pol1);
    assertEquals(pol1, pl.head.getContents());

    pl.addPolitican(pol2);
    assertEquals(pol2, pl.head.getContents());

    pl.addPolitican(pol3);
    assertEquals(pol3, pl.head.getContents());
    }

}