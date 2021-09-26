package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.AccountTransactionDetails;

import java.io.Serializable;

public class AccountTransactionDto implements Serializable {



    private Long transactionId;
    private Long accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private Long transactionDate;
    private AccountTransactionDetailsDto details;

    public AccountTransactionDto(){

    }

    public AccountTransactionDto(Long transactionId, Long accountTypeMnemonic, Long memberId, Long amount, Long transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(Long transactionId, Long accountTypeMnemonic, Long memberId, Long amount, Long transactionDate,String details) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

}
