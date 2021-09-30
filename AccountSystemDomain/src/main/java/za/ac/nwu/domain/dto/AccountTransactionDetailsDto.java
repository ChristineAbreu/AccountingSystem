package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.domain.persistence.AccountTransaction;
import za.ac.nwu.domain.persistence.AccountTransactionDetails;

public class AccountTransactionDetailsDto {
    String partnerName;
    Long numberOfItems;


    public AccountTransactionDetailsDto() {

    }

    public AccountTransactionDetailsDto(String partnerName, Long numberOfItems) {
this.partnerName = partnerName;
this.numberOfItems = numberOfItems;
    }

    public  AccountTransactionDetailsDto(AccountTransactionDetails details){
        this.partnerName = details.getPartnerName();
        this.numberOfItems = details.getNumberOfItems();
    }

    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(AccountTransaction accountTransaction){
       return new AccountTransactionDetails(this.partnerName, this.numberOfItems);
    }
    @JsonIgnore
    public AccountTransactionDetails buildAccountTransactionDetails(){
        return new AccountTransactionDetails(this.partnerName, this.numberOfItems);
    }

    public  String getPartnerName(){return partnerName;}

    public  void setPartnerName(String partnerName){this.partnerName = partnerName;}

    public Long getNumberOfItems(){return numberOfItems;}

    public void setNumberOfItems(Long numberOfItems) {this.numberOfItems = numberOfItems;}
}

