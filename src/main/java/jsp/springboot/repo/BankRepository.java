package jsp.springboot.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.springboot.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

	Optional<Bank> findByifscCode(String ifscCode);
	
	Optional<Bank> findByAddress(String address);
	
}
