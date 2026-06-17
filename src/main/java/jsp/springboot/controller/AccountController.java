package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Account;
import jsp.springboot.service.AccountService;

@RequestMapping("/account")
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	

	@PostMapping
	public ResponseEntity<ResponseStructure<Account>> saveAccount(@RequestBody Account account){
		
		return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Account>> fetchAccount(@PathVariable Integer id){
		
		return new ResponseEntity<>(accountService.fetchAccountById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Account>>> fetchAllAccount(){
		
		return new ResponseEntity<>(accountService.findAllAccount(), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAccount(@PathVariable Integer id){
		
		return new ResponseEntity<>(accountService.deleteAccount(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public ResponseEntity<ResponseStructure<Account>> depositAmount(@PathVariable Long accountNumber, @PathVariable Double amount){
		
		return new ResponseEntity<>(accountService.depositAmount(accountNumber, amount), HttpStatus.OK);
	}
	
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public ResponseEntity<ResponseStructure<Account>> withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount){
		
		return new ResponseEntity<>(accountService.withdrawAmount(accountNumber, amount), HttpStatus.OK);
	}
	
	
	@PutMapping("transfer/{accountNumber1}/{accountNumber2}/{amount}")
	public ResponseEntity<ResponseStructure<List<Account>>> transferAmount(@PathVariable Long accountNumber1, @PathVariable  Long accountNumber2, @PathVariable Double amount){
		
		return new ResponseEntity<>(accountService.transferAmount(accountNumber1, accountNumber2, amount), HttpStatus.OK);
	}
	
	
	@GetMapping("/type/{accountType}")
	public ResponseEntity<ResponseStructure<List<Account>>> fetchByAccountType(@PathVariable String accountType){
		
		return new ResponseEntity<>(accountService.fetchByAccountType(accountType), HttpStatus.OK);
	}
	
	
	@GetMapping("/balance/{amount}")
	public ResponseEntity<ResponseStructure<List<Account>>> fetchByAccountBalance(@PathVariable Double amount){
		
		return new ResponseEntity<>(accountService.fetchBalanceGreaterThan(amount), HttpStatus.OK);
	}
	
	
	@GetMapping("/sort/{field}")
	public ResponseEntity<ResponseStructure<List<Account>>> findBysort(@PathVariable String field){
		
		return new ResponseEntity<>(accountService.fetchAccountBySorting(field), HttpStatus.OK);
	}
	
	
}








