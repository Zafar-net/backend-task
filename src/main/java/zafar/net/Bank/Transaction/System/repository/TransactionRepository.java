package zafar.net.Bank.Transaction.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zafar.net.Bank.Transaction.System.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}