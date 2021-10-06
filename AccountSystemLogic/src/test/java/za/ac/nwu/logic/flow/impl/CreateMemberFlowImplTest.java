package za.ac.nwu.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.translator.MemberAccountTypeTranslator;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateMemberFlowImplTest {
    @Mock
 private MemberAccountTypeTranslator translator;
    @InjectMocks
 private CreateMemberAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
        translator = Mockito.mock(MemberAccountTypeTranslator.class);
        flow = new CreateMemberAccountTypeFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        doThrow(new RuntimeException()).when(translator).someMethod();

        newMethod();

        verify(translator,times(2)).someMethod();
        verify(translator,never()).create(any(MemberAccountTypeDto.class));
    }

    private void newMethod() {
        try {
            flow.create(new MemberAccountTypeDto());
            fail("Should throw an exception");
        }catch (Exception e){

        }
    }
}