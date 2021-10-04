package za.ac.nwu.web.sb.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.logic.flow.CreateMemberAccountTypeFlow;
import za.ac.nwu.logic.flow.FetchMemberAccountTypeFlow;
import za.ac.nwu.logic.flow.ModifyMemberAccountTypeFlow;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerTest {
    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TYPE_CONTROLLER_URL = APP_URL +
            "/account-type";
    @Mock
    private FetchMemberAccountTypeFlow fetchMemberAccountTypeFlow;
    @Mock
    private CreateMemberAccountTypeFlow createMemberAccountTypeFlow;
    @Mock
    private ModifyMemberAccountTypeFlow modifyMemberAccountTypeFlow;
    @InjectMocks
    private DemoController controller;
    private MockMvc mockMvc;
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[" +
              "{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles account type\",\"creationDate\":[2020,1,1]}," +
               "{\"mnemonic\":\"PLAY\",\"accountTypeName\":\"Play account type\",\"creationDate\":[2021,4,1]}]}";
        List<MemberAccountTypeDto> accountTypes = new ArrayList<>();
       accountTypes.add(new MemberAccountTypeDto("MILES", "Miles account type",
                LocalDate.parse("2020-01-01")));
       accountTypes.add(new MemberAccountTypeDto("PLAY", "Play account type",
                LocalDate.parse("2021-04-01")));

        when(fetchMemberAccountTypeFlow.getAllAccountTypes()).thenReturn(accountTypes);
        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_TYPE_CONTROLLER_URL, "all")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(fetchMemberAccountTypeFlow, times(1)).getAllAccountTypes();
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void create() throws Exception {
        String accountTypeToBeCreated =
                "{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles account type\",\"creationDate\":[2020,1,1]},";
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"mnemonic\":\"MILES\",\"accountTypeName\":\"Miles account type\",\"creationDate\":[2020,1,1]}}";

        MemberAccountTypeDto accountType = new MemberAccountTypeDto("MILES", "Miles account type", LocalDate.parse("2020-01-01"));

                when(createMemberAccountTypeFlow.create(eq(accountType))).then(returnsFirstArg());
        MvcResult mvcResult =
                mockMvc.perform(post(ACCOUNT_TYPE_CONTROLLER_URL)
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(accountTypeToBeCreated)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andReturn();
        verify(createMemberAccountTypeFlow, times(1)).create(eq(accountType));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void deleteAccountType() throws Exception {
        String expectedResponse =
                "{\"successful\":true,\"payload\":" +
                        "{\"mnemonic\":\"PLAY\",\"accountTypeName\":\"Play account type\",\"creationDate\":[2020,4,1]}}";

        MemberAccountTypeDto accountType = new MemberAccountTypeDto("PLAY", "Play account type", LocalDate.parse("2021-04-01"));

                when(modifyMemberAccountTypeFlow.deleteAccountType(anyString())).thenReturn(accountType);
        MvcResult mvcResult = mockMvc.perform(delete((String.format("%s/%s",
                        ACCOUNT_TYPE_CONTROLLER_URL, "PLAY")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(modifyMemberAccountTypeFlow,
                times(1)).deleteAccountType(eq("PLAY"));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void updateAccountType() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"mnemonic\":\"PLAY\",\"accountTypeName\":\"The new Play account type name\",\"creationDate\":[2021,4,1]}}";
        MemberAccountTypeDto accountType = new MemberAccountTypeDto("PLAY", "The new Play account type name",
                LocalDate.parse("2021-04-01"));
        when(modifyMemberAccountTypeFlow.updateAccountType(anyString(),
                anyString(), any(LocalDate.class))).thenReturn(accountType);
        MvcResult mvcResult = mockMvc.perform(put((String.format("%s/%s",
                ACCOUNT_TYPE_CONTROLLER_URL, "PLAY")))
                .param("newAccountTypeName", "The new Play account type name")
                                .param("newCreationDate", "2021-04-01")
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(modifyMemberAccountTypeFlow,
                times(1)).updateAccountType(eq("PLAY"),
                eq("The new Play account type name"),
                eq(LocalDate.parse("2021-04-01")));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void updateAccountTypeWithNoOptionalDate() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":" +
                "{\"mnemonic\":\"PLAY\",\"accountTypeName\":\"The new Play account type name\",\"creationDate\":[2021,9,1]}}";
        MemberAccountTypeDto accountType = new MemberAccountTypeDto("PLAY", "The new Play account type name",
                LocalDate.parse("2021-09-01"));
        when(modifyMemberAccountTypeFlow.updateAccountType(anyString(),
                anyString(), isNull())).thenReturn(accountType);
        MvcResult mvcResult = mockMvc.perform(put((String.format("%s/%s",
                ACCOUNT_TYPE_CONTROLLER_URL, "PLAY")))
                .param("newAccountTypeName", "The new Play account type name")
                                .servletPath(APP_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        verify(modifyMemberAccountTypeFlow,
                times(1)).updateAccountType(eq("PLAY"),
                eq("The new Play account type name"), eq(null));
        assertEquals(expectedResponse,
                mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void updateAccountTypeObitMandatory() throws Exception {
        mockMvc.perform(put((String.format("%s/%s",
                ACCOUNT_TYPE_CONTROLLER_URL, "PLAY")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
        verify(modifyMemberAccountTypeFlow,
                never()).updateAccountType(anyString(), anyString(), any(LocalDate.class));
        verify(modifyMemberAccountTypeFlow,
                never()).updateAccountType(anyString(), anyString(), isNull());
        verify(modifyMemberAccountTypeFlow,
                never()).updateAccountType(anyString(), isNull(), isNull());
    }
}