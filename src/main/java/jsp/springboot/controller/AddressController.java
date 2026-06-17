package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Address;
import jsp.springboot.service.AddressService;

@RequestMapping("/address")
@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Address>> findAddressById(@PathVariable Integer id){
		
		return new ResponseEntity<>(addressService.fetchAddressbyId(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address){
		
		return new ResponseEntity<ResponseStructure<Address>>(addressService.updateAddress(address), HttpStatus.OK);
	}
 
	
	@GetMapping("/bank/{id}")
	public ResponseEntity<ResponseStructure<Address>> findByBank(@PathVariable Integer id){
		
		return new ResponseEntity<ResponseStructure<Address>>(addressService.findByBank(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/city/{city}")
	public ResponseEntity<ResponseStructure<List<Address>>> findByCity(@PathVariable String city){
		
		return new ResponseEntity<ResponseStructure<List<Address>>>(addressService.findByCity(city), HttpStatus.OK);
	}
	
	
	@GetMapping("/citystreet/{city}/{street}")
	public ResponseEntity<ResponseStructure<List<Address>>> findByCityAndStreet(@PathVariable String city, @PathVariable String street){
		
		return new ResponseEntity<ResponseStructure<List<Address>>>(addressService.findByCityStreet(city, street), HttpStatus.OK);
	}
	
	
	@GetMapping("/pincode/{pincode}")
	public ResponseEntity<ResponseStructure<List<Address>>> findByPincode(@PathVariable Integer pincode){
		
		return new ResponseEntity<>(addressService.findByPincode(pincode), HttpStatus.OK);
	}
	
	
}


