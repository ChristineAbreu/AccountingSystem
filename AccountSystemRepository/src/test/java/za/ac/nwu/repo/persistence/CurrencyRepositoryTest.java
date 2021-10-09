 package za.ac.nwu.repo.persistence;

 import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.SpringRunner;
 import za.ac.nwu.domain.dto.CurrencyDto;
 import za.ac.nwu.domain.persistence.Currency;
 import za.ac.nwu.repo.config.RepositoryTestConfig;

 import static org.junit.Assert.assertNotNull;
 import static org.junit.Assert.assertNull;

 @RunWith(SpringRunner.class)
 @DataJpaTest
 @ContextConfiguration(classes = {RepositoryTestConfig.class})
 public class CurrencyRepositoryTest {
     @Autowired
     CurrencyRepository currencyRepository;
     @Before
     public void setUp() throws Exception {
         // What happens before each test
     }
     @After
     public void tearDown() throws Exception {
        //  What happens after each test
     }
     @Test
     public void getCurrencyTypeByMnemonicNativeQueryMiles() {
         Currency miles = CurrencyRepository.getCurrencyTypeByMnemonicNativeQuery("MILES");
         assertNotNull(miles);
         assertEquals("MILES", miles.getMnemonic());
     }
 
     @Test
     public void getCurrencyTypeByMnemonicNativeQuery() {
         Currency miles = CurrencyRepository.getCurrencyTypeByMnemonicNativeQuery("MILESSSSS");
         assertNull(miles);
     }
 
     @Test
     public void getCurrencyTypeByMnemonicMiles() {
         Currency miles = currencyRepository.getCurrencyTypeByMnemonic("MILES");
         assertNotNull(miles);
         assertEquals("MILES", miles.getMnemonic());
     }
 
     @Test
     public void getCurrencyTypeByMnemonicPlay() {
         Currency miles = currencyRepository.getCurrencyTypeByMnemonic("PLAY");
         assertNotNull(miles);
         assertEquals("PLAY", miles.getMnemonic());
     }
 
     @Test
     public void getCurrencyTypeByMnemonic() {
         Currency miles =  CurrencyRepository.getCurrencyTypeByMnemonicNativeQuery("R");
         assertNull(miles);
     }
 
     @Test
     public void getCurrencyDtoByMnemonicMiles() {
         CurrencyDto miles = currencyRepository.getCurrencyDtoByMnemonic("MILES");
         assertNotNull(miles);
         assertEquals("MILES", miles.getMnemonic());
     }
 
     @Test
     public void getCurrencyDtoByMnemonicPlay() {
         CurrencyDto miles = currencyRepository.getCurrencyDtoByMnemonic("PLAY");
         assertNotNull(miles);
        assertEquals("PLAY", miles.getMnemonic());
    }

    @Test
    public void getCurrencyDtoByMnemonics() {
        CurrencyDto miles = currencyRepository.getCurrencyDtoByMnemonic("R");
       assertNull(miles);
   }



}