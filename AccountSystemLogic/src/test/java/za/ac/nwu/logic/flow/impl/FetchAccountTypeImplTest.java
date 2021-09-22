package za.ac.nwu.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchAccountTypeImplTest {
    private FetchAccountTypeImpl testClass;
    @Before
    void setUp() {
        testClass = new FetchAccountTypeImpl(null);
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