package hello.controller;

import hello.entity.Customer;
import hello.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CustomerController {

        @Autowired
        ICustomerService customerService;

        @PostMapping("/addCustomer")
        public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
            Customer newCustomer = new Customer(customer.getFirstName(), customer.getLastName());
            customerService.save(newCustomer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

        }

        @GetMapping("/getAllCustomer")
        public ResponseEntity<List<Customer>> getAllCustomer(){
            return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        }

        @PutMapping("/updateCustomer/{id}")
        public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                                       @RequestParam(value = "firstName", defaultValue = "Maria") String firstName,
                                                       @RequestParam(value = "lastName", defaultValue = "Perez") String lastName){
            try{
                return new ResponseEntity<>(customerService.updateCustomer(id, firstName, lastName), HttpStatus.OK);
            } catch (NoSuchElementException ne){
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        }

        @DeleteMapping("/deleteCustomer/{id}")
        public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
            try{
                return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
            }  catch (NoSuchElementException ne){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
}
