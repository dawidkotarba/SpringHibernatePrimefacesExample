package shop.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import shop.spring.serviceImpl.CustomerServiceImpl;
import shop.spring.vo.CustomerVo;

@ManagedBean
@ViewScoped
public class CustomerBean implements Serializable {

	private static final long serialVersionUID = -2050042525534142020L;

	@ManagedProperty(value = "#{customerService}")
	private CustomerServiceImpl customerService;

	private CustomerVo customer;
	private List<CustomerVo> customerList;

	@PostConstruct
	private void init() {
		customer = new CustomerVo();
	}

	private boolean addCustomerToDb() {

		try {
			getCustomerService().addCustomer(customer);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void addCustomer(){
		String msg = null;
		
		if (addCustomerToDb())
			msg = "Customer has been added successfully";
		else
			msg = "Cannot add this customer";
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		
		// reload customers for table
		getCustomersFromDb();
		
	}

	private boolean getCustomersFromDb() {
		setCustomerList(new ArrayList<CustomerVo>());
		getCustomerList().addAll(getCustomerService().getCustomers());
		
		return !getCustomerList().isEmpty();		
	}
	
	public List<CustomerVo> populateCustomers(){
		String msg = null;
		if (getCustomersFromDb())
			msg = "Customers have been loaded.";
		else
			msg = "Cannot load any customer.";
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		
		return getCustomerList();		
	}

	public CustomerServiceImpl getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

	public CustomerVo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVo customer) {
		this.customer = customer;
	}

	public List<CustomerVo> getCustomerList() {
		
		if (customerList == null)
			populateCustomers();
		
		return customerList;
	}

	public void setCustomerList(List<CustomerVo> customerList) {
		this.customerList = customerList;
	}
}