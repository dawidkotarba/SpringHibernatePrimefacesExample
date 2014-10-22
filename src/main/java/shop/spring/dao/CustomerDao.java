package shop.spring.dao;

import java.util.List;

import shop.spring.entities.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);

	void deleteCustomer(Customer customer);

	void updateCustomer(Customer customer);

	Customer getCustomerById(int id);

	List<Customer> getCustomers();
}
