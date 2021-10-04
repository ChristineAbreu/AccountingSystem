package za.ac.nwu.translator;

import za.ac.nwu.domain.persistence.MemberAccountTransaction;

import java.util.List;

public interface MemberAccountTransactionTranslator {

    MemberAccountTransaction save(MemberAccountTransaction memberAccountTransaction);

    List<MemberAccountTransaction> getAllAccountTransactions();

    MemberAccountTransaction getAccountTransactionByPk(Long transactionId);

}
