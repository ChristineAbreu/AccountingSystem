package za.ac.nwu.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT_TX_DETAILS", schema = "CHRISTINE")
public class MemberAccountTransactionDetails implements Serializable {

    private static final long serialVersionUID = 4562890339977033624L;

    Long accountTransactionDetailsId;
    @ManyToOne
    @JoinColumn(name = "member_account_transaction_tx_id")
    MemberAccountTransaction memberAccountTransaction;
    String partnerName;
    Long numberOfItems;

    public MemberAccountTransaction getMemberAccountTransaction() {
        return memberAccountTransaction;
    }


    @Id
@SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "CHRISTINE.ACCOUNT_SEQ",allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ACCOUNT_SEQ")
@Column(name = "ACCOUNT_TX_DETAILS_ID")
public Long getAccountTransactionDetailsId(){ return accountTransactionDetailsId;}

//@OneToOne (fetch = FetchType.LAZY)
@JoinColumn(name = "TX_ID")
public MemberAccountTransaction getAccountTransaction(){return memberAccountTransaction; }

@Column(name = "PARTNER_NAME")
public String getPartnerName() {return partnerName;}

@Column(name = "NUMBER_OF_ITEMS")
public Long getNumberOfItems() {return numberOfItems;}

public MemberAccountTransactionDetails(){

}
public MemberAccountTransactionDetails(MemberAccountTransaction memberAccountTransaction, String partnerName, Long numberOfItems){
  this.memberAccountTransaction = memberAccountTransaction;
  this.partnerName = partnerName;
  this.numberOfItems = numberOfItems;
}

    public MemberAccountTransactionDetails(String partnerName, Long numberOfItems){
        this.partnerName = partnerName;
        this.numberOfItems = numberOfItems;
    }

    public void setPartnerName(String partnerName){ this.partnerName = partnerName;}

public void setAccountTransaction(MemberAccountTransaction memberAccountTransaction){

}

    public void setAccountTransactionDetailsId(Long accountTransactionDetailsId) {
        this.accountTransactionDetailsId = accountTransactionDetailsId;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}