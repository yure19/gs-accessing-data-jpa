package hello.repository;

import hello.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstName(String firstName);
}
