package zafar.net.Bank.Transaction.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zafar.net.Bank.Transaction.System.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}