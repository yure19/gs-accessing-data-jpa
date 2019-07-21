package hello.service;

import hello.entity.Customer;

import java.util.List;
import java.util.NoSuchElementException;

public interface ICustomerService {

    public void save(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer updateCustomer(Long id, String firstName, String lastName) throws NoSuchElementException;

    public Customer deleteCustomer(Long id) throws NoSuchElementException;
}
