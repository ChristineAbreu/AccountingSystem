package za.ac.nwu.repo.persistence;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.persistence.Partner;

import java.util.List;
import java.util.Optional;

public class PartnerRepositoryImpl implements PartnerRepository {
    @Query(value = "SELECT" +
            "PARTNER_TYPE_ID," +
            "PARTNER_TYPE_NAME," +
            "MNEMONIC" +
            "FROM" + "VITRSA_SANDBOX_PARTNER_TYPE" +
            "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    public Partner getPartnerTypeByMnemonicNativeQuery(String mnemonic) {
        return null;
    }

    @Override
    public Partner getPartnerTypeByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public Optional<Partner> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Partner> findAll() {
        return null;
    }

    @Override
    public List<Partner> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Partner> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Partner> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Partner entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Partner> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Partner> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Partner> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Partner> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Partner> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Partner getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Partner> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Partner> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Partner> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Partner> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Partner> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Partner> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public PartnerDto getPartnerDtoByMnemonic(String mnemonic) {
        return null;
    }
}
