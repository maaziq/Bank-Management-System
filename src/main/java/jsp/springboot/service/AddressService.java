package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Address;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordFoundException;
import jsp.springboot.repo.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo;
	
	
	public ResponseStructure<Address> fetchAddressbyId(Integer id){
		
		ResponseStructure<Address> res = new ResponseStructure<>();
		Optional<Address> opt = addressRepo.findById(id);
		
		if(opt.isPresent()) {
			res.setStatusCode(HttpStatus.OK.value());
			res.setMessage("Address is fetched with id!!");
			res.setData(opt.get());
		}
		
		return res;
	}
	
	
	public ResponseStructure<Address> updateAddress(Address address){
		
		ResponseStructure<Address> res = new ResponseStructure<>();
		if(address.getAddressId()==null)
			throw new IdNotFoundException("Id not exist in db!!");
		
		Optional<Address> opt = addressRepo.findById(address.getAddressId());
		
		if(opt.isPresent()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setData(addressRepo.save(address));
			res.setMessage("Address is updated!!");
			
			return res;
		}
		else 
			throw new IdNotFoundException("Id not exist in db!!");
		
	}
	
	
	public ResponseStructure<Address> findByBank(Integer bankId){
		
		ResponseStructure<Address> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(addressRepo.findAddressByBankId(bankId));
		res.setMessage("Address is fetch by bank id!!");
		
		return res;
	}
	
	
	public ResponseStructure<List<Address>> findByCity(String city){
		
		List<Address> add = addressRepo.findByCity(city);
		ResponseStructure<List<Address>> res = new ResponseStructure<>();
		
		if(!add.isEmpty()) {
		res.setStatusCode(HttpStatus.OK.value());
		res.setData(add);
		res.setMessage("Address is fetch with the city!!");
		
		return res;
		}
		else 
			throw new NoRecordFoundException("No city found in the Db!");
		
	}
	
	
	public ResponseStructure<List<Address>> findByCityStreet(String city, String street){
		
		List<Address> alist = addressRepo.findByCityAndStreet(city, street);
		
		ResponseStructure<List<Address>> res = new ResponseStructure<>();
		
		if(!alist.isEmpty()) {
			
			res.setStatusCode(HttpStatus.OK.value());
			res.setData(alist);
			res.setMessage("Address is fetch with the city!!");
			
			return res;
		}
		else 
			throw new NoRecordFoundException("No city found in the Db!");
	}
	
	
	public ResponseStructure<List<Address>> findByPincode(Integer pincode){
		
			List<Address> list = addressRepo.findByPincode(pincode);
			
			ResponseStructure<List<Address>> res = new ResponseStructure<>();
			
			if(!list.isEmpty()) {
				
				res.setStatusCode(HttpStatus.OK.value());
				res.setData(list);
				res.setMessage("Address is fetch with the city!!");
				
				return res;
			}
			else 
				throw new NoRecordFoundException("No city found in the Db!");
		}
}

