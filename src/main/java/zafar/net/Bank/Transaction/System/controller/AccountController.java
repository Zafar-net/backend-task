package zafar.net.Bank.Transaction.System.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zafar.net.Bank.Transaction.System.entity.Account;
import zafar.net.Bank.Transaction.System.service.AccountService;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(@PathVariable Long id, @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(accountService.deposit(id, amount));
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(@PathVariable Long id, @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(accountService.withdraw(id, amount));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam BigDecimal amount) {
        accountService.transfer(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("Transfer successful");
    }
}
