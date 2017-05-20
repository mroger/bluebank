package br.com.bluebank.service;

import java.math.BigDecimal;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.bluebank.exception.AccountNotEnoughFundsException;
import br.com.bluebank.exception.AccountNotFoundException;
import br.com.bluebank.exception.EqualAccountsException;
import br.com.bluebank.model.Account;
import br.com.bluebank.model.AccountId;
import br.com.bluebank.model.json.TransactionJson;
import br.com.bluebank.repository.AccountHolderRepository;
import br.com.bluebank.repository.AccountRepository;
import br.com.bluebank.repository.TransactionRepository;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
	
	private static class AnyAccount {
		static final int AGENCY = 0;
		static final int NUMBER = 0;
	}
	
	private static class AnyTransaction {
		static final BigDecimal AMOUNT = new BigDecimal("0.0");
		static final String DESCRIPTION = "";
	}
	
	private static class Transaction1 {
		static final BigDecimal AMOUNT = new BigDecimal("30.75");
		static final String DESCRIPTION = "Lunch";
	}
	
	private static class Transaction2 {
		static final BigDecimal AMOUNT = new BigDecimal("7.75");
		static final String DESCRIPTION = "Birthday gift";
	}
	
	private static class Account1 {
		static final int AGENCY = 1000;
		static final int NUMBER = 1100;
	}
	
	private static class Account2 {
		static final int AGENCY = 2000;
		static final int NUMBER = 2100;
		static final BigDecimal BALANCE = new BigDecimal("15.0");
	}
	
	private static class Account3 {
		static final int AGENCY = 3000;
		static final int NUMBER = 3100;
		static final BigDecimal BALANCE = new BigDecimal("20.75");
	}
	
	private static final AccountId ACCOUNT_ID_NOT_FOUND = new AccountId(Account1.NUMBER, Account1.AGENCY);
	
	private static final AccountId ACCOUNT_ID_2 = new AccountId(Account2.NUMBER, Account2.AGENCY);
	private static final Account ACCOUNT_2 = new Account(Account2.NUMBER, Account2.AGENCY, Account2.BALANCE);
	
	private static final AccountId ACCOUNT_ID_3 = new AccountId(Account3.NUMBER, Account3.AGENCY);
	private static final Account ACCOUNT_3 = new Account(Account3.NUMBER, Account3.AGENCY, Account3.BALANCE);
	
	@Mock
	private AccountRepository accountRepository;

	@Mock
	private AccountHolderRepository accountHolderRepository;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private AccountServiceImpl accountService = new AccountServiceImpl();
	
	@Captor
	ArgumentCaptor<Account> accountCaptor;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		Mockito.when(accountRepository.findOne(ACCOUNT_ID_NOT_FOUND)).thenReturn(null);
		Mockito.when(accountRepository.findOne(ACCOUNT_ID_2)).thenReturn(ACCOUNT_2);
		Mockito.when(accountRepository.findOne(ACCOUNT_ID_3)).thenReturn(ACCOUNT_3);
		Mockito.when(accountRepository.save(ACCOUNT_2)).thenReturn(ACCOUNT_2);
		Mockito.when(accountRepository.save(ACCOUNT_3)).thenReturn(ACCOUNT_3);
	}

	@Test
	public void shouldRaiseExceptionWhenOriginAccountNotFound() {
		TransactionJson transactionJson = new TransactionJson(
				Account1.NUMBER, Account1.AGENCY, AnyAccount.NUMBER, AnyAccount.AGENCY, AnyTransaction.AMOUNT, AnyTransaction.DESCRIPTION);
		
		thrown.expect(AccountNotFoundException.class);
		thrown.expectMessage("Origin account not found");
		accountService.transfer(transactionJson);
	}
	
	@Test
	public void shouldRaiseExceptionWhenDestinationAccountNotFound() {
		TransactionJson transactionJson = new TransactionJson(
				Account2.NUMBER, Account2.AGENCY, Account1.NUMBER, Account1.AGENCY, AnyTransaction.AMOUNT, AnyTransaction.DESCRIPTION);
		
		thrown.expect(AccountNotFoundException.class);
		thrown.expectMessage("Destination account not found");
		accountService.transfer(transactionJson);
	}
	
	@Test
	public void shouldRaiseExceptionWhenOriginAndDestinationAccountsAreTheSame() {
		TransactionJson transactionJson = new TransactionJson(
				Account2.NUMBER, Account2.AGENCY, Account2.NUMBER, Account2.AGENCY, AnyTransaction.AMOUNT, AnyTransaction.DESCRIPTION);
		
		thrown.expect(EqualAccountsException.class);
		thrown.expectMessage("Origin and destination accounts are the same");
		accountService.transfer(transactionJson);
	}
	
	@Test
	public void shouldRaiseExceptionWhenThereAreNoEnoughFundsAvailable() {
		TransactionJson transactionJson = new TransactionJson(
				Account2.NUMBER, Account2.AGENCY, Account3.NUMBER, Account3.AGENCY, Transaction1.AMOUNT, Transaction1.DESCRIPTION);
		
		thrown.expect(AccountNotEnoughFundsException.class);
		thrown.expectMessage("Origin account has insufficient funds to complete this transaction");
		accountService.transfer(transactionJson);
	}
	
	@Test
	public void shouldTransferFundsBetweenAccounts() {
		TransactionJson transactionJson = new TransactionJson(
				Account2.NUMBER, Account2.AGENCY, Account3.NUMBER, Account3.AGENCY, Transaction2.AMOUNT, Transaction2.DESCRIPTION);
		
		accountService.transfer(transactionJson);
		
		Mockito.verify(accountRepository, Mockito.times(2)).save(accountCaptor.capture());
		Account origin = accountCaptor.getAllValues().get(0);
		Account destination = accountCaptor.getAllValues().get(1);
		
		MatcherAssert.assertThat(origin.getBalance(), Matchers.equalTo(new BigDecimal("7.25")));
		MatcherAssert.assertThat(destination.getBalance(), Matchers.equalTo(new BigDecimal("28.50")));
	}
}
