package shop.spring.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.spring.entities.Customer;
import shop.spring.service.CustomerService;
import shop.spring.vo.CustomerVo;
import shop.spring.dao.CustomerDao;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerDao CustomerDao;

	@Override
	@Transactional(readOnly = false)
	public void addCustomer(CustomerVo customerVo) {

		Customer customer = new Customer();
		BeanUtils.copyProperties(customerVo, customer);
		getCustomerDao().addCustomer(customer);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCustomer(CustomerVo customerVo) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerVo, customer);
		getCustomerDao().deleteCustomer(customer);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateCustomer(CustomerVo customerVo) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerVo, customer);
		getCustomerDao().updateCustomer(customer);
	}

	@Override
	public CustomerVo getCustomerById(int id) {
		Customer customer = getCustomerDao().getCustomerById(id);
		CustomerVo customerVo = new CustomerVo();
		BeanUtils.copyProperties(customer, customerVo);
		return customerVo;
	}

	@Override
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

	@Override
	public CustomerDao getCustomerDao() {
		return CustomerDao;
	}

	public void setCustomerDao(CustomerDao CustomerDao) {
		this.CustomerDao = CustomerDao;
	}
}