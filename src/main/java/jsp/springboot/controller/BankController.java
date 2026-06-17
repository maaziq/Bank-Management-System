package jsp.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Bank;
import jsp.springboot.service.BankService;

@RequestMapping("/bank")
@RestController
public class BankController {

	@Autowired
	private BankService bankService;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Bank>> saveBank(@RequestBody Bank bank){
		
		return new ResponseEntity<>(bankService.saveBank(bank), HttpStatus.OK);
	}
	

	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Bank>>> getAllBank(){
		
		return new ResponseEntity<>(bankService.fetchAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Bank>> getBank(@PathVariable Integer id){
		
		return new ResponseEntity<>(bankService.fetchBankById(id), HttpStatus.OK);
	}  
	
	
	@GetMapping("/ifsc/{ifsc}")
	public ResponseEntity<ResponseStructure<Bank>> getBankByIfsc(@PathVariable String ifsc){
		
		return new ResponseEntity<>(bankService.fetchBankByIfsc(ifsc), HttpStatus.OK);
	}
	
	
	@GetMapping("/address/{address}")
	public ResponseEntity<ResponseStructure<Bank>> getBankByAddress(@PathVariable String address){
		
		return new ResponseEntity<>(bankService.fetchBankByAddress(address), HttpStatus.OK);
	}
	
	
	
}
