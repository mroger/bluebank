package br.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

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

}
