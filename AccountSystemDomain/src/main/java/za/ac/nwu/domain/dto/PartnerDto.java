package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.Partner;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Partner", description = "A DTO that represents the Partner")
public class PartnerDto implements Serializable {
    private String mnemonic;
    private String partnerName;

    public PartnerDto(String mnemonic, String partnerName) {
        this.mnemonic = mnemonic;
        this.partnerName = partnerName;
    }

    public PartnerDto(Partner partner) {
        this.setMnemonic(partner.getMnemonic());
        this.setPartnerName(partner.getPartnerName());
    }

    public PartnerDto(PartnerDto partnerType) {
    }

    private void setPartnerName(String partnerName) {
    }


    public PartnerDto(String miles) {
    }


    @ApiModelProperty(position = 1,
            value = "PartnerDto Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the Partner",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)

    public String getMnemonic() {
        return mnemonic;
    }


    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @ApiModelProperty(position = 2,
            value = "Partner Name",
            name = "Name",
            notes = "The name of the Partner",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getPartnerName() {
        return partnerName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartnerDto that = (PartnerDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(partnerName, that.partnerName);
    }

    @JsonIgnore
    public Partner getPartnerType() {
        return new Partner(getMnemonic(), getPartnerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, partnerName);
    }

    @Override
    public String toString() {
        return "PartnerDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", partnerName='" + partnerName + '\'' +
                '}';
    }
}
