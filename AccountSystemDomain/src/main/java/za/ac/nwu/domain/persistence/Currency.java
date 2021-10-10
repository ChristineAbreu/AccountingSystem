package za.ac.nwu.domain.persistence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "CURRENCY_TYPE", schema = "CHRISTINE")
public class Currency implements Serializable{


    @SequenceGenerator(name = "CHRISTINE_GENERIC_SEQ", sequenceName = "CHRISTINE.VIT_RSA_GENERIC_SEQ", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    private Long currencyTypeId;
    private String mnemonic;
    private String currencyTypeName;
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Set<Currency> currencies;

    @ManyToOne
    @JoinColumn(name = "currency_type_id")
    private Currency currency;


    public Currency(String mnemonic, String currencyTypeName, Long currencyTypeId) {

    }

    public Currency(String mnemonic, String currencyTypeName) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Currency(Long currencyTypeId, String mnemonic, String currencyTypeName) {
        this.currencyTypeId = currencyTypeId;
        this.mnemonic = mnemonic;
        this.currencyTypeName = currencyTypeName;
    }

    public Currency() {
    }
    @Column(name = "CURRENCY_TYPE_ID")
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

    @Column(name = "CURRENCY_TYPE_NAME")
    public String getCurrencyTypeName() {
        return currencyTypeName;
    }
    public void setCurrencyTypeName(String currencyTypeName) {
        this.currencyTypeName = currencyTypeName;
    }



@OneToMany(targetEntity = Currency.class, fetch = FetchType.LAZY, mappedBy = "currency", orphanRemoval = true, cascade = CascadeType.PERSIST)
public Set<Currency> getCurrencies(){
       return currencies;
}


 public void setCurrencyTransactions(Set<Currency> currencies){
       this.currencies = currencies;
 }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency that = (Currency) o;
        return Objects.equals(currencyTypeId, that.currencyTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(currencyTypeName, that.currencyTypeName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyTypeId, mnemonic, currencyTypeName);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyTypeId=" + currencyTypeId +
                ", mnemonic=" + mnemonic +
                ", currencyTypeName=" + currencyTypeName +
                '}';
    }
}