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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

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
        Mockito.when(translator.create(any(AccountTypeDto.class))).thenReturn(null);
        flow.create(new AccountTypeDto());
    }
}