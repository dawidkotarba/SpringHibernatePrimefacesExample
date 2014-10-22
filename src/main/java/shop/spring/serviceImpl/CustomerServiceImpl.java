package shop.spring.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import shop.spring.service.CustomerService;
import shop.spring.vo.CustomerVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.spring.daoImpl.CustomerDaoImpl;
import shop.spring.entities.Customer;

@Service("customerService")
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDaoImpl CustomerDao;

	@Transactional(readOnly = false)
	public void addCustomer(CustomerVo customerVo) {

		Customer customer = new Customer();
		BeanUtils.copyProperties(customerVo, customer);
		getCustomerDao().addCustomer(customer);
	}

	@Transactional(readOnly = false)
	public void deleteCustomer(CustomerVo customerVo) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerVo, customer);
		getCustomerDao().deleteCustomer(customer);
	}

	@Transactional(readOnly = false)
	public void updateCustomer(CustomerVo customerVo) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerVo, customer);
		getCustomerDao().updateCustomer(customer);
	}

	public CustomerVo getCustomerById(int id) {
		Customer customer = getCustomerDao().getCustomerById(id);
		CustomerVo customerVo = new CustomerVo();
		BeanUtils.copyProperties(customer, customerVo);
		return customerVo;
	}

	public List<CustomerVo> getCustomers() {
		List<Customer> customerList = getCustomerDao().getCustomers();

		List<CustomerVo> customerVoList = new ArrayList<CustomerVo>();

		for (Customer cust : customerList) {
			CustomerVo custVo = new CustomerVo();
			BeanUtils.copyProperties(cust, custVo);
			customerVoList.add(custVo);
		}

		return customerVoList;

	}

	public CustomerDaoImpl getCustomerDao() {
		return CustomerDao;
	}

	public void setCustomerDao(CustomerDaoImpl CustomerDao) {
		this.CustomerDao = CustomerDao;
	}
}