  package za.ac.nwu.repo.persistence;
  import org.junit.After;
  import org.junit.Before;
  import org.junit.Test;
  import org.junit.runner.RunWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
  import org.springframework.test.context.ContextConfiguration;
  import org.springframework.test.context.junit4.SpringRunner;
  import za.ac.nwu.domain.dto.MemberAccountTypeDto;
  import za.ac.nwu.domain.persistence.Member;
  import za.ac.nwu.repo.config.RepositoryTestConfig;



  import static org.junit.Assert.*;
  @RunWith(SpringRunner.class)
  @DataJpaTest
  @ContextConfiguration(classes = {RepositoryTestConfig.class})
  public class MemberRepositoryTest {
      @Autowired
      MemberAccountTypeRepository memberAccountTypeRepository;
      @Before
      public void setUp() throws Exception {
       //    What happens before each test
      }
      @After
      public void tearDown() throws Exception {
        //   What happens after each test
      }
      @Test
      public void getAccountTypeByMnemonicNativeQueryMiles() {
          Member miles = memberAccountTypeRepository.getAccountTypeByMnemonicNativeQuery("MILES");
          assertNotNull(miles);
          assertEquals("MILES", miles.getMnemonic());
      }
  
      @Test
      public void getAccountTypeByMnemonicNativeQuery() {
          Member miles = memberAccountTypeRepository.getAccountTypeByMnemonicNativeQuery("MILESSSSS");
          assertNull(miles);
      }
  
      @Test
      public void getAccountTypeByMnemonicMiles() {
          Member miles = memberAccountTypeRepository.getAccountTypeByMnemonic("MILES");
          assertNotNull(miles);
          assertEquals("MILES", miles.getMnemonic());
      }
  
      @Test
      public void getAccountTypeByMnemonicPlay() {
          Member miles = memberAccountTypeRepository.getAccountTypeByMnemonic("PLAY");
          assertNotNull(miles);
          assertEquals("PLAY", miles.getMnemonic());
      }
  
      @Test
      public void getAccountTypeByMnemonic() {
          Member miles = memberAccountTypeRepository.getAccountTypeByMnemonicNativeQuery("R");
          assertNull(miles);
      }
  
      @Test
      public void getAccountTypeDtoByMnemonicMiles() {
          MemberAccountTypeDto miles = memberAccountTypeRepository.getAccountTypeDtoByMnemonic("MILES");
          assertNotNull(miles);
          assertEquals("MILES", miles.getMnemonic());
      }
  
      @Test
      public void getAccountTypeDtoByMnemonicPlay() {
          MemberAccountTypeDto miles = memberAccountTypeRepository.getAccountTypeDtoByMnemonic("PLAY");
          assertNotNull(miles);
          assertEquals("PLAY", miles.getMnemonic());
      }
  
      @Test
      public void getAccountTypeDtoByMnemonics() {
          MemberAccountTypeDto miles = memberAccountTypeRepository.getAccountTypeDtoByMnemonic("R");
          assertNull(miles);
      }
  
  
  
  }
  
  
