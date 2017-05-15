package br.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.model.Account;
import br.com.bluebank.model.AccountId;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Account repository
 * Transaction read only by default
 */
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, AccountId> {

}
