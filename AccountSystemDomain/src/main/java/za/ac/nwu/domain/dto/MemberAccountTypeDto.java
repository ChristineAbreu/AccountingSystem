package za.ac.nwu.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Member", description = "A DTO that represents the Member")
public class MemberAccountTypeDto implements Serializable {
    private static final long serialVersionUID = -534653206480289868L;

    public String mnemonic;
    public Object currencyTypeName;
    private String accountTypeName;
private LocalDate creationDate;

    public MemberAccountTypeDto(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public MemberAccountTypeDto(Member member) {
        this.setMnemonic(member.getMnemonic());
        this.setAccountTypeName(member.getAccountTypeName());
        this.setCreationDate(member.getCreationDate());
    }

    public MemberAccountTypeDto(MemberAccountTypeDto accountType) {
    }

    public MemberAccountTypeDto() {

    }


    @ApiModelProperty(position = 1,
            value = "Member Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
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
            value = "Member Name",
            name = "Name",
            notes = "The name of the Member",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
    @ApiModelProperty(position = 3,
            value = "Member Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the Member was created",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true,
            required = true)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAccountTypeDto that = (MemberAccountTypeDto) o;
        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

@JsonIgnore
public Member getAccountType() {
return  new Member(getMnemonic(),getAccountTypeName(),getCreationDate());
}

    @Override
    public int hashCode() {
        return Objects.hash(mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "MemberAccountTypeDto{" +
                "mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }


}
