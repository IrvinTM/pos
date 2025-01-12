package com.irvin.pos.repositories; import org.springframework.data.jpa.repository.JpaRepository;
import com.irvin.pos.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer getByIdentification(String identification);

    public Customer getByPhoneNumber(String phoneNumber);

    public Customer getByEmail(String email);
}
