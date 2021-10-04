package za.ac.nwu.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchMemberAccountTypeImplTest {
    private FetchMemberAccountTypeImpl testClass;
    @Before
    void setUp() {
        testClass = new FetchMemberAccountTypeImpl(null);
    }

    @After
    void tearDown() {
        testClass = null;
    }

    @Test
    void methodToTest() {
        assertTrue(testClass.methodToTest());
    }
}