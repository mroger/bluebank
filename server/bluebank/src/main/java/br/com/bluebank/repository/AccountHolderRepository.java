package br.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.model.AccountHolder;
import br.com.bluebank.model.AccountHolderId;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * AccountHolder repository.
 * Transaction read ondy by default
 */
@Transactional(readOnly = true)
public interface AccountHolderRepository extends JpaRepository<AccountHolder, AccountHolderId> {

}
