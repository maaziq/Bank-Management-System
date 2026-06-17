package jsp.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Bank;
import jsp.springboot.repo.BankRepository;

@Service
public class BankService {
	
	@Autowired
	private BankRepository bankRepository;
	
	
	
	public ResponseStructure<Bank> saveBank(Bank bank){
		
		ResponseStructure<Bank> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("Bank saved Successfully!!");
		res.setData(bankRepository.save(bank));
		
		return res;
	}
	

	public ResponseStructure<List<Bank>> fetchAll() {
		
		ResponseStructure<List<Bank>> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setMessage("All the Bank is fetched!!");
		res.setData(bankRepository.findAll());
		return res;
	}
	
	
	public ResponseStructure<Bank> fetchBankById(Integer id){
		
		ResponseStructure<Bank> res = new ResponseStructure<>();
		
		Optional<Bank> opt = bankRepository.findById(id);
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Bank is fetched");
			res.setData(opt.get());
		}
		return res;
	}
	
	
	public ResponseStructure<Bank> fetchBankByIfsc(String ifscCode){
		
		ResponseStructure<Bank> res = new ResponseStructure<>();
		
		Optional<Bank> opt = bankRepository.findByifscCode(ifscCode);
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Bank is fetch with the ifsc code!!");
			res.setData(opt.get());
		}
		return res;
	}  
	
	
	public ResponseStructure<Bank> fetchBankByAddress(String address){
		
		ResponseStructure<Bank> res = new ResponseStructure<>();
		
		Optional<Bank> opt = bankRepository.findByAddress(address);
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Bank is fetched by Address!!");
			res.setData(opt.get());
		}
		return res;
	}

}
