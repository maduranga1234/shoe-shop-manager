package lk.ijse.gdse66.backend.repositry;

import lk.ijse.gdse66.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    Customer findTopByOrderByCodeDesc();
    List<Customer> findByNameStartingWith(String name);
    Customer findByCode(String id);

    @Query("SELECT c.code FROM Customer c")
    List<String> findAllCustomerCodes();


}
