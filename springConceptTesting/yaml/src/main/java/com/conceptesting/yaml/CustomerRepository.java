package com.conceptesting.yaml;


import com.conceptesting.yaml.modelo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);


}
