package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.persistence.Partner;


import java.util.List;
import java.util.Optional;


@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    //native queries is not recommended
    @Query(value = "SELECT"+
            "at"+
            "FROM"+
            "Partner at"+
            "MNEMONIC"+
            "WHERE MNEMONIC = :mnemonic")
    Partner getPartnerTypeByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.PartnerDto("+
            "at.mnemonic,"+
            "at.partnerTypeName,"+
            "FROM"+
            "Partner at"+
            "WHERE at. mnemonic =: mnemonic")
    Partner getPartnerTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.PartnerDto(" +
            "at.mnemonic," +
            "at.partnerTypeName," +
            "FROM" +
            "Partner at" +
            "WHERE at. mnemonic =: mnemonic")
    PartnerDto getPartnerDtoByMnemonic(String mnemonic);

    @Override
    Optional<Partner> findById(Long aLong);


    List<Partner> findAll();


}
