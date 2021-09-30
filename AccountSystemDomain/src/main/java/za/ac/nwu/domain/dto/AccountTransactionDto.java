package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.AccountTransaction;
import za.ac.nwu.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountTransactionDto implements Serializable {



    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;
    private AccountTransactionDetailsDto details;
    public Throwable outputForLogging;




    public AccountTransactionDto() {

    }

    public AccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate, AccountTransactionDetailsDto details) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public AccountTransactionDto(AccountTransaction createdAccountTransaction) {
    }

    public AccountTransaction AccountTransactionDto(AccountTransaction accountTransaction, AccountType accountType) {
        this.transactionId = accountTransaction.getTransactionId();
       // this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
        if(null != accountTransaction.getDetails()){
            return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(),
                    this.getAmount(), this.getTransactionDate());
        }
        return accountTransaction;
    }

    private LocalDate getTransactionDate() {return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    private Long getAmount() {return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    private Long getMemberId() { return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    private Long getTransactionId() { return transactionId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }


    public AccountTransactionDetailsDto getDetails() {
        return details;
    }

    public AccountTransaction buildAccountTransaction(AccountType accountType) {
        return new AccountTransaction(this.getTransactionId(),accountType,this.getMemberId(),this.getAmount(),this.getTransactionDate());
    }



    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }
}