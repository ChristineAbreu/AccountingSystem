package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.persistence.PartnerType;


import java.util.List;
import java.util.Optional;


@Repository
public interface PartnerRepository extends JpaRepository<PartnerType, Long> {

    //native queries is not recommended
    @Query(value = "SELECT" +
            "at" +
            "FROM" +
            "PartnerType at" +
            "MNEMONIC" +
            "WHERE MNEMONIC = :mnemonic")
    static PartnerType getPartnerTypeByMnemonicNativeQuery(String mnemonic) {
        return null;
    }

    @Query(value = "SELECT new za.ac.nwu.domain.dto.PartnerDto("+
            "at.mnemonic,"+
            "at.partnerTypeName,"+
            "FROM"+
            "PartnerType at"+
            "WHERE at. mnemonic =: mnemonic")
    PartnerType getPartnerTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.PartnerDto(" +
            "at.mnemonic," +
            "at.partnerTypeName," +
            "FROM" +
            "PartnerType at" +
            "WHERE at. mnemonic =: mnemonic")
    PartnerDto getPartnerDtoByMnemonic(String mnemonic);

    @Override
    Optional<PartnerType> findById(Long aLong);


    List<PartnerType> findAll();


}
