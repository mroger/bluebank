package br.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bluebank.model.Transaction;

@Transactional(readOnly = true)
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
