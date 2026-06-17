package jsp.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Account;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.IlligleExpressionException;
import jsp.springboot.exception.NoRecordFoundException;
import jsp.springboot.repo.AccountRepository;

@Service
public class AccountService {

	@Autowired 
	private AccountRepository accountRepository;
	
	
	public ResponseStructure<Account> saveAccount(Account account){
		
		ResponseStructure<Account> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(accountRepository.save(account));
		res.setMessage("Account is saved in the database!!");
		
		return res;
	}
	
	
	public ResponseStructure<Account> fetchAccountById(Integer id){
		
		ResponseStructure<Account> res = new ResponseStructure<>();
		
		Optional<Account> opt = accountRepository.findById(id);
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(opt.get());
		res.setMessage("Account is fetch with id!");
		
		return res;
	}
	
	
	public ResponseStructure<List<Account>> findAllAccount(){
		
		List<Account> list = accountRepository.findAll();
		
		ResponseStructure<List<Account>> res = new ResponseStructure<>();
		
		if(!list.isEmpty()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setData(list);
			res.setMessage("All Account is fetch with!");
			
			return res;
		}
		else 
			 throw new NoRecordFoundException("No Data Found in Db!!");
		
	}
	
	
	public ResponseStructure<String> deleteAccount(Integer id){
		
		Optional<Account> opt = accountRepository.findById(id);
		
		ResponseStructure<String> res = new ResponseStructure<>();
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Record deleted succesfully!!");
			res.setData("Success");
			accountRepository.delete(opt.get());
			
			return res;
		}
		else 
			throw new IdNotFoundException("Id not found in the Db!!");
	}
	
	
	
	public ResponseStructure<Account> depositAmount(Long accountNumber, Double amount){
		
		Account account = accountRepository.findByaccountNumber(accountNumber)
				.orElseThrow(() -> new NoRecordFoundException("No Account Exist with this Account Number!!"));
		
		if(amount<=0)
			throw new IlligleExpressionException("Amount entered is inValid!!");
		
		account.setBalance(account.getBalance()+ amount);
		
		Account updatedAccount = accountRepository.save(account);
		
		ResponseStructure<Account> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(updatedAccount);
		res.setMessage("Amount Deposited successfully!");
		
		return res;
		
	}
	
	
	public ResponseStructure<Account> withdrawAmount(Long accountNumber, Double amount){
		
		Account account = accountRepository.findByaccountNumber(accountNumber)
				.orElseThrow(() -> new NoRecordFoundException("No Account Exist with this Account Number!!"));
		
		if(amount<=0 || amount>account.getBalance())
			throw new IlligleExpressionException("Amount entered is inValid!!");
		
		account.setBalance(account.getBalance()-amount);
		
		ResponseStructure<Account> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(accountRepository.save(account));
		res.setMessage("Amount Withdraw Successfully!!");
		
		return res;
		
	}
	
	
	public ResponseStructure<List<Account>> transferAmount(Long accountNumber1, Long accountNumber2, Double amount){
		
		Account account1 = accountRepository.findByaccountNumber(accountNumber1)
				.orElseThrow(() -> new NoRecordFoundException("No Account Exist with this Account Number!!"));
		
		Account account2 = accountRepository.findByaccountNumber(accountNumber2)
				.orElseThrow(() -> new NoRecordFoundException("No Account Exist with this Account Number!!"));
		
		if(amount<=0 || amount>account1.getBalance())
			throw new IlligleExpressionException("Amount entered is inValid!!");
		
		account1.setBalance(account1.getBalance()-amount);
		
		account2.setBalance(account2.getBalance()+amount);
		
		List<Account> list = new ArrayList<>();
		
		list.add(accountRepository.save(account1));
		list.add(accountRepository.save(account2));
		
		ResponseStructure<List<Account>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(list);
		res.setMessage("Amount Withdraw Successfully!!");
		
		return res;
		
	}
	
	public ResponseStructure<List<Account>> fetchByAccountType(String accountType){
		
		List<Account> list = accountRepository.findByaccountType(accountType);
		
		ResponseStructure<List<Account>> res = new ResponseStructure<>();
		
		if(!list.isEmpty()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(list);
		res.setMessage("Account fetched by account Types!!");
		
		return res;
		}
		else
			throw new NoRecordFoundException("No record found by such type in the Database!!");
	}
	
	
	public ResponseStructure<List<Account>> fetchBalanceGreaterThan(Double amount){
		
		List<Account> list = accountRepository.findBybalanceGreaterThan(amount);
		
		ResponseStructure<List<Account>> res = new ResponseStructure<>();
		
		if(!list.isEmpty()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setData(list);
			res.setMessage("Record with balance greather than is fetched!!");
			
			return res;
		}
		else
			throw new NoRecordFoundException("No record found by such balance in the Database!!");
	}
	
	
	public ResponseStructure<List<Account>> fetchAccountBySorting(String field){
		
		List<Account> list = accountRepository.findAll(Sort.by(field).ascending());
		
		ResponseStructure<List<Account>> res = new ResponseStructure<>();
		
		if(!list.isEmpty()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(list);
		res.setMessage("Record is fetched by sorting!!");
		
		return res;
		}
		else
			throw new NoRecordFoundException("No record available in Db");
	}
	
}









