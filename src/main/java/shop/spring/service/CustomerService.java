package shop.spring.service;

import java.util.List;

import shop.spring.dao.CustomerDao;
import shop.spring.vo.CustomerVo;

public interface CustomerService {

	void addCustomer(CustomerVo customerVo);

	void deleteCustomer(CustomerVo customerVo);

	void updateCustomer(CustomerVo customerVo);

	CustomerVo getCustomerById(int id);

	List<CustomerVo> getCustomers();

	CustomerDao getCustomerDao();

}
