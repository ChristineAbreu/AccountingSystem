package za.ac.nwu.translator.impl;

import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.repo.persistence.MemberAccountTransactionRepository;
import za.ac.nwu.translator.MemberAccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

public class MemberAccountTransactionTranslatorImpl implements MemberAccountTransactionTranslator {
 private MemberAccountTransactionRepository repo;

 public MemberAccountTransactionTranslatorImpl(MemberAccountTransactionRepository memberAccountTransactionRepository) {
 this.repo = memberAccountTransactionRepository;

 }

    @Override
    public MemberAccountTransaction save(MemberAccountTransaction memberAccountTransaction){
        try{
            return repo.save(memberAccountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB",e);
        }
    }


@Override
public List<MemberAccountTransaction> getAllAccountTransactions(){
    List<MemberAccountTransaction> memberAccountTransactions;
    try {
        memberAccountTransactions = new ArrayList<>(repo.findAll());
    }catch (Exception e) {

    throw new RuntimeException("Unable to read from the DB",e);
    }
    return memberAccountTransactions;
}

    @Override
    public MemberAccountTransaction getAccountTransactionByPk(Long transactionId) {
      try{
          return  repo.findById(transactionId).orElse(null);
    }catch (Exception e){
          throw new RuntimeException("Unable to read from the DB", e);
      }

}
}
