package jsp.springboot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	Optional<Account> findByaccountNumber(Long accountNumber);
	
	List<Account> findByaccountType(String accountType);
	
	List<Account> findBybalanceGreaterThan(Double amount);
}
