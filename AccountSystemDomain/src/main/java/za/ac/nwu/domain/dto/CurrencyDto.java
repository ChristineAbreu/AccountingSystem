package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.Currency;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Currency", description = "A DTO that represents the Currency")
public class CurrencyDto implements Serializable {
    private String mnemonic;
    private String currencyTypeName;

    public CurrencyDto(String mnemonic, String currencyTypeName) {
        this.mnemonic = mnemonic;
        this.currencyTypeName = currencyTypeName;
    }

    public CurrencyDto(Currency currency) {
        this.setMnemonic(currency.getMnemonic());
        this.setCurrencyTypeName(currency.getCurrencyTypeName());
    }

    public CurrencyDto(CurrencyDto currencyType) {
    }

    private void setCurrencyTypeName(String currencyTypeName) {
    }


    public CurrencyDto(String miles) {
    }


    @ApiModelProperty(position = 1,
            value = "CurrencyDto Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the currency type",
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
            value = "Currency Name",
            name = "Name",
            notes = "The name of the Currency",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getCurrencyTypeName() {
        return currencyTypeName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyDto that = (CurrencyDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(currencyTypeName, that.currencyTypeName);
    }

    @JsonIgnore
    public Currency getCurrencyType() {
        return new Currency(getMnemonic(), getCurrencyTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, currencyTypeName);
    }

    @Override
    public String toString() {
        return "CurrencyTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", currencyTypeName='" + currencyTypeName + '\'' +
                '}';
    }
}



