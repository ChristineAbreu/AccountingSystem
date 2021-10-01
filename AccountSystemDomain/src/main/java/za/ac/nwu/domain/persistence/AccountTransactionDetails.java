package za.ac.nwu.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT_TX_DETAILS", schema = "VITRSA_SANDBOX")
public class AccountTransactionDetails implements Serializable {

    private static final long serialVersionUID = 4562890339977033624L;

    Long accountTransactionDetailsId;
    AccountTransaction accountTransaction;
    String partnerName;
    Long numberOfItems;


@Id
@SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "VITRSA_SANDBOX.ACCOUNT_SEQ",allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACCOUNT_SEQ")
@Column(name = "ACCOUNT_TX_DETAILS_ID")
public Long getAccountTransactionDetailsId(){ return accountTransactionDetailsId;}

//@OneToOne (fetch = FetchType.LAZY)
@JoinColumn(name = "TX_ID")
public AccountTransaction getAccountTransaction(){return accountTransaction; }

@Column(name = "PARTNER_NAME")
public String getPartnerName() {return partnerName;}

@Column(name = "NUMBER_OF_ITEMS")
public Long getNumberOfItems() {return numberOfItems;}

public  AccountTransactionDetails(){

}
public  AccountTransactionDetails(AccountTransaction accountTransaction, String partnerName,Long numberOfItems){
  this.accountTransaction = accountTransaction;
  this.partnerName = partnerName;
  this.numberOfItems = numberOfItems;
}

    public  AccountTransactionDetails(String partnerName,Long numberOfItems){
        this.partnerName = partnerName;
        this.numberOfItems = numberOfItems;
    }

    public void setPartnerName(String partnerName){ this.partnerName = partnerName;}

public void setAccountTransaction(AccountTransaction accountTransaction){

}

    public void setAccountTransactionDetailsId(Long accountTransactionDetailsId) {
        this.accountTransactionDetailsId = accountTransactionDetailsId;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}