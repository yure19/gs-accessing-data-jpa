package hello.service;

import hello.entity.Customer;
import hello.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> allCustomers = new ArrayList<>();

        for (Customer customer : customerRepository.findAll()){
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    public Customer updateCustomer(Long id, String firstName, String lastName) throws NoSuchElementException {
        Customer customer = customerRepository.findById(id).get();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        save(customer);
        return customer;
    }

    public Customer deleteCustomer(Long id) throws NoSuchElementException{
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
        return customer;
    }
}
