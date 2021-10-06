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
@Table(name = "PARTNER_TYPE", schema = "VITRSA_SANDBOX")
public class Partner implements Serializable{


    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    private Long partnerTypeId;
    private String mnemonic;
    private String partnerName;
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Set<Partner> partners;

    @ManyToOne
    @JoinColumn(name = "partner_type_id")
    private Partner partner;


    public Partner(String mnemonic, String partnerName, Long partnerTypeId) {

    }

    public Partner(String mnemonic, String partnerName) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Partner(Long partnerTypeId, String mnemonic, String partnerName) {
        this.partnerTypeId = partnerTypeId;
        this.mnemonic = mnemonic;
        this.partnerName = partnerName;
    }

    public Partner() {
    }
    @Column(name = "PARTNER_TYPE_ID")
    public Long getPartnerTypeId() {
        return partnerTypeId;
    }
    public void setPartnerTypeId(Long partnerTypeId) {
        this.partnerTypeId = partnerTypeId;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "PARTNER_TYPE_NAME")
    public String getPartnerName() {
        return partnerName;
    }
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }



    @OneToMany(targetEntity = Partner.class, fetch = FetchType.LAZY, mappedBy = "partner", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<Partner> getPartners(){
        return partners;
    }


    public void setPartners(Set<Partner> partners){
        this.partners = partners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partner that = (Partner) o;
        return Objects.equals(partnerTypeId, that.partnerTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(partnerName, that.partnerName) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partnerTypeId, mnemonic, partnerName);
    }

    @Override
    public String toString() {
        return "Partner{" +
                "partnerTypeId=" + partnerTypeId +
                ", mnemonic=" + mnemonic +
                ", partnerName=" + partnerName +
                '}';
    }



}