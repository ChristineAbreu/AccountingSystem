package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.PartnerType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "PartnerType", description = "A DTO that represents the PartnerType")
public class PartnerDto implements Serializable {
    private String mnemonic;
    private String partnerName;

    public PartnerDto(String mnemonic, String partnerName) {
        this.mnemonic = mnemonic;
        this.partnerName = partnerName;
    }

    public PartnerDto(PartnerType partnerType) {
        this.setMnemonic(partnerType.getMnemonic());
        this.setPartnerName(partnerType.getPartnerName());
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
            value = "PartnerType Name",
            name = "Name",
            notes = "The name of the PartnerType",
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
    public PartnerType getPartnerType() {
        return new PartnerType(getMnemonic(), getPartnerName());
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
