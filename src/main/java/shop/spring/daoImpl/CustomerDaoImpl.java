package shop.spring.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import shop.spring.dao.CustomerDao;
import shop.spring.entities.Customer;

@Repository
public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.idEq(id));
		return  (Customer) criteria.uniqueResult();	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {

		Criteria criteria = getSession().createCriteria(Customer.class);		
		return criteria.list();
	}
}