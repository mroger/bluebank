package br.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.model.AccountHolder;
import br.com.bluebank.model.AccountHolderId;

@Transactional(readOnly = true)
public interface AccountHolderRepository extends JpaRepository<AccountHolder, AccountHolderId> {

}
