package za.ac.nwu.domain.persistence;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "VITRSA_SANDBOX")
public class MemberAccountTransaction implements Serializable{


    private static final long serialVersionUID = -1420294317019175740L;


    private Long transactionId;
    private Long currencyType;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    //@ManyToOne
    @JoinColumn(name = "details_account_tx_details_id")
    private MemberAccountTransactionDetails details;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private MemberAccountType memberAccountType;


    public MemberAccountTransaction(){

}
    public MemberAccountTransaction(Long transactionId, Long currencyType, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.currencyType = currencyType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public MemberAccountTransaction(Long transactionId, CurrencyType currencyType, Long memberId, Long amount, LocalDate transactionDate) {

    }

    public MemberAccountTransaction(Long transactionId, MemberAccountType memberAccountType, Long memberId, Long amount, LocalDate transactionDate) {
    }


    @Id
@SequenceGenerator(name = "GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.GENERIC_SEQ",allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")
    @Column(name = "TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

//@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn (name = "CURRENCY_TYPE_ID")
    public Long getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Long currencyType) {
        this.currencyType = currencyType;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountTransaction that = (MemberAccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(currencyType, that.currencyType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, currencyType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "MemberAccountTransaction{" +
                "transactionId=" + transactionId +
                ", memberAccountType=" + currencyType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}





