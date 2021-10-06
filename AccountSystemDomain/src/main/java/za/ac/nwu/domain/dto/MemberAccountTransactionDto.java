package za.ac.nwu.domain.dto;

import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;

public class MemberAccountTransactionDto implements Serializable {



    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;
    private MemberAccountTransactionDetailsDto details;
    public Throwable outputForLogging;




    public MemberAccountTransactionDto() {

    }

    public MemberAccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public MemberAccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate, MemberAccountTransactionDetailsDto details) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public MemberAccountTransactionDto(MemberAccountTransaction createdMemberAccountTransaction) {
    }

    public MemberAccountTransaction AccountTransactionDto(MemberAccountTransaction memberAccountTransaction, Member member) {
        this.transactionId = memberAccountTransaction.getTransactionId();
       // this.accountTypeMnemonic = memberAccountTransaction.getMember().getMnemonic();
        this.memberId = memberAccountTransaction.getMemberId();
        this.amount = memberAccountTransaction.getAmount();
        this.transactionDate = memberAccountTransaction.getTransactionDate();
        if(null != memberAccountTransaction.getDetails()){
            return new MemberAccountTransaction(this.getTransactionId(), member, this.getMemberId(),
                    this.getAmount(), this.getTransactionDate());
        }
        return memberAccountTransaction;
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


    public MemberAccountTransactionDetailsDto getDetails() {
        return details;
    }

    public MemberAccountTransaction buildAccountTransaction(Member member) {
        return new MemberAccountTransaction(this.getTransactionId(), member,this.getMemberId(),this.getAmount(),this.getTransactionDate());
    }



    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public String getAccountTypeMnemonic() {
        return accountTypeMnemonic;
    }
}