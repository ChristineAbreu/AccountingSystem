package za.ac.nwu.domain.persistence;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.ac.nwu.domain.dto.CurrencyDto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "CURRENCY_TYPE", schema = "VITRSA_SANDBOX")
public class CurrencyType implements Serializable{


    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    private Long currencyTypeId;
    private String mnemonic;
    private String currencyTypeName;
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Set<AccountTransaction> AccountTransactions;


    public CurrencyType(String mnemonic, String currencyTypeName, Long currencyTypeId) {

    }

    public CurrencyType(String mnemonic, String currencyTypeName) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public CurrencyType(Long currencyTypeId, String mnemonic, String currencyTypeName) {
        this.currencyTypeId = currencyTypeId;
        this.mnemonic = mnemonic;
        this.currencyTypeName = currencyTypeName;
    }

    public CurrencyType() {
    }
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getCurrencyTypeId() {
        return currencyTypeId;
    }
    public void setCurrencyTypeId(Long currencyTypeId) {
        this.currencyTypeId = currencyTypeId;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getCurrencyTypeName() {
        return currencyTypeName;
    }
    public void setCurrencyTypeName(String currencyTypeName) {
        this.currencyTypeName = currencyTypeName;
    }



@OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "currencyType", orphanRemoval = true, cascade = CascadeType.PERSIST)
public Set<AccountTransaction> getAccountTransactions(){
       return AccountTransactions;
}


 public void setAccountTransactions(Set<AccountTransaction> accountTransactions){
       this.AccountTransactions = accountTransactions;
 }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyType that = (CurrencyType) o;
        return Objects.equals(currencyTypeId, that.currencyTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(currencyTypeName, that.currencyTypeName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyTypeId, mnemonic, currencyTypeName);
    }

    @Override
    public String toString() {
        return "CurrencyType{" +
                "currencyTypeId=" + currencyTypeId +
                ", mnemonic=" + mnemonic +
                ", currencyTypeName=" + currencyTypeName +
                '}';
    }
}