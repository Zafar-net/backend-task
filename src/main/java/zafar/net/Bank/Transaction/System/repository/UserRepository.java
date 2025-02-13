package zafar.net.Bank.Transaction.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zafar.net.Bank.Transaction.System.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}