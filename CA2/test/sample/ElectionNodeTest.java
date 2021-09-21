package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectionNodeTest {
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
     * Test tear down
     */

    @AfterEach
    void tearDown() {
        election1=election2=election3=null;
    }

    /**
     * Getting Contents
     */

    @Test
    void getContents() {
        el.addElection(election1);
        assertEquals(election1,el.head.getContents());
        el.addElection(election2);
        assertEquals(election2,el.head.getContents());
        el.addElection(election3);
        assertEquals(election3,el.head.getContents());

    }

}