package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.MemberAccountTransactionDetails;

public class MemberAccountTransactionDetailsDto {
    String partnerName;
    Long numberOfItems;


    public MemberAccountTransactionDetailsDto() {

    }

    public MemberAccountTransactionDetailsDto(String partnerName, Long numberOfItems) {
this.partnerName = partnerName;
this.numberOfItems = numberOfItems;
    }

    public MemberAccountTransactionDetailsDto(MemberAccountTransactionDetails details){
        this.partnerName = details.getPartnerName();
        this.numberOfItems = details.getNumberOfItems();
    }

    @JsonIgnore
    public MemberAccountTransactionDetails buildAccountTransactionDetails(MemberAccountTransaction memberAccountTransaction){
       return new MemberAccountTransactionDetails(this.partnerName, this.numberOfItems);
    }
    @JsonIgnore
    public MemberAccountTransactionDetails buildAccountTransactionDetails(){
        return new MemberAccountTransactionDetails(this.partnerName, this.numberOfItems);
    }

    public  String getPartnerName(){return partnerName;}

    public  void setPartnerName(String partnerName){this.partnerName = partnerName;}

    public Long getNumberOfItems(){return numberOfItems;}

    public void setNumberOfItems(Long numberOfItems) {this.numberOfItems = numberOfItems;}
}

