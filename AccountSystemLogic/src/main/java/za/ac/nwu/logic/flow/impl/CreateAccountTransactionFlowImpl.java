package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTransactionDto;
import za.ac.nwu.domain.persistence.AccountTransaction;
import za.ac.nwu.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.translator.AccountTransactionDetailsTranslator;
import za.ac.nwu.translator.impl.AccountTransactionTranslator;

@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final AccountTransactionDetailsTranslator accountTransactionDetailsTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;


    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            AccountTransactionDetailsTranslator accountTransactionDetailsTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTransactionDetailsTranslator = accountTransactionDetailsTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {
        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);

        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);

        if (null != accountTransactionDto.getDetails()) {
            AccountTransactionDetails accountTransactionDetails = accountTransactionDto.getDetails().buildAccountTransactionDetails(createdAccountTransaction);
            accountTransactionDetailsTranslator.save(accountTransactionDetails);
        }
        return accountTransactionDto;
    }

}


