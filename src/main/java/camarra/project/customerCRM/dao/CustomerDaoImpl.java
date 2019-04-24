package camarra.project.customerCRM.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import camarra.project.customerCRM.entity.Customer;
import camarra.project.customerCRM.entity.CustomerOrder;
import camarra.project.customerCRM.entity.TotalPriceView;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private EntityManager entityManager;

	@Autowired
	public CustomerDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
		// TODO Auto-generated constructor stub
	}

	// GETTING CUSTOMER'S ORDERS BY CALLING THE CUSTOMER IS POSSIBLE BY LATER
	// CALLING Customer.getOrders
	@Transactional
	public Customer getCustomer(int customerId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Customer theCustomer = currentSession.get(Customer.class, customerId);

		return theCustomer;
	}

	@Override
	public List<Customer> getCustomers() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Customer> theQuery = currentSession.createQuery("FROM Customer order by lastName", Customer.class);

		return theQuery.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public void deleteCustomer(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Customer where iid=: customerId")
				.setParameter("customerId", theId);

		theQuery.executeUpdate();

	}

	public void deleteCustomers(int[] theIds) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Customer where id in (:ids)").setParameter("ids",
				theIds);

		int result=theQuery.executeUpdate();
	}

	public List<CustomerOrder> getCustomersFromOrder() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<CustomerOrder> theQuery = currentSession.createQuery("FROM CustomerOrder", CustomerOrder.class);
		List<CustomerOrder> customers = theQuery.getResultList();

		System.out.println(customers);

		return customers;

	}

	// GETTING CUSTOMER'S ORDERS BY CALLING CustomerOrder and using "WHERE
	// customer.id=: id passed through parameter!
	public List<CustomerOrder> getOrdersMadeByCustomer(int customerId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<CustomerOrder> query = currentSession
				.createQuery("FROM CustomerOrder where customer.id= :customerId", CustomerOrder.class)
				.setParameter("customerId", customerId);

		List<CustomerOrder> orders = query.getResultList();

		return orders;

	}

	public List<TotalPriceView> getTotalPricePerCustomer() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<TotalPriceView> theQuery = currentSession.createQuery("From TotalPriceView", TotalPriceView.class);
		List<TotalPriceView> pricePerCustomerList = theQuery.getResultList();

		return pricePerCustomerList;

	}

	public TotalPriceView getCustomerTotalPrice(int customerId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<TotalPriceView> query = currentSession
				.createQuery("from TotalPriceView where customerId= :customerId", TotalPriceView.class)
				.setParameter("customerId", customerId);
		TotalPriceView customerPrice = query.getSingleResult();

		return customerPrice;
	}

	public Customer findCustomerByFirstAndLastName(String first, String last) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Customer> query = currentSession
				.createQuery("FROM Customer where firstName= :firstName AND lastName= :lastName", Customer.class)
				.setParameter("firstName", first).setParameter("lastName", last);

		Customer theCustomer = query.getSingleResult();
		return theCustomer;

	}

}
