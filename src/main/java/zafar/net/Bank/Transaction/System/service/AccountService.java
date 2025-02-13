package zafar.net.Bank.Transaction.System.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zafar.net.Bank.Transaction.System.entity.Account;
import zafar.net.Bank.Transaction.System.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Transactional
    public Account deposit(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance().add(amount));
        return accountRepository.save(account);
    }

    @Transactional
    public Account withdraw(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(amount));
        return accountRepository.save(account);
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        withdraw(fromAccountId, amount);
        deposit(toAccountId, amount);
    }
}
