package br.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.model.Account;
import br.com.bluebank.model.AccountId;

@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, AccountId> {

}
