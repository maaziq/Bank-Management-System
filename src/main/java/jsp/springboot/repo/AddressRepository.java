package jsp.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jsp.springboot.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	@Query("SELECT b.address FROM Bank b WHERE b.id = :bankId")
    Address findAddressByBankId(@Param("bankId") int bankId);
	
	
	@Query("SELECT a FROM Address a WHERE a.city = :city")
	List<Address> findByCity(@Param("city") String city);
	
	
	@Query("SELECT a FROM Address a WHERE a.city = :city AND a.street = :street")
	List<Address> findByCityAndStreet(@Param("city") String city, @Param("street") String street);
	
	
	@Query("SELECT a FROM Address a WHERE a.pincode = :pincode")
	List<Address> findByPincode(@Param("pincode") Integer pincode);

}
