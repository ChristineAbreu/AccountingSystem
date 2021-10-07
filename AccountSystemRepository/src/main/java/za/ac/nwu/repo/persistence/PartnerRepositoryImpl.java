package za.ac.nwu.repo.persistence;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.persistence.PartnerType;

import java.util.List;
import java.util.Optional;

public class PartnerRepositoryImpl implements PartnerRepository {
    @Query(value = "SELECT" +
            "PARTNER_TYPE_ID," +
            "PARTNER_TYPE_NAME," +
            "MNEMONIC" +
            "FROM" + "VITRSA_SANDBOX_PARTNER_TYPE" +
            "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    public PartnerType getPartnerTypeByMnemonicNativeQuery(String mnemonic) {
        return null;
    }

    @Override
    public PartnerType getPartnerTypeByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public Optional<PartnerType> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<PartnerType> findAll() {
        return null;
    }

    @Override
    public List<PartnerType> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PartnerType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PartnerType> findAllById(Iterable<Long> longs) {
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
    public void delete(PartnerType entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends PartnerType> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PartnerType> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PartnerType> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PartnerType> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<PartnerType> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PartnerType getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends PartnerType> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PartnerType> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PartnerType> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PartnerType> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PartnerType> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PartnerType> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public PartnerDto getPartnerDtoByMnemonic(String mnemonic) {
        return null;
    }
}
