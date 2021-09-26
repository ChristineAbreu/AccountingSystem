package za.ac.nwu.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.translator.AccountTypeTranslator;
import za.ac.nwu.logic.flow.CreateAccountTypeFlow;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {
    @Mock
 private AccountTypeTranslator translator;
    @InjectMocks
 private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(AccountTypeTranslator.class);
        flow = new CreateAccountTypeFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        doThrow(new RuntimeException()).when(translator).someMethod();

        newMethod();

        verify(translator,times(2)).someMethod();
        verify(translator,never()).create(any(AccountTypeDto.class));
    }

    private void newMethod() {
        try {
            flow.create(new AccountTypeDto());
            fail("Should throw an exception");
        }catch (Exception e){

        }
    }
}