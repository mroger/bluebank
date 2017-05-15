package br.com.bluebank.service;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.bluebank.model.Account;
import br.com.bluebank.model.AccountHolderId;
import br.com.bluebank.model.json.TransactionJson;
import br.com.bluebank.repository.AccountHolderRepository;
import br.com.bluebank.repository.TransactionRepository;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 */
public class AccountServiceImplTest {
	
	private static final String DESCRIPTION_1 = "New description";
	private static final BigDecimal AMOUNT_10 = new BigDecimal("10.0");
	private static final int ACCOUNT_NUMBER_2 = 2;
	private static final int AGENCY_NUMBER_1 = 1;
	private static final int ACCOUNT_NUMBER_1 = 1;

	@Mock
	private AccountHolderRepository accountHolderRepository;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private AccountServiceImpl accountService = new AccountServiceImpl();
	
	@Before

	@Test
	public void shouldTransferAmountWhenBalanceIsEnough() {
		/*
		TransactionJson transaction = new TransactionJson(
				ACCOUNT_NUMBER_1, AGENCY_NUMBER_1, ACCOUNT_NUMBER_2, AGENCY_NUMBER_1, AMOUNT_10, DESCRIPTION_1);
		AccountHolderId accountHolderId1 = new AccountHolderId(1L, "51271204452", new Account(ACCOUNT_NUMBER_1, AGENCY_NUMBER_1));
		
		accountService.transfer(transaction);
		
		Mockito.verify(accountHolderRepository).findOne(Mockito.any(AccountHolderId.class));
		*/
	}
}
