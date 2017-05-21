package br.com.bluebank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.model.Account;
import br.com.bluebank.model.Transaction;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Transaction repositpry
 * Transaction read only by default 
 */
@Transactional(readOnly = true)
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query("select t from Transaction t where t.accountFrom = ?1 or t.accountTo = ?1 order by t.id")
	List<Transaction> findByAccount(Account account);

}
